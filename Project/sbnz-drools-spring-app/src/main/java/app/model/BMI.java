package app.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int tezina;
	private int visina;
	private int godine;
	
	private double score;
	
	private BMIStatus status;

	public BMI() {
		super();
	}
	
	public BMI(int tezina, int visina, int godine) {
		super();
		this.tezina = tezina;
		this.visina = visina;
		this.godine = godine;
	}

	public BMI(int tezina, int visina, int godine, BMIStatus status) {
		super();
		this.tezina = tezina;
		this.visina = visina;
		this.godine = godine;
		this.status = status;
	}
	
	

	public BMI(Long id, int tezina, int visina, int godine, double score, BMIStatus status) {
		super();
		this.id = id;
		this.tezina = tezina;
		this.visina = visina;
		this.godine = godine;
		this.score = score;
		this.status = status;
	}
	
	public void calculateBmiScore() {
		double height = Double.valueOf(this.visina) / 100.0;
		double height_squared = height * height;
		this.score = Double.valueOf(this.tezina) / height_squared;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}