package awsreactspring.jong.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import awsreactspring.jong.domain.CrawlingData;

/**
 * SpringDataJpaCrawlRepository
 */
public interface SpringDataJpaCrawlRepository extends JpaRepository<CrawlingData, Long>, CrawlRepository{
    List<CrawlingData> findAll();
    void deleteAllInBatch();
}