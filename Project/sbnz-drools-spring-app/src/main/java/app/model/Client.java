package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clients")
public class Client extends User{
		
	@NotNull
	@OneToOne
	@JoinColumn(name = "bmi_id")
	private BMI bmi;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "kp_id")
	private KrvniPritisak pritisak;
	
	@OneToMany(mappedBy = "user")
	private Set<Notification> notifications = new HashSet<>();
	
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
}
