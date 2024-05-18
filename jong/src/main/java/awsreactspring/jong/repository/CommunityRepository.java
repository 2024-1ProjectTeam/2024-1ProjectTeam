package awsreactspring.jong.repository;

import java.util.List;
import java.util.Optional;

import awsreactspring.jong.domain.Community;

public interface CommunityRepository {
    Optional<Community> findByUserId(Long userid);

    Optional<Community> findByPostId(Long postid);

    Optional<Community> findByTitle(String title);

    Optional<Community> findByContent(String content);    

    List<Community> findAll();

    Community save(Community community);

    void delete(Community community);
    
}
