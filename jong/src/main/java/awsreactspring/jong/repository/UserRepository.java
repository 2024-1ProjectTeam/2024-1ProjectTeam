package awsreactspring.jong.repository;

import java.util.Optional;

import awsreactspring.jong.domain.SiteUser;


public interface UserRepository {
    SiteUser save(SiteUser User);
    Optional<SiteUser> findById(Long id);
    Optional<SiteUser> findByName(String name);
    Optional<SiteUser> findByEmail(String email);
    Optional<SiteUser> findByPhone(String phone);
    
}
