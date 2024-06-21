package com.jac.demo.repository;

import com.jac.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Long saveUser(User user) {
        String sql = "INSERT INTO users(name, age, email, password) VALUES(?,?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getPassword());
        return jdbcTemplate.queryForObject("SELECT MAX(id) from users", Long.class);
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT id, name, age, email, password from users", new UserRowMapper());
    }
}
