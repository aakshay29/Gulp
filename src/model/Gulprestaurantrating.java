package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GULPRESTAURANTRATING database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurantrating.findAll", query="SELECT g FROM Gulprestaurantrating g")
public class Gulprestaurantrating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long rating;

	//bi-directional many-to-one association to Gulprestaurant
	@ManyToOne
	@JoinColumn(name="GULPRESTAURANTID")
	private Gulprestaurant gulprestaurant;

	//bi-directional many-to-one association to Gulpuser
	@ManyToOne
	@JoinColumn(name="GULPUSERID")
	private Gulpuser gulpuser;

	public Gulprestaurantrating() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRating() {
		return this.rating;
	}

	public void setRating(long rating2) {
		this.rating = rating2;
	}

	public Gulprestaurant getGulprestaurant() {
		return this.gulprestaurant;
	}

	public void setGulprestaurant(Gulprestaurant gulprestaurant) {
		this.gulprestaurant = gulprestaurant;
	}

	public Gulpuser getGulpuser() {
		return this.gulpuser;
	}

	public void setGulpuser(Gulpuser gulpuser) {
		this.gulpuser = gulpuser;
	}

}