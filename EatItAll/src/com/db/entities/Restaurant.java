package com.db.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the restaurant database table.
 * 
 */
@Entity
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cuisine;

	private String location;

	private String name;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="restaurant")
	private Set<Reservation> reservations;

    public Restaurant() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuisine() {
		return this.cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}