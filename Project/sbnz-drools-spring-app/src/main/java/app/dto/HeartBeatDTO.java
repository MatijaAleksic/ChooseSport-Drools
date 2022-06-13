package app.dto;


import java.time.LocalDateTime;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import app.enums.BMIStatus;
import app.enums.HeartBeatStatus;
import app.enums.KrvniPritisakStatus;
import app.model.Client;
import app.model.User;

@Role(Role.Type.EVENT)
//@Expires("30m")
public class HeartBeatDTO {
	
	private LocalDateTime startTime;
	private LocalDateTime timeNow;
	private int heartRatePerMinute;
	private Long userId;
	
	private int userAge;
	private int upperLimit;
	private int lowerLimit;
	private KrvniPritisakStatus krvniPritisak;
	private BMIStatus bmiStatus;
	
	private HeartBeatStatus heartBeatStatus;
	
	public HeartBeatDTO() {	}
	
	public HeartBeatDTO(int heartRatePerMinute, Long userId, LocalDateTime startTime) {
		super();
		this.heartRatePerMinute = heartRatePerMinute;
		this.userId = userId;
		this.startTime = startTime;
	}

	public int getHeartRatePerMinute() {
		return heartRatePerMinute;
	}

	public void setHeartRatePerMinute(int heartRatePerMinute) {
		this.heartRatePerMinute = heartRatePerMinute;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public KrvniPritisakStatus getKrvniPritisak() {
		return krvniPritisak;
	}

	public void setKrvniPritisak(KrvniPritisakStatus krvniPritisak) {
		this.krvniPritisak = krvniPritisak;
	}

	public BMIStatus getBmiStatus() {
		return bmiStatus;
	}

	public void setBmiStatus(BMIStatus bmiStatus) {
		this.bmiStatus = bmiStatus;
	}

	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	
	
	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public HeartBeatStatus getHeartBeatStatus() {
		return heartBeatStatus;
	}

	public void setHeartBeatStatus(HeartBeatStatus heartBeatStatus) {
		this.heartBeatStatus = heartBeatStatus;
	}

	public LocalDateTime getTimeNow() {
		return timeNow;
	}

	public void setTimeNow(LocalDateTime timeNow) {
		this.timeNow = timeNow;
	}

	public void calculateUpperLowerLimit() {
		int temp = 220 - this.userAge;
		this.upperLimit = (int) (temp * 0.8);
		this.lowerLimit = (int) (temp * 0.6);			
	}
	
	
	
	
}