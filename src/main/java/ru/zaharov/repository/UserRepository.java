package ru.zaharov.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.zaharov.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into users (username) values (:username)", nativeQuery = true)
    void createUser(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "delete from users where username = :username", nativeQuery = true)
    void deleteUserByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = "delete from users", nativeQuery = true)
    void deleteAllUsers();

    @Query(value = "select * from users where username =:username", nativeQuery = true)
    Optional<User> findUserByUsername(@Param("username") String username);

}
