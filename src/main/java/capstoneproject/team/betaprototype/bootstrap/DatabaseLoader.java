package capstoneproject.team.betaprototype.bootstrap;

import capstoneproject.team.betaprototype.models.User;
import capstoneproject.team.betaprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        User u1 = new User(1, "Ryan", "Malone", "Front Tables", "10:01am", "-", "Power Tools & Safety");
        userRepository.create(u1);
        User u2 = new User(2, "Shrey", "Vyas", "Welding", "10:03am", "11:43am", "Power Tools & Safety");
        userRepository.create(u2);
        User u3 = new User(3, "John", "Kong", "Machining Room", "11:32am", "-", "Power Tools & Safety");
        userRepository.create(u3);
        User u4 = new User(4, "Darian", "Gim", "3D Printing Room", "11:33pm", "-", "Power Tools & Safety");
        userRepository.create(u4);
        User u5 = new User(5, "Brian", "Smith", "Front Tables", "9:05am", "10:20am", "Machining");
        userRepository.create(u5);
        User u6 = new User(6, "John", "Doe", "Front Tables", "9:33am", "10:44am", "Machining, Welding");
        userRepository.create(u6);
        User u7 = new User(7, "Jane", "Deer", "Machining Room", "11:32am", "-", "Power Tools & Safety");
        userRepository.create(u7);
        User u8 = new User(8, "Billy", "Mays", "Machining Room", "12:05pm", "-", "Machining");
        userRepository.create(u8);
        User u9 = new User(9, "Felix", "Kjellberg", "3D Printing Room", "8:05am", "9:30am", "Power Tools & Safety");
        userRepository.create(u9);
        User u10 = new User(10, "Anthony", "Ludwig", "Welding", "8:13am", "8:45am", "Welding");
        userRepository.create(u10);
        User u11 = new User(11, "Sam", "Allen", "Front Tables", "12:02pm", "1:20pm", "Power Tools & Safety");
        userRepository.create(u11);
        User u12 = new User(12, "Leon", "Lush", "3D Printing Room", "9:30am", "11:04am", "Power Tools & Safety");
        userRepository.create(u12);
        User u13 = new User(13, "Dan", "O'Connor", "Front Tables", "12:13pm", "-", "Power Tools & Safety");
        userRepository.create(u13);
    }
}
