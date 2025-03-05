package ru.zaharov.entity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(User user){
        jdbcTemplate.update("INSERT INTO users (username) VALUES (?)", user.getUserName());
    }
    public void update(User user){
        jdbcTemplate.update("UPDATE users SET username = ? WHERE id = ?", user.getUserName(), user.getId());
    }
    public void delete(User user){
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", user.getId());
    }
    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("username")));
    }
    public User getUserByName(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE username = ?", new Object[]{username}, (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("username")));
    }
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("username")));
    }
}
