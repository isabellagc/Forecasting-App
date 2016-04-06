package mainApp;

import java.util.List;

import mainApp.ForecastItApplication;
import mainApp.storage.IStorage;

public class HtmlUtil {

	// Put your CSS URL here
	private static final String CUSTOM_CSS_URL = "ForecastItApplication.css";
	private static final String CUSTOM_JS_URL = "ForecastItApplication.js";

	private IStorage<ForecastItApplication> appStorage;
	
	public HtmlUtil(IStorage<ForecastItApplication> appStorage) {
		this.appStorage = appStorage;
	}
	
	/**
	 * Renders out the HTML head. 
	 * @return the <head> element of the page
	 */
	public String buildHtmlHead() {
		return "<head>"
			+ 	 "<title>HNA Forecasting Tool</title>"
			+ 	 "<link rel='stylesheet' type='text/css' href='" + CUSTOM_CSS_URL + "'/>"
			+	 "<script src='" + CUSTOM_JS_URL + "'></script>"
			+  "</head>";
	}

	/**
	 * Renders out the header of the body. This is
	 * @param userName
	 * @return the header html
	 */
	public String buildBodyHeader(String userName) {
		return "<div class='header'>"
			+ 	  "<p class='username'>"
			+		 "You are logged in as <strong>" + userName + "</strong>"
			+	  "</p>"
			+	  "<h1>HNA Forecasting Tool</h1>"
			+	"</div>";
	}

	/**
	 * Renders out the college application form
	 * @return the college application form
	 */
	/*
	 * public String buildApplicationForm() { // TODO add more functionality to
	 * the form to support: // - textbox for college name (already implemented)
	 * // - dropdown for safety/match/reach // - checkbox for completed // -
	 * textbox for due date // - anything else you want to add return
	 * "<div class='application-form content-padding form-inline'>" +
	 * "<h3>Please enter a new class to review</h3>" +
	 * "<form action='?action=add' method='post'>" +
	 * "Class Name: <input type='text' class='form-control' name='className' id='classNameInputBox' />"
	 * // Add those things here! + "</form>" + "<p id='formStatusBox'></p>" +
	 * "</div>" + "<div id=\"filters\">" + "<h4> filter by... </h4>" + "Class:"
	 * +
	 * "<select id=\"courseOptions\"> <!--This is a drop-down box of courses-->"
	 * + "<option value=\"AP Psychology\">AP Psychology</option>" +
	 * "<option value=\"AP Computer Science\">AP Computer Science</option>" +
	 * "<option value=\"AP Studio Art\">AP Studio Art</option>" + "</select>" +
	 * "GPA (unweighted):" + "<select id=\"GPAOptions\">" +
	 * "<option value=\"2.0 - 2.5\">2.0 - 2.5</option>" +
	 * "<option value=\"2.5 - 3.0\">2.5 - 3.0</option>" +
	 * "<option value=\"3.0 - 3.5\">3.0 - 3.5</option>" +
	 * "<option value=\"3.5 - 4.0\">3.5 - 4.0</option>" + "</select>"
	 * 
	 * + "Overall Rating:" + "<select id=\"Rating\">" +
	 * "<option value=\"1\">1</option>" + "<option value=\"2\">2</option>" +
	 * "<option value=\"3\">3</option>" + "<option value=\"4\">4</option>" +
	 * "<option value=\"5\">5</option>" + "</select>" + "</div>" +
	 * "<button type=\"button\" id=\"SubmitButton\">Submit</button>"
	 * 
	 * + "<div id=\"reviews\">" + "<h3>Reviews<h3>"
	 * 
	 * 
	 * + "</div>"; }
	 */
	
	public String buildApplicationForm() {
		// TODO add more functionality to the form to support:
		//		- textbox for course name
		//		- dropdown for homework hours
		//		- checkbox for retake
		//		- textbox for comments
		//		- anything else you want to add
		return "<div class='application-form content-padding form-inline'>"
		+	 "<h3>Please enter a new class review</h3>"
		+	 "<form action='?action=add' method='post'>"
		+		"<table><tr><td> Course Name: </td><td> <input type='text' class='form-control' name='courseName' id='courseNameInputBox' </td></tr>"
		+		"<tr><td> Hours of Homework: </td><td><select class='form-control' name='homeworkHoursInputBox' id='InputhomeworkHours'>"
		+			"<option value='0'>0</option>"
		+			"<option value='0.5'>0.5</option>"
		+			"<option value='1'>1</option>"
		+			"<option value='1.5'>1.5</option>"
		+			"<option value='2'>2</option>"
		+			"<option value='2.5'>2.5</option>"
		+			"<option value='3'>3</option>"
		+		"</select></td></tr>"
		+		"<tr><td> Retake: </td><td><input type='checkbox' class='form-control' name='retake' id='InputRetakeChkBox' value='retake'</td></tr>"
		+		"<tr><td> Comments:</td><td> <input type='text' class='form-control' name='comments' id='commentsInputBox'></td></tr>"
		+	 "<tr><td><input type='submit' value='Submit'></td></tr>"
		+	"</form></table>"
		+	 "<p id='formStatusBox'></p>"
		+  "</div>";
	}

	/**
	 * Renders out the task form
	 * @return the task form
	 */
	public String buildTaskForm(String username, String schoolName) {
		// TODO create the task form if you have time
		return "";
	}

	/**
	 * Renders out the list of college applications
	 * @return the college applications
	 */
	public String buildCollegeApplicationList() {		
		// TODO render out all the college applications. To do this you'll need to:
		//		- get the data from appStorage
		//		- loop through the data, render out html: see CollegeApplication.toHTMLElement()
		List<ForecastItApplication> apps = this.appStorage.read();
		String appString = "";
		
		for (int i = 0; i < apps.size(); i++)
		{
			appString += apps.get(i).toHTMLElement() + " ";
		}
		
		return appString;
	}
}