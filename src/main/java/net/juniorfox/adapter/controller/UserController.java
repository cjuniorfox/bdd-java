package net.juniorfox.adapter.controller;

import jakarta.validation.Valid;
import net.juniorfox.application.domain.adapter.UserRequest;
import net.juniorfox.application.domain.adapter.UserResponse;
import net.juniorfox.application.domain.mapper.UserMapper;
import net.juniorfox.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static net.juniorfox.application.domain.mapper.UserMapper.toUserResponse;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest){
        var user = UserMapper.toUser(userRequest);
        var persistedUser = userService.create(user);
        return ResponseEntity
                .status(CREATED.value())
                .body(toUserResponse(persistedUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        var user = userService.get(id);
        return ResponseEntity.ok(toUserResponse(user));
    }

}
