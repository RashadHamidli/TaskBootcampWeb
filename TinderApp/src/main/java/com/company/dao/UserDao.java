package com.company.dao;

import com.company.db.DBConnect;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDao implements Dao<T> {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void add(User user){
        String query = "insert into \"users\" (name, surname, email, password) values (?, ?, ?, ?)";
        try {
            PreparedStatement st = DBConnect.connect().prepareStatement(query);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
