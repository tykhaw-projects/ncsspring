package com.ncs.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue
	private int todoid;
	
	@NotNull
	@NotEmpty
	private String user;
	
	@Size(min = 5, max = 250, message = "Description must be between 5-250 characters")
	private String desc;
	private LocalDate targetDate;
	private boolean done;
	
	public int getTodoid() {
		return todoid;
	}
	public void setTodoid(int todoid) {
		this.todoid = todoid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public Todo() {
		
	}
	
	public Todo(int todoid, String user, String desc, LocalDate targetDate, boolean done) {
		super();
		this.todoid = todoid;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.done = done;
	}

}
