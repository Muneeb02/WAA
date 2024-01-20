package edu.miu.demoinclass2.service;

import edu.miu.demoinclass2.model.dto.PostDto;
import edu.miu.demoinclass2.model.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    List<UsersDto> getAllUsers();
    UsersDto getUsersById(long id);
    UsersDto createNewUser(UsersDto usersDto);
    List<PostDto> getUserPosts(Long id);


}
