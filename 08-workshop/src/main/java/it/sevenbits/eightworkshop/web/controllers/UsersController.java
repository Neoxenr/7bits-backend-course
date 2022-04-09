package it.sevenbits.eightworkshop.web.controllers;

import it.sevenbits.eightworkshop.core.model.User;
import it.sevenbits.eightworkshop.web.model.request.users.AddUserRequest;
import it.sevenbits.eightworkshop.web.model.request.users.UpdateUserRequest;
import it.sevenbits.eightworkshop.web.model.response.users.AllUsersResponse;
import it.sevenbits.eightworkshop.web.service.users.IUserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for users
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    private final IUserService userService;

    /**
     * Create controller
     *
     * @param userService service for users
     */
    public UsersController(final IUserService userService) {
        this.userService = userService;
    }

    /**
     * Return all users
     *
     * @return response with meta data and list of users
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<AllUsersResponse> getAllUsers() {
        List<User> users = userService.getAll();

        AllUsersResponse response = new AllUsersResponse(users);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    /**
     * Return user
     *
     * @param userId - user id
     * @return response with user
     */
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable final String userId) {
        return Optional.ofNullable(userService.getById(userId))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Return created user
     *
     * @param addUserRequest - create user dto
     * @return response with created user
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid final AddUserRequest addUserRequest) {
        User user = userService.create(addUserRequest.getName());

        URI location = UriComponentsBuilder.fromPath("/users/").path(user.getId()).build().toUri();
        return ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).body(user);
    }

    /**
     * Return updated user
     *
     * @param userId            - user id
     * @param updateUserRequest - update user dto
     * @return response with updated user
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable final String userId, @RequestBody final UpdateUserRequest updateUserRequest) {
        return Optional.ofNullable(userService.update(userId, updateUserRequest.getName()))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Return deleted user
     *
     * @param userId - user id
     * @return response with deleted user
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable final String userId) {
        if (!isUUID(userId)) {
            return ResponseEntity.badRequest().build();
        }
        return Optional.ofNullable(userService.delete(userId))
                .map(post -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(post))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private boolean isUUID(final String testUUID) {
        if (testUUID == null) {
            return false;
        }
        return java.util.regex.Pattern.compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")
                .matcher(testUUID).find();
    }
}
