package edu.miu.demoinclass2.repo;

import edu.miu.demoinclass2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
