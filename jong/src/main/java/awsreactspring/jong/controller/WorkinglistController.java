package awsreactspring.jong.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import awsreactspring.jong.domain.Community;
import awsreactspring.jong.domain.Workinglist;
import awsreactspring.jong.service.WorkinglistService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class WorkinglistController {
    private WorkinglistService workinglistService;

    
    @Autowired
    public WorkinglistController(WorkinglistService workinglistService){
        this.workinglistService =   workinglistService;
    }

    @GetMapping("/api/workinglist/today")  //전체조회  -> 해당하는 날자 ex) 오늘만 보이도록 바꿔야함. 
    public List<Workinglist> WorkinglistForToday(){
        return workinglistService.findByDatetoday();
    }

    @GetMapping("/api/workinglist/daterange") // 특정 날짜기간만 조회
    public List<Workinglist> WorkinglistFotDate(
        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate endDate){
        return workinglistService.findByDateBetween(startDate,endDate);
    }
    

    @PostMapping("/api/workinglist/post") //생성
    public ResponseEntity<Workinglist> postWorkinglist(@RequestBody Workinglist workinglist){
        Workinglist saveWorkinglist = workinglistService.saveworkinglist(workinglist);
        return new ResponseEntity<>(saveWorkinglist,HttpStatus.CREATED);
    }
    
}
