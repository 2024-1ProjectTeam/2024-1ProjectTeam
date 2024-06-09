package awsreactspring.jong.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import awsreactspring.jong.domain.Workinglist;

public interface SpringDataJpaWorkinglist extends JpaRepository<Workinglist,Long>, WorkinglistRepository {
    
    Workinglist save(Workinglist workinglist);  // 저장

    List<Workinglist> findAll(); //조회

    List<Workinglist> findByDate(LocalDate date);

    List<Workinglist> findByDateBetween(LocalDate startDate, LocalDate endDate);
    
} 