package hasanalmunawr.Dev.springproject2.utils;

import hasanalmunawr.Dev.springproject2.entity.RoleEntity;
import hasanalmunawr.Dev.springproject2.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.EMPTY;
//import static org.apache.logging.log4j.util.Strings.EMPTY;

public class UserUtils {

    public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .lastLogin(LocalDateTime.now())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .loginAttempts(0)
                .qrCodeSecret(EMPTY)
                .phone(EMPTY)
                .bio(EMPTY)
                .imageUrl(EMPTY)
                .roles(role)
                .build();
    }
}
