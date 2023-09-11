package Capstone.Project.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Sessions")
@Data
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long SessionID ;
	
	@Column
	private String SessionName ;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="StartDate")
	private LocalDate StartDate;
	
	@Column(name="Duration")
	private int Duration;

	@OneToMany(mappedBy = "session")
	@OrderBy("id")
	private Set<Speaker> speakers = new HashSet<Speaker>();


	@ManyToMany
	@JoinTable(name="conference",
			joinColumns = @JoinColumn(name="s_id"),
			inverseJoinColumns=@JoinColumn(name="a_id"))
	@OrderBy(value="id")
	private Set<Article>article=new HashSet();

	public Session() {

	}
	public Session(Speaker spk) {

	}
	public Session(Article art) {

	}

	public long getSessionID() {
		return SessionID;
	}

	public void setSessionID(long sessionID) {
		this.SessionID = sessionID;
	}

	public String getSessionName() {
		return SessionName;
	}

	public void setSessionName(String sessionName) {
		this.SessionName = sessionName;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.StartDate = startDate;
	}

	public Set<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}

	public int getDuration() {
		return Duration;
		}

	public void setDuration(int duration){
		this.Duration = duration;
		}


	public Set<Article> getArticle() {
		return article;
	}
	public void setArticle(Set<Article> articles) {this.article = articles;}

}
