package com.jachs.protocolbuffers.student.se;

import java.io.Serializable;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Student implements Serializable{
	private int id;
	private String name;
	private String email;
	
	
	public Student() {
		super();
	}
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
