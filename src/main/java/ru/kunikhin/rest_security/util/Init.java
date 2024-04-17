package ru.kunikhin.rest_security.util;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kunikhin.rest_security.entities.Role;
import ru.kunikhin.rest_security.entities.User;
import ru.kunikhin.rest_security.services.RoleService;
import ru.kunikhin.rest_security.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initializedDataBase() {
        roleService.save(new Role("ADMIN"));
        roleService.save(new Role("USER"));

        Set<Role> adminRole =  new HashSet<>();
        Set<Role> userRole = new HashSet<>();
        Set<Role> allRoles = new HashSet<>();

        adminRole.add(roleService.findOne("ADMIN"));
        userRole.add(roleService.findOne("USER"));
        allRoles.add(roleService.findOne("ADMIN"));
        allRoles.add(roleService.findOne("USER"));

        userService.save(new User("admin@admin.ru", "admin", "Admin", "Adminov", (byte) 44, adminRole));
        userService.save(new User("user@user.ru", "user", "User", "Userov", (byte) 56, userRole));
        userService.save(new User("all@all.ru", "all", "All", "Allin", (byte) 16, allRoles));

    }
}
