package awsreactspring.jong.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import awsreactspring.jong.domain.Community;

public interface SpringDataJpaCommunityRepository extends JpaRepository<Community,Long>, CommunityRepository {
    Optional<Community> findByUserId(Long userid);

    Optional<Community> findByPostId(Long postid);

    Optional<Community> findByTitle(String title);

    Optional<Community> findByContent(String content);    

    List<Community> findAll();
    
    void delete(Community community);

    Community save(Community community);

    
}
