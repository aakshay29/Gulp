package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GULPRESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurant.findAll", query="SELECT g FROM Gulprestaurant g")
public class Gulprestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String address;

	private long averagerating;

	private String description;

	private String name;

	//bi-directional many-to-one association to Gulprestaurantrating
	@OneToMany(mappedBy="gulprestaurant")
	private List<Gulprestaurantrating> gulprestaurantratings;

	//bi-directional many-to-one association to Gulprestaurantreview
	@OneToMany(mappedBy="gulprestaurant")
	private List<Gulprestaurantreview> gulprestaurantreviews;

	public Gulprestaurant() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAveragerating() {
		return this.averagerating;
	}

	public void setAveragerating(long average) {
		this.averagerating = average;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Gulprestaurantrating> getGulprestaurantratings() {
		return this.gulprestaurantratings;
	}

	public void setGulprestaurantratings(List<Gulprestaurantrating> gulprestaurantratings) {
		this.gulprestaurantratings = gulprestaurantratings;
	}

	public Gulprestaurantrating addGulprestaurantrating(Gulprestaurantrating gulprestaurantrating) {
		getGulprestaurantratings().add(gulprestaurantrating);
		gulprestaurantrating.setGulprestaurant(this);

		return gulprestaurantrating;
	}

	public Gulprestaurantrating removeGulprestaurantrating(Gulprestaurantrating gulprestaurantrating) {
		getGulprestaurantratings().remove(gulprestaurantrating);
		gulprestaurantrating.setGulprestaurant(null);

		return gulprestaurantrating;
	}

	public List<Gulprestaurantreview> getGulprestaurantreviews() {
		return this.gulprestaurantreviews;
	}

	public void setGulprestaurantreviews(List<Gulprestaurantreview> gulprestaurantreviews) {
		this.gulprestaurantreviews = gulprestaurantreviews;
	}

	public Gulprestaurantreview addGulprestaurantreview(Gulprestaurantreview gulprestaurantreview) {
		getGulprestaurantreviews().add(gulprestaurantreview);
		gulprestaurantreview.setGulprestaurant(this);

		return gulprestaurantreview;
	}

	public Gulprestaurantreview removeGulprestaurantreview(Gulprestaurantreview gulprestaurantreview) {
		getGulprestaurantreviews().remove(gulprestaurantreview);
		gulprestaurantreview.setGulprestaurant(null);

		return gulprestaurantreview;
	}

}