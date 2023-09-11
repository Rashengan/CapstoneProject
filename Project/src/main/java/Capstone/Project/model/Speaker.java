package Capstone.Project.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="Speaker")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String SpeakerName;

    @Column
    private String Email;

    @Column
    private Integer Password;

    @Column
    private Integer Phone;

    @ManyToOne
    @JoinColumn(name = "sp_id")

    private Session session;

    public Speaker(Session session) {
        this.session=session;

    }
    @ManyToMany
    @JoinTable(name="sp_art",
            joinColumns = @JoinColumn(name="sp_id"),
            inverseJoinColumns=@JoinColumn(name="a_id"))
    @OrderBy(value="id")
    private Set<Article>article=new HashSet();
    
    public Speaker(Conference c) {
		
	}
    public Speaker() {
		
	}

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return SpeakerName;
    }

    public void setSpeakerName(String speakerName) {
        SpeakerName = speakerName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getPassword() {
        return Password;
    }

    public void setPassword(Integer password) {
        Password = password;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

}
