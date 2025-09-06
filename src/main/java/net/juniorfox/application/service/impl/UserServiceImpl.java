package net.juniorfox.application.service.impl;

import net.juniorfox.adapter.repository.UserRepository;
import net.juniorfox.application.domain.User;
import net.juniorfox.application.domain.mapper.UserMapper;
import net.juniorfox.application.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static net.juniorfox.application.domain.mapper.UserMapper.toUser;
import static net.juniorfox.application.domain.mapper.UserMapper.toUserEntity;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRespository;

    public UserServiceImpl(UserRepository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User create(User user) {
        return toUser(userRespository.save(toUserEntity(user)));
    }

    @Override
    public User get(Long id) {
        return userRespository.findById(id).map(UserMapper::toUser)
                .orElseThrow(() -> new ResponseStatusException(
                                NOT_FOUND, "Usuário não encontrado"
                        )
                );
    }
}
