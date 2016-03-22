package mainApp;

import java.io.Serializable;
import java.util.UUID;

import mainApp.appData.IAppObject;

public class ForecastItApplication implements IAppObject, Serializable {
		
	private static final long serialVersionUID = 6882575160362464416L;
	
	public static final String TableName = "COLLEGEAPPLICATIONS";
	
	protected Long id;
	protected String name;
	protected String type; // reach/match/safety
	
	public ForecastItApplication() {
		this.id = UUID.randomUUID().getMostSignificantBits();
	}
	
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public String toHTMLElement() {
		// TODO fill out this method to include all the relevant information
		return "<h4>" + this.name + "</h4>";
	}
}
