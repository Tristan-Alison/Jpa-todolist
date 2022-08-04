package fr.m2i.models;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	
		
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer _id;
		
	@Basic
	@Column(name="nom")
	private String _nom;
	
	@Basic
	@Column(name="description")
	private String _description;

	
	
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	@Override
	public String toString() {
		return "Task [_nom=" + _nom + ", _description=" + _description + ", _id=" + _id + "]";
	}
	
	
	
	
	
}
