package app.controller;

import java.time.LocalDate;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class test {
	
	public static void main(String[] args) {
		LocalDateTime temp = LocalDateTime.now(); 
		LocalDateTime temp1 = temp.plusMinutes(10);
		
		System.out.println(Duration.between(temp, temp1).toMinutes());
		
	

	}

}
