package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GULPRESTAURANTREVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurantreview.findAll", query="SELECT g FROM Gulprestaurantreview g")
public class Gulprestaurantreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String review;

	//bi-directional many-to-one association to Gulprestaurant
	@ManyToOne
	@JoinColumn(name="GULPRESTAURANTID")
	private Gulprestaurant gulprestaurant;

	//bi-directional many-to-one association to Gulpuser
	@ManyToOne
	@JoinColumn(name="GULPUSERID")
	private Gulpuser gulpuser;

	public Gulprestaurantreview() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
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