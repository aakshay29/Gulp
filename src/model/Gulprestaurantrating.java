package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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

	private BigDecimal gulprestaurantid;

	private BigDecimal gulpuserid;

	private BigDecimal rating;

	public Gulprestaurantrating() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getGulprestaurantid() {
		return this.gulprestaurantid;
	}

	public void setGulprestaurantid(BigDecimal gulprestaurantid) {
		this.gulprestaurantid = gulprestaurantid;
	}

	public BigDecimal getGulpuserid() {
		return this.gulpuserid;
	}

	public void setGulpuserid(BigDecimal gulpuserid) {
		this.gulpuserid = gulpuserid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

}