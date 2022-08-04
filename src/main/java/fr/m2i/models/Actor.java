package fr.m2i.models;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="actor")
public class Actor {
	
	@Id
	@Column(name="actor_id")
	private Integer id;
	
	@Basic
	@Column(name="first_name")
	private String first_name;
	
	@Basic
	@Column(name="last_name")
	private String last_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar last_update;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Calendar getLast_update() {
		return last_update;
	}

	public void setLast_update(Calendar last_update) {
		this.last_update = last_update;
	}

}
