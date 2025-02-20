package ru.zaharov.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.zaharov.entity.UserDao;
import ru.zaharov.entity.UserService;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public static DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/test");
        config.setUsername("postgres");
        config.setPassword("postgres");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public UserDao userDao() {
        return new UserDao(jdbcTemplate());
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao());
    }
}
