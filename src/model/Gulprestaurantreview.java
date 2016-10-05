package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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

	private BigDecimal gulprestaurantid;

	private BigDecimal gulpuserid;

	private String review;

	public Gulprestaurantreview() {
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

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}