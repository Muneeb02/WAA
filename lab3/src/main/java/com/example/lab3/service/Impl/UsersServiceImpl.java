package edu.miu.demoinclass2.service.Impl;

import edu.miu.demoinclass2.model.Post;
import edu.miu.demoinclass2.model.Users;
import edu.miu.demoinclass2.model.dto.PostDto;
import edu.miu.demoinclass2.model.dto.UsersDto;
import edu.miu.demoinclass2.repo.UsersRepository;
import edu.miu.demoinclass2.service.UsersService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UsersServiceImpl implements UsersService {
    @Autowired
    private  UsersRepository usersRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Override
    public List<UsersDto> getAllUsers() {

        return usersRepository.findAll()
                .stream().map(users -> modelMapper.map(users, UsersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto getUsersById(long id) {
        Optional<Users> users = usersRepository.findById(id);
        if(users.isPresent()) {
            Users users1 = users.get();
            return modelMapper.map(users1, UsersDto.class);
        }else {
            throw new RuntimeException("user not found");
        }
    }

    @Override
    public UsersDto createNewUser(UsersDto usersDto) {
        Users users = usersRepository.save(modelMapper.map(usersDto, Users.class));
        return modelMapper.map(users, UsersDto.class);
    }

    @Override
    public List<PostDto> getUserPosts(Long id) {
        //get the user
        // user.posts
        Optional<Users> users = usersRepository.findById(id);
        if (users.isPresent()) {
            Users user = users.get();
            List<Post> s = user.getPosts();

            return s.stream().map(post -> modelMapper.map(s, PostDto.class)).collect(Collectors.toList());
        }
        throw new RuntimeException("User not exist");
    }



}
