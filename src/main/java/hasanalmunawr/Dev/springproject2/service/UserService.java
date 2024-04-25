package hasanalmunawr.Dev.springproject2.service;

import hasanalmunawr.Dev.springproject2.entity.UserEntity;

public interface UserService {
    void createUser(String firstName, String lastName, String email, String password);
}
