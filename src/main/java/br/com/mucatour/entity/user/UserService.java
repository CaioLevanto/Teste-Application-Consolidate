package br.com.mucatour.entity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final User entity = new User();

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User find(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
    }

    public User create(User user) {
        return userRepository.save(entity.withCreate(user));
    }

    public User update( Long id, User newUser) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.save(entity.withUpdate(id, newUser));
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
