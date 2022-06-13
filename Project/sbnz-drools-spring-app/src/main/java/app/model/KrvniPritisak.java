package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.enums.KrvniPritisakStatus;

@Entity
@Table(name = "krvni_pritisak")
public class KrvniPritisak {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int gornji_pritisak;
	private int donji_pritisak;
	private KrvniPritisakStatus status;
	
	
	
	public KrvniPritisak() {
		super();
	}

	public KrvniPritisak(Long id, int gornji_pritisak, int donji_pritisak, KrvniPritisakStatus status) {
		super();
		this.id = id;
		this.gornji_pritisak = gornji_pritisak;
		this.donji_pritisak = donji_pritisak;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGornji_pritisak() {
		return gornji_pritisak;
	}

	public void setGornji_pritisak(int gornji_pritisak) {
		this.gornji_pritisak = gornji_pritisak;
	}

	public int getDonji_pritisak() {
		return donji_pritisak;
	}

	public void setDonji_pritisak(int donji_pritisak) {
		this.donji_pritisak = donji_pritisak;
	}

	public KrvniPritisakStatus getStatus() {
		return status;
	}

	public void setStatus(KrvniPritisakStatus status) {
		this.status = status;
	}
	
	
	
	

}
