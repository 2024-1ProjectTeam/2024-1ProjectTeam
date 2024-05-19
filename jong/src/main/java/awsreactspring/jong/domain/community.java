package awsreactspring.jong.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Community {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postid;
    Long userid; //이거 필요있나싶긴함. 이거 필요없으면 postid를 id로바꾸고 service랑 다 수정다시해야함. 금방하는것. id가 기본 위의 애너테이션을 통해 자동이므로...
    @Column(length = 20)
    String title;
    @Column(columnDefinition = "TEXT")
    String content;
    LocalDateTime createdtTime = LocalDateTime.now();

    public LocalDateTime getCreatedtTime() {
        return createdtTime;
    }
    public void setCreatedtTime(LocalDateTime createdtTime) {
        this.createdtTime = createdtTime;
    }
    public Long getuserid() {
        return userid;
    }
    public void setuserid(Long userid) {
        this.userid = userid;
    }   

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
    
    public Long getpostid() {
        return postid;
    }
    public void setpostid(Long postid) {
        this.postid = postid;
    }   
 


}