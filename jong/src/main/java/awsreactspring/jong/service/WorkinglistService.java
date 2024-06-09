package awsreactspring.jong.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import awsreactspring.jong.domain.Workinglist;
import awsreactspring.jong.repository.UserRepository;
import awsreactspring.jong.repository.WorkinglistRepository;
import jakarta.transaction.Transactional;

@Transactional
public class WorkinglistService {
    private final WorkinglistRepository workinglistRepository;

    public WorkinglistService(WorkinglistRepository workinglistRepository){
        this.workinglistRepository = workinglistRepository;
    }
    
    public Workinglist saveworkinglist(Workinglist workinglist){
        return workinglistRepository.save(workinglist);
    }

    public List<Workinglist> findByDatetoday(){    // 이거 해당 날짜만 나오게 바꿔야함.
        LocalDate today = LocalDate.now();
        return workinglistRepository.findByDate(today);
    }

    public List<Workinglist> findByDateBetween(LocalDate startDate, LocalDate endDate){      //  사용자가 특정 날짜기간 고르면 조회하는 서비스.
        return workinglistRepository.findByDateBetween(startDate,endDate);
    }

    



    
}
