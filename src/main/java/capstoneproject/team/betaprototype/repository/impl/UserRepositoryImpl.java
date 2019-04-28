package capstoneproject.team.betaprototype.repository.impl;

import capstoneproject.team.betaprototype.jpa.UserCrudRepository;
import capstoneproject.team.betaprototype.models.User;
import capstoneproject.team.betaprototype.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        List<User> tempList = new ArrayList<>();
        userCrudRepository.findAll().forEach(tempList::add);
        User[] userArray = new User[tempList.size()];
        int index = 0;
        for(User user : tempList){
            userArray[index] = user;
            index++;
        }
        sortByTime(userArray, index);
        for(int i = 0; i < index; i++){
            userList.add(userArray[i]);
        }
        return userList;
    }

    @Override
    public User create(User user){
        return userCrudRepository.save(user);
    }

    @Override
    public List<User> findCurrentUsers(String sortBy){
        List<User> userList = new ArrayList<>();
        List<User> tempList = new ArrayList<>();
        userCrudRepository.findAll().forEach(tempList::add);
        User[] userArray = new User[tempList.size()];
        int index = 0;
        for(User user : tempList){
            if(user.timeOut.equals("-")){
                userArray[index] = user;
                index++;
            }
        }
        switch(sortBy){
            case "timeIn":
                sortByTime(userArray, index);
                for(int i = 0; i < index; i++){
                    userList.add(userArray[i]);
                }
                break;
            default:
                for(int i = 0; i < index; i++){
                    userList.add(userArray[i]);
                }
                break;
        }
        return userList;
    }

    private void sortByTime(User[] userArray, int index) {
        for(int i = index - 1; i >= 0; i--){
            for(int j = 1; j <= index - 1; j++){
                if(convertTime(userArray[j - 1].timeIn) > convertTime(userArray[j].timeIn)){
                    User temp = userArray[j - 1];
                    userArray[j - 1] = userArray[j];
                    userArray[j] = temp;
                }
            }
        }
    }

    private int convertTime(String time){
        time = time.substring(0, time.length() - 2);
        int convertedTime;
        time = time.replace(":", "");
        convertedTime = Integer.parseInt(time);
        if(time.substring(time.length() - 2).equals("pm") && convertedTime != 1200){
            convertedTime += 1200;
        }
        return convertedTime;
    }

    @Override
    public int findActiveUsers(int time){
        int count = 0;
        List<User> user = findAll();
        for(User temp: user){
            if((convertTime(temp.timeIn) >= time && convertTime(temp.timeIn) < time+100) || (convertTime(temp.timeIn) <= time && !temp.timeOut.equals("-") && convertTime(temp.timeOut) >= time) ){
                count++;
            }
        }
        return count;
    }

   /* @Override
    public List<User> findById(int psuid){
        List<User> userList = new ArrayList<>();
        userCrudRepository.findAll().forEach(userList::add);
        return userList.stream()
    }
    */
}
