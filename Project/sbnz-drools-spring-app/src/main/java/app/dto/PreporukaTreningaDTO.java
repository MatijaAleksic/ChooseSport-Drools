package app.dto;

import app.enums.BMIStatus;
import app.enums.KrvniPritisakStatus;

public class PreporukaTreningaDTO {
	
	private int vezbeSnage;
	private int vezbeKardio;
	
	private BMIStatus bmiStatus;
	private KrvniPritisakStatus kpStatus;
	
	
	public PreporukaTreningaDTO() {}

	public PreporukaTreningaDTO(int vezbeSnage, int vezbeKardio, BMIStatus bmiStatus, KrvniPritisakStatus kpStatus) {
		this.vezbeSnage = vezbeSnage;
		this.vezbeKardio = vezbeKardio;
		this.bmiStatus = bmiStatus;
		this.kpStatus = kpStatus;
	}

	public int getVezbeSnage() {
		return vezbeSnage;
	}

	public void setVezbeSnage(int vezbeSnage) {
		this.vezbeSnage = vezbeSnage;
	}

	public int getVezbeKardio() {
		return vezbeKardio;
	}

	public void setVezbeKardio(int vezbeKardio) {
		this.vezbeKardio = vezbeKardio;
	}

	public BMIStatus getBmiStatus() {
		return bmiStatus;
	}

	public void setBmiStatus(BMIStatus bmiStatus) {
		this.bmiStatus = bmiStatus;
	}

	public KrvniPritisakStatus getKpStatus() {
		return kpStatus;
	}

	public void setKpStatus(KrvniPritisakStatus kpStatus) {
		this.kpStatus = kpStatus;
	}
	
	public void incrementSnaga() {
		this.vezbeSnage += 1;
		this.vezbeKardio -= 1;
	}
	
	public void incrementKardio() {
		this.vezbeSnage -= 1;
		this.vezbeKardio += 1;
	}
	
	

}
