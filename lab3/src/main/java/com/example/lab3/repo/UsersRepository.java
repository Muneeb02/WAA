package com.example.lab3.repo;


import com.example.lab3.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

//    @Query("SELECT u FROM Users u where size(u.posts) > 1")
//    //List<Users> listOfUsersMoreThanOnePosts();

    @Query("SELECT u from Users u where size(u.posts) > :n ")
    List<Users> listOfUsersMoreThanOnePosts(@Param("n") int n);

}
