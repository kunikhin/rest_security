package ru.kunikhin.rest_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kunikhin.rest_security.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("Select r from Role r where r.rolename = :rolename")
    Role findByRolename(String rolename);
}
