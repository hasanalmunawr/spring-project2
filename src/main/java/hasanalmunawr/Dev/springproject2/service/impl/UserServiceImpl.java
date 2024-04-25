package hasanalmunawr.Dev.springproject2.service.impl;

import hasanalmunawr.Dev.springproject2.repository.ConfirmationRepository;
import hasanalmunawr.Dev.springproject2.repository.CredentialRepository;
import hasanalmunawr.Dev.springproject2.repository.RoleRepository;
import hasanalmunawr.Dev.springproject2.repository.UserRepository;
import hasanalmunawr.Dev.springproject2.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void createUser(String firstName, String lastName, String email, String password) {

    }
}
