package ru.zaharov.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zaharov.dto.NoDataFoundException;
import ru.zaharov.entity.User;
import ru.zaharov.repository.UserRepository;

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
        return userRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Клиент не найден", "NOT_FOUND"));
    }

}
