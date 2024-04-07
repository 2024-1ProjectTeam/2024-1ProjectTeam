package awsreactspring.jong.domain;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class community {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false)
    long commuId;

    @Column(nullable = false)
    long view;
    @Column(nullable = false)
    String regidate;    
    @Column(nullable = false)
    String corrdate;    
    @Column(nullable = false)
    String posttext;
    
    public long getCommuId() {
        return commuId;
    }
    public void setCommuId(long commuId) {
        this.commuId = commuId;
    }
    public long getView() {
        return view;
    }
    public void setView(long view) {
        this.view = view;
    }
    public String getRegidate() {
        return regidate;
    }
    public void setRegidate(String regidate) {
        this.regidate = regidate;
    }
    public String getCorrdate() {
        return corrdate;
    }
    public void setCorrdate(String corrdate) {
        this.corrdate = corrdate;
    }
    public String getPosttext() {
        return posttext;
    }
    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }



}
