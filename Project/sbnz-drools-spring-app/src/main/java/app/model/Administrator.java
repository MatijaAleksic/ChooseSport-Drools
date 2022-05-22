package app.model;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Administrator extends User {

	public Administrator() {
		super();
	}

	public Administrator(String email, String password) {
		super(email, password);
	}
	
}