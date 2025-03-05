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
public class UserService implements CommandLineRunner {
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

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START");
        findAll().forEach(System.out::println);
        System.out.println("------------------");
        createUser("user99");
        System.out.println("CREATE_USER");
        findAll().forEach(System.out::println);
        System.out.println("------------------");
        System.out.println(findUserByUsername("user2"));
        System.out.println("FIND_USER");
        deleteUser("user1");
        System.out.println("DEL_USER");
        findAll().forEach((System.out::println));
        System.out.println("------------------");
        deleteAllUsers();
        System.out.println("ALL_DELETE");
        findAll().forEach((System.out::println));
        System.out.println("END");
    }
}
