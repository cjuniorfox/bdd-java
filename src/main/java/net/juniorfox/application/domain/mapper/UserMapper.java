package net.juniorfox.application.domain.mapper;

import net.juniorfox.application.domain.adapter.UserRequest;
import net.juniorfox.application.domain.adapter.UserResponse;
import net.juniorfox.application.domain.User;
import net.juniorfox.application.domain.entity.UserEntity;

public class UserMapper {

    private UserMapper() {
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.id(),
                user.name(),
                user.email()
        );
    }

    public static User toUser(UserRequest userRequest) {
        return new User(
                userRequest.nome(),
                userRequest.email()
        );
    }

    public static User toUser(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }

    public static UserEntity toUserEntity(User user){
        return new UserEntity(
                user.id(),
                user.name(),
                user.email()
        );
    }
}
