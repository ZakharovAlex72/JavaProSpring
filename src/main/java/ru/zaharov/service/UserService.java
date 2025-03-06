package ru.zaharov.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.zaharov.entity.User;
import ru.zaharov.repository.UserRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;

    public void createUser(String username){
        userRepository.createUser(username);
    }

    public void deleteUser(String username){
        userRepository.deleteUserByUsername(username);
    }

    public void deleteAllUsers(){
        userRepository.deleteAllUsers();
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
