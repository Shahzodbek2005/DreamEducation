package com.bluebird.DreamEducation.services;


import com.bluebird.DreamEducation.entities.Role;
import com.bluebird.DreamEducation.entities.User;
import com.bluebird.DreamEducation.repositories.RoleRepository;
import com.bluebird.DreamEducation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public Long isUserExists(String  username){
        return userRepository.isUserExist(username);
    }
    public String addUser(String username, String password, Long roleID){
        Set<Role> roles = new HashSet<>();
        if(isUserExists(username)==null){
            Role role = roleRepository.findById(roleID).orElse(null);
            if(role != null){
                if(role.getName().equals("ADMIN")){
                    roles.add(role);
                    Role roleUser = roleRepository.findByName("USER");
                    roles.add(roleUser);
                }
                else{
                    roles.add(role);
                }
                User user = new User();
                user.setUsername(username);
                user.setPassword(new BCryptPasswordEncoder().encode(password));

                user.setRole(roles);
                userRepository.save(user);
                return "User Saved!";
            }
            else{
                return "Role not fount. User not saved!";
            }
        }else{
            return "User already exist!";
        }



    }
}
