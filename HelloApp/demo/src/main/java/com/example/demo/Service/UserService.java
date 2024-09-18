package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> list = (List<User>) this.userRepository.findAll();
        return list;
    }

    public User creatUser(User user) {
        User result = userRepository.save(user);
        return result;
    }

    public User getUserById(int id) {
        User user = null;
        try {
            Optional<User> opuser = this.userRepository.findById(id);
            if (opuser.isPresent()) {
                user = opuser.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @SuppressWarnings("null")
    public User updateUser(int id, User userDetails) {
        User user = null;
        Optional<User> opuser = this.userRepository.findById(id);
        if (opuser.isPresent()) {
            user = opuser.get();
        }
        user.setEmail(userDetails.getEmail());
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        return userRepository.save(user);
    }

    public void deleteUser(int bid){
        userRepository.deleteById(bid);
    }

}
