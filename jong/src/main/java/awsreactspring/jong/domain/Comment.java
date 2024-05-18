package awsreactspring.jong.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long commentid;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdtTime = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "community_postid")
    private Community community;

    @ManyToOne
    @JoinColumn(name ="siteuser_id")
    private SiteUser siteuser;


    public Long getId() {
        return commentid;
    }


    public void setId(Long id) {
        this.commentid = id;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getCreatedtTime() {
        return createdtTime;
    }


    public void setCreatedtTime(LocalDateTime createdtTime) {
        this.createdtTime = createdtTime;
    }

    public Community getCommunity() {
        return community;
    }


    public void setCommunity(Community community) {
        this.community = community;
    }
    
    public SiteUser getSiteuser() {
        return siteuser;
    }


    public void setSiteuser(SiteUser siteuser) {
        this.siteuser = siteuser;
    }


}
