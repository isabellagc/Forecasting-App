package mainApp;

import java.io.Serializable;
import java.util.UUID;

import mainApp.appData.IAppObject;

public class ForecastItApplication implements IAppObject, Serializable {
		
	private static final long serialVersionUID = 6882575160362464416L;
	
	public static final String TableName = "COLLEGEAPPLICATIONS";
	
	protected Long id;
	protected String name;
	protected String hours; 
	protected String comments; 
	protected boolean retake;
	
	public ForecastItApplication() {
		this.id = UUID.randomUUID().getMostSignificantBits();
	}
	
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public String getHours() { return this.hours; }
	public void setHours(String time) { this.hours = time; }
	
	public String getComments() { return this.comments; }
	public void setComments(String words) { this.comments = words; }
	
	public boolean getRetake() { return this.retake; }
	public void setRetake(boolean value) { this.retake = value; }
	

	public String toHTMLElement() {
		return "<div class='col-md-8'>"
				+ "<pre id='reviewtext'>"
				+ "<h3>" + this.name + "</h3>"
				+ "<h4>Hours of Homework: " + this.hours + "<br>Retake: " + this.retake + "<br>Comments: " + this.comments + "</h4>"
		  		+ "</pre>"
				+ "</div>";
	}


}
