package awsreactspring.jong.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Workinglist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long workinglistid;


    @Column(columnDefinition="TEXT", length = 300)
    String Morning;  //아침용

    @Column(columnDefinition="TEXT", length = 300)
    String lunch;  //점심용


    @Column(columnDefinition="TEXT", length = 300)
    String dinner; //저녁용

    @Column(columnDefinition="TEXT", length = 40)
    String issue; //특이사항
    
    String createdTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "site_user_id")
    private SiteUser siteuser;



    public Long getWorkinglistid() {
        return workinglistid;
    }

    public void setWorkinglistid(Long workinglistid) {
        this.workinglistid = workinglistid;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public SiteUser getSiteuser() {
        return siteuser;
    }

    public void setSiteuser(SiteUser siteuser) {
        this.siteuser = siteuser;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getMorning() {
        return Morning;
    }

    public void setMorning(String morning) {
        this.Morning = morning;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
