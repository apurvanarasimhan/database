package com.db.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the databasemanager database table.
 * 
 */
@Entity
public class Databasemanager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String password;

	private String username;

    public Databasemanager() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}