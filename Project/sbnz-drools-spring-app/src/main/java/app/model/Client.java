package app.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clients")
public class Client extends User{
		
	@OneToOne
	@JoinColumn(name = "bmi_id")
	private BMI bmi;
	
	@OneToOne
	@JoinColumn(name = "kp_id")
	private KrvniPritisak pritisak;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Notification> notifications = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "chosen_sport_id")
	private Sport sport;
	
	@Column(nullable = true)
	private LocalDateTime lastBmiCheck;
	
	@Column(nullable = true)
	private LocalDateTime lastSatisfactionCheck;
	
	public Client() {
		super();
	}

	public Client(String email, String password) {
		super(email, password);
	}

	public BMI getBmi() {
		return bmi;
	}

	public void setBmi(BMI bmi) {
		this.bmi = bmi;
	}

	public KrvniPritisak getPritisak() {
		return pritisak;
	}

	public void setPritisak(KrvniPritisak pritisak) {
		this.pritisak = pritisak;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public LocalDateTime getLastBmiCheck() {
		return lastBmiCheck;
	}

	public void setLastBmiCheck(LocalDateTime lastBmiCheck) {
		this.lastBmiCheck = lastBmiCheck;
	}

	public LocalDateTime getLastSatisfactionCheck() {
		return lastSatisfactionCheck;
	}

	public void setLastSatisfactionCheck(LocalDateTime lastSatisfactionCheck) {
		this.lastSatisfactionCheck = lastSatisfactionCheck;
	}
	
	
}
