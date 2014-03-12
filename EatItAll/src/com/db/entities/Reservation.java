package com.db.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity

public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cid;

	private String rname;

	//bi-directional many-to-one association to Restaurant
    @ManyToOne
	@JoinColumn(name="rid")
	private Restaurant restaurant;

    public Reservation() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return this.cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}