package awsreactspring.jong.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import awsreactspring.jong.domain.Community;

public interface SpringDataJpaCommunityRepository extends JpaRepository<Community,Long>, CommunityRepository {
    // Optional<Community> findByUserid(Long userid);

    Optional<Community> findByPostid(Long postid);

    List<Community> findByTitleContaining(String title);

    List<Community> findByContentContaining(String content);    

    List<Community> findAll();
    
    void delete(Community community);

    Community save(Community community);

    
}
