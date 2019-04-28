package capstoneproject.team.betaprototype.service.impl;

import capstoneproject.team.betaprototype.models.User;
import capstoneproject.team.betaprototype.repository.UserRepository;
import capstoneproject.team.betaprototype.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){ return userRepository.findAll();}

    @Override
    public User create(User user){ return userRepository.create(user);}

    @Override
    public List<User> findCurrentUsers(String sortBy){return userRepository.findCurrentUsers(sortBy);}

    @Override
    public int findActiveUsers(int time){return userRepository.findActiveUsers(time);}
}
