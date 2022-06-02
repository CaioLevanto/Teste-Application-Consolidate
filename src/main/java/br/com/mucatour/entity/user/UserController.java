package br.com.mucatour.entity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/menu/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> findAll() {
        List<User> items = userService.findAll();
        return ResponseEntity.ok().body("FUNFOU ????");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable("id") Long id) {
        Optional<User> item = Optional.ofNullable(userService.find(id));
        return ResponseEntity.of(item);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User created = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable("id") Long id,
            @RequestBody User updatedItem) {

        Optional<User> updated = Optional.ofNullable(userService.update(id, updatedItem));

        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> {
                    User created = userService.create(updatedItem);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(created.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(created);
                });
    }

    // ✨ New! 👇 DELETE definition ✨
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
