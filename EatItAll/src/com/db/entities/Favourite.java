package com.db.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favourites database table.
 * 
 */
@Entity
@Table(name="favourites")
public class Favourite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int likedby;

	private int rid;

    public Favourite() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLikedby() {
		return this.likedby;
	}

	public void setLikedby(int likedby) {
		this.likedby = likedby;
	}

	public int getRid() {
		return this.rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

}