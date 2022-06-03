package app.dto;

import app.enums.KrvniPritisakStatus;

public class KrvniPritisakDTO {
	
	private Long user_id;
	
	private int gornji_pritisak;
	private int donji_pritisak;
	private KrvniPritisakStatus status;
	
	public KrvniPritisakDTO() {
		super();
	}

	public KrvniPritisakDTO(Long user_id, int gornji_pritisak, int donji_pritisak, KrvniPritisakStatus status) {
		super();
		this.user_id = user_id;
		this.gornji_pritisak = gornji_pritisak;
		this.donji_pritisak = donji_pritisak;
		this.status = status;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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