package com.company.controller;

import com.company.dao.UserDAO;
import com.company.entity.User;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class UserController {
    private UserDAO userDao;

//    private LikeService likeService;

    public UserController(UserDAO userDao) {
        this.userDao = userDao;
    }

    public UserController(Connection connection, UserDAO userDao) {
        this.userDao = userDao;
//        likeService = new LikeService(new LikeDao(connection));
    }

    public void addUser(User user){
        userDao.add(user);
    }

    public int getUserId(User user){
        return userDao.getAll()
                .stream()
                .filter(u -> u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null)
                .getId();
    }

    public User getUser(int id){
        return userDao.get(id);
    }

    public List<User> getAllUsers(int id){
        return userDao.getAll().stream().filter(u -> u.getId() != id).collect(Collectors.toList());
    }

//    public List<User> getLikedUsers(int id, List<Like> likes){
//        return likes.stream().map(l -> getUser(l.getLikedId())).collect(Collectors.toList());
//    }


}
