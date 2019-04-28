package capstoneproject.team.betaprototype.service;

import capstoneproject.team.betaprototype.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User create(User user);
    List<User> findCurrentUsers(String sortBy);
    int findActiveUsers(int time);
}
