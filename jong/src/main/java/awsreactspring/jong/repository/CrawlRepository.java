package awsreactspring.jong.repository;


import java.util.List;
import java.util.Optional;

import awsreactspring.jong.domain.CrawlingData;

public interface CrawlRepository {
    CrawlingData save(CrawlingData crawlingData);
    List<CrawlingData> findAll(); 
    void deleteAllInBatch();
}