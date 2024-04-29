package hasanalmunawr.Dev.springproject2.service.impl;

import hasanalmunawr.Dev.springproject2.entity.ConfirmationEntity;
import hasanalmunawr.Dev.springproject2.entity.CredentialEntity;
import hasanalmunawr.Dev.springproject2.entity.RoleEntity;
import hasanalmunawr.Dev.springproject2.entity.UserEntity;
import hasanalmunawr.Dev.springproject2.enumeration.Authority;
import hasanalmunawr.Dev.springproject2.enumeration.EventType;
import hasanalmunawr.Dev.springproject2.event.UserEvent;
import hasanalmunawr.Dev.springproject2.exception.ApiException;
import hasanalmunawr.Dev.springproject2.repository.ConfirmationRepository;
import hasanalmunawr.Dev.springproject2.repository.CredentialRepository;
import hasanalmunawr.Dev.springproject2.repository.RoleRepository;
import hasanalmunawr.Dev.springproject2.repository.UserRepository;
import hasanalmunawr.Dev.springproject2.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.jar.JarEntry;

import static hasanalmunawr.Dev.springproject2.utils.UserUtils.createUserEntity;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher publisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        var userEntity = userRepository.save( createNewUser(firstName, lastName, email, password));
        var credentialEntity = new CredentialEntity(userEntity, password);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("Key", confirmationEntity.getKey())));
    }

    @Override
    public RoleEntity getRoleName(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return (RoleEntity) role.orElseThrow(() -> new ApiException("Role Not Found"));
    }

    private UserEntity createNewUser(String firstName, String lastName, String email, String password) {
        var role  = getRoleName(Authority.USER.getName());
        return createUserEntity(firstName, lastName, email, role);

    }


}
