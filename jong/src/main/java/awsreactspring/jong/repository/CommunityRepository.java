package awsreactspring.jong.repository;

import java.util.List;
import java.util.Optional;

import awsreactspring.jong.domain.Community;

public interface CommunityRepository {
    // Optional<Community> findByUserid(Long userid);

    Optional<Community> findByPostid(Long postid);

    List<Community> findByTitleContaining(String title);

    List<Community> findByContentContaining(String content);    

    List<Community> findAll();

    Community save(Community community);

    void delete(Community community);
    
}
