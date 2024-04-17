package ru.kunikhin.rest_security.services;

import ru.kunikhin.rest_security.entities.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoles();
    void save(Role role);
    Role findOne(String rolename);
}
