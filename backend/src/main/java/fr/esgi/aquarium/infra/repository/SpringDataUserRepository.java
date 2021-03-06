package fr.esgi.aquarium.infra.repository;

import fr.esgi.aquarium.domain.exception.AquariumException;
import fr.esgi.aquarium.domain.exception.ExceptionCode;
import fr.esgi.aquarium.domain.model.User;
import fr.esgi.aquarium.domain.repository.UserRepository;
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
    private final UserMapper mapper;


    @Override
    public User findById(Long userId) {
        var user = userRepository.findById(userId);
        return user.isPresent() ? mapper.toModel(user.get()) : null;
    }

    @Override
    public User findByEmail(String email) {
        var user = userRepository.findByEmail(email);
        return user != null ? mapper.toModel(user) : null;
    }

    @Override
    public List<User> findAllByOrderByIdAsc() {
        return userRepository.findAllByOrderByIdAsc().stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public User save(User userFromDb) {
        if (userRepository.findByEmail(userFromDb.getEmail()) != null) {
            throw new AquariumException(ExceptionCode.ENTITY_CREATION_ERROR);
        }
        return mapper.toModel(userRepository.saveAndFlush(mapper.toEntity(userFromDb)));
    }

    @Override
    public User update(User userFromDb) {
        if (userRepository.findByEmail(userFromDb.getEmail()) == null) {
            throw new AquariumException(ExceptionCode.ENTITY_CREATION_ERROR);
        }
        return mapper.toModel(userRepository.saveAndFlush(mapper.toEntity(userFromDb)));
    }

    @Override
    public User findByPasswordResetCode(String code) {
        return mapper.toModel(userRepository.findByPasswordResetCode(code));
    }

    @Override
    public User findByActivationCode(String code) {
        var user = userRepository.findByActivationCode(code);
        return user != null ? mapper.toModel(userRepository.findByActivationCode(code)) : null;
    }
}
