package com.company.service.inter;

import com.company.dto.request.TaskRequest;
import com.company.dto.request.UserRequest;
import com.company.dto.response.TaskRespons;
import com.company.dto.response.UserRespons;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    List<UserRespons> getAllUser();
    UserRespons userNameAndSurname(String email);

    UserRespons updateUser(Long userId, UserRequest userRequest);

    boolean deleteUser(Long userId);

    List<TaskRespons> getUserTasks(Long userId);

    TaskRespons updateUserTasks(Long userId, Long taskId, TaskRequest taskRequest);
}
