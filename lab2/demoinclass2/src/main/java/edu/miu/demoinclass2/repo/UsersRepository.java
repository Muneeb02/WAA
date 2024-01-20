package edu.miu.demoinclass2.repo;

import edu.miu.demoinclass2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query("SELECT u FROM Users u where size(u.posts) > 1")
    List<Users> listOfUsersMoreThanOnePosts();

}
