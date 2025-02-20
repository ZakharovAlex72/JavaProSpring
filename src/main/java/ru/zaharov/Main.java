package ru.zaharov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.zaharov.config.DataSourceConfig;
import ru.zaharov.entity.User;
import ru.zaharov.entity.UserService;

import java.util.List;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println("Создаем пользователя User1");
        User user1 = new User("User1");
        userService.create(user1);
        System.out.println("Создаем пользователя User2");
        User user2 = new User("User2");
        userService.create(user2);
        System.out.println("Создаем пользователя User3");
        User user3 = new User("User3");
        userService.create(user3);

        //getAll
        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user.toString()));

        System.out.println("Ищем пользователя по Name="+user3.getUserName());
        User getUser=userService.getUserByName(user3.getUserName());
        System.out.println("Found "+getUser.toString());

        System.out.println("Обновляем найденного пользователя");
        getUser.setUserName("User007");
        userService.update(getUser);

        //getAll
        users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user.toString()));

        System.out.println("Ищем пользователя по Name="+user1.getUserName());
        getUser=userService.getUserByName(user1.getUserName());
        System.out.println("Found "+getUser.toString());

        System.out.println("Удаляем найденного пользователя");
        userService.delete(getUser);

        //getAll
        users = userService.getAllUsers();
        users.forEach(user -> System.out.println(user.toString()));
    }

}