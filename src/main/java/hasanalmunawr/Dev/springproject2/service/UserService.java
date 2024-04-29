package hasanalmunawr.Dev.springproject2.service;

import hasanalmunawr.Dev.springproject2.entity.RoleEntity;
import hasanalmunawr.Dev.springproject2.entity.UserEntity;
import hasanalmunawr.Dev.springproject2.enumeration.Authority;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);

    RoleEntity getRoleName(String name);
}
