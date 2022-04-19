package fr.esgi.aquarium.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User findUserById(Long userId) {
        return userRepository.findById(userId);
    }
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> findAllUsers() {
        return userRepository.findAllByOrderByIdAsc();
    }
    public User updateProfile(String email, User user) {
        User userFromDb = userRepository.findByEmail(email);
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setCity(user.getCity());
        userFromDb.setAddress(user.getAddress());
        userFromDb.setPhoneNumber(user.getPhoneNumber());
        userFromDb.setPostIndex(user.getPostIndex());
        userRepository.save(userFromDb);
        return userFromDb;
    }

}
