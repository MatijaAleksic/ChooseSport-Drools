package app.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.enums.BMIStatus;

@Entity
@Table(name = "bmi")
public class BMI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int tezina;
	private int visina;
	private int godine;
	
	private BMIStatus status;

	public BMI() {
		super();
	}

	public BMI(int tezina, int visina, int godine, BMIStatus status, ArrayList<User> users) {
		super();
		this.tezina = tezina;
		this.visina = visina;
		this.godine = godine;
		this.status = status;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public BMIStatus getStatus() {
		return status;
	}

	public void setStatus(BMIStatus status) {
		this.status = status;
	}

}