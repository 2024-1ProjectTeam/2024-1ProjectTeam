package awsreactspring.jong.repository;

import java.time.LocalDate;
import java.util.List;

import awsreactspring.jong.domain.Workinglist;

public interface WorkinglistRepository {

    Workinglist save(Workinglist workinglist);  // 저장

    List<Workinglist> findAll(); //조회

    List<Workinglist> findByDate(LocalDate date); //날짜 조회

    List<Workinglist> findByDateBetween(LocalDate startDate, LocalDate endDate);   //특정 날짜 기간 조회.

}