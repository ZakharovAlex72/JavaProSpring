package ru.zaharov.entity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public void create(User user){
        userDao.Create(user);
    }
    public void update(User user){
        userDao.Update(user);
    }
    public void delete(User user){
        userDao.Delete(user);
    }
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
