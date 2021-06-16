package application.web.dlithe.bootcamp.DLitheBoot.DLitheBoot;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

// model/ entity
@Entity
public class Store 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int app_id;
	private int app_downloads;
	private String app_name, app_by, app_category,app_type;
	private double app_rating,app_sum;
	@Lob
	private Blob app,app_image;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Store [app_id=" + app_id + ", app_downloads=" + app_downloads + ", app_name=" + app_name + ", app_by="
				+ app_by + ", app_category=" + app_category + ", app_type=" + app_type + ", app_rating=" + app_rating
				+ ", app_sum=" + app_sum + ", app=" + app + ", app_image=" + app_image + "]";
	}
	public Store(int app_id, int app_downloads, String app_name, String app_by, String app_category, String app_type,
			double app_rating, double app_sum, Blob app, Blob app_image) {
		super();
		this.app_id = app_id;
		this.app_downloads = app_downloads;
		this.app_name = app_name;
		this.app_by = app_by;
		this.app_category = app_category;
		this.app_type = app_type;
		this.app_rating = app_rating;
		this.app_sum = app_sum;
		this.app = app;
		this.app_image = app_image;
	}
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
	public int getApp_downloads() {
		return app_downloads;
	}
	public void setApp_downloads(int app_downloads) {
		this.app_downloads = app_downloads;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getApp_by() {
		return app_by;
	}
	public void setApp_by(String app_by) {
		this.app_by = app_by;
	}
	public String getApp_category() {
		return app_category;
	}
	public void setApp_category(String app_category) {
		this.app_category = app_category;
	}
	public String getApp_type() {
		return app_type;
	}
	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}
	public double getApp_rating() {
		return app_rating;
	}
	public void setApp_rating(double app_rating) {
		this.app_rating = app_rating;
	}
	public double getApp_sum() {
		return app_sum;
	}
	public void setApp_sum(double app_sum) {
		this.app_sum = app_sum;
	}
	public Blob getApp() {
		return app;
	}
	public void setApp(Blob app) {
		this.app = app;
	}
	public Blob getApp_image() {
		return app_image;
	}
	public void setApp_image(Blob app_image) {
		this.app_image = app_image;
	}
}
