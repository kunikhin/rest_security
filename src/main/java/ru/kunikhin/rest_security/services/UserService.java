package ru.kunikhin.rest_security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import ru.kunikhin.rest_security.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findOne();

    List<User> findAll();

    User findOne(Long id);

    User findOne(String username);

    @Transactional
    void save(User user);

    @Transactional
    void update(User user);

    void delete(Long id);

}
