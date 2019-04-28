package capstoneproject.team.betaprototype.jpa;

import capstoneproject.team.betaprototype.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
