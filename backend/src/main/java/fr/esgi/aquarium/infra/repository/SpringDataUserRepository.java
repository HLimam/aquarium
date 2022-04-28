package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.User;
import fr.esgi.aquarium.domain.UserRepository;
import fr.esgi.aquarium.infra.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Primary
public class SpringDataUserRepository implements UserRepository {

    private final JPAUserRepository userRepository;
    private final UserMapper        mapper;


    @Override
    public User findById(Long userId) {
        var user = userRepository.findById(userId);
        if(user.isPresent()){
            return mapper.toModel(user.get());
        }else{
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        return mapper.toModel(userRepository.findByEmail(email));
    }

    @Override
    public List<User> findAllByOrderByIdAsc() {
        return userRepository.findAllByOrderByIdAsc().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User userFromDb) {
        return mapper.toModel(userRepository.saveAndFlush(mapper.toEntity(userFromDb)));
    }

    @Override
    public User findByPasswordResetCode(String code) {
        return mapper.toModel(userRepository.findByPasswordResetCode(code));
    }

    @Override
    public User findByActivationCode(String code) {
        return mapper.toModel(userRepository.findByActivationCode(code));
    }
}
