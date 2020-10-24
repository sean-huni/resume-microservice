package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.pojo.resp.UserDto;

public interface UserService {

    UserDto findByUsername(String username);
}
