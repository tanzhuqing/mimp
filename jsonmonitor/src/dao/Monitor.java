package dao;

import java.sql.Timestamp;

/**
 * Monitor entity. @author MyEclipse Persistence Tools
 */

public class Monitor implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp time;
	private String content;
	private Integer length;
	private Integer frame;

	// Constructors

	/** default constructor */
	public Monitor() {
	}

	/** full constructor */
	public Monitor(Timestamp time, String content, Integer length, Integer frame) {
		this.time = time;
		this.content = content;
		this.length = length;
		this.frame = frame;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getFrame() {
		return this.frame;
	}

	public void setFrame(Integer frame) {
		this.frame = frame;
	}

}