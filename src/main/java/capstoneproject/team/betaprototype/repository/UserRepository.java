package capstoneproject.team.betaprototype.repository;

import capstoneproject.team.betaprototype.models.User;
import java.util.List;

public interface UserRepository {

    List<User> findAll();
    User create(User user);
    List<User> findCurrentUsers(String sortBy);
    int findActiveUsers(int time);
}
