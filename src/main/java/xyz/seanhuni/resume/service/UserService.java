package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.dto.UserDto;

public interface UserService {

    UserDto findByUsername(String username);
}
