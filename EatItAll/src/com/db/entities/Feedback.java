package com.db.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	//bi-directional many-to-one association to Resturant
    @ManyToOne
	@JoinColumn(name="rid")
	private Restaurant resturant;

    public Feedback() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Restaurant getResturant() {
		return this.resturant;
	}

	public void setResturant(Restaurant resturant) {
		this.resturant = resturant;
	}
	
}