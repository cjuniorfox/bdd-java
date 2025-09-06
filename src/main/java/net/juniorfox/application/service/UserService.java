package net.juniorfox.application.service;

import net.juniorfox.application.domain.User;

public interface UserService {
    User create(User userEntity);

    User get(Long id);
}
