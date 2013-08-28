package com.ORM;

import java.sql.Timestamp;

/**
 * Temp entity. @author MyEclipse Persistence Tools
 */

public class Temp implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp time;
	private String text;

	// Constructors

	/** default constructor */
	public Temp() {
	}

	/** full constructor */
	public Temp(Timestamp time, String text) {
		this.time = time;
		this.text = text;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}