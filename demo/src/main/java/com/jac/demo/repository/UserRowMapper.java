package com.jac.demo.repository;

import com.jac.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .name(rs.getString("name"))
                .age(rs.getInt("age"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .build();
    }
}
