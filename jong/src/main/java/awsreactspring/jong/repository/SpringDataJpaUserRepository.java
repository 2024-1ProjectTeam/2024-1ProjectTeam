package awsreactspring.jong.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import awsreactspring.jong.domain.SiteUser;

public interface SpringDataJpaUserRepository extends JpaRepository<SiteUser, Long>, UserRepository {

    Optional<SiteUser> findByEmail(String email);

    Optional<SiteUser> findByName(String name);

    Optional<SiteUser> findById(Long id);    

    Optional<SiteUser> findByPhone(String phone);

    List<SiteUser> findByScore(int Score);

    List<SiteUser> findByWorker(Boolean worker);
}
