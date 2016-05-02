package mainApp;

import java.util.List;

import mainApp.ForecastItApplication;
import mainApp.storage.IStorage;

public class HtmlUtil {

	// Put your CSS URL here
	private static final String CUSTOM_CSS_URL = "ForecastItApplication.css";
	private static final String CUSTOM_JS_URL = "ForecastItApplication.js";
	private static final String CUSTOM_B_URL = "http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css";
	private static final String CUSTOM_F_URL = "https://fonts.googleapis.com/css?family=Roboto:300,400,700";
	
	private IStorage<ForecastItApplication> appStorage;
	
	public HtmlUtil(IStorage<ForecastItApplication> appStorage) {
		this.appStorage = appStorage;
	}
	
	/**
	 * Renders out the HTML head. 
	 * @return the <head> element of the page
	 */
	public String buildHtmlHead() {
		return 
				 "<html lang='en'>"

			+	"<head>"
			+	"<meta charset='utf-8'>"
			+ 	 "<title>HNA Forecasting Tool</title>"
			+ 	 "<link rel='stylesheet' type='text/css' href='" + CUSTOM_CSS_URL + "'/>"
			+	 "<script src='" + CUSTOM_JS_URL + "'></script>"
			+	 "<link rel='stylesheet' type='text/css' href='" + CUSTOM_B_URL + "'/>"
			+	"<link rel='stylesheet' type='text/css' href='" + CUSTOM_F_URL + "'/>"
			+  "</head>"
			+ "</html>";
	}

	/**
	 * Renders out the header of the body. This is
	 * @param userName
	 * @return the header html
	 */
	public String buildBodyHeader(String userName) {
		return /**"<div class='header'>"
			 	  "<p class='username'>"
			+		 "You are logged in as <strong>" + userName + "</strong>"
			+	  "</p>"
			+	  "<h1 class='col-md-8'>HNA Forecasting Tool</h1>"
			+	"</div>";*/
		
			"<header class='container-fluid'>"
		
		+	"<h1 id='title' class='col-md-8'>HNA Forecasting App</h1>"
		
		+	"</header>";
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
		return "<div class='application-form content-padding form-inline'>"
				+	"<h3 class='col-md-8' >Write a Review</h3>"
				+	"<div class='col-md-8'>"
				+		"<form action='?action=add' method='post'>"
				+			"<div class='form-group col-md-8'>"
				+ 				"<label>Course Name</label>"
				+  				"<input type='text' class='form-control' name='courseName' id='courseNameInputBox' >"
				+ 			"</div>"
				+			"<div class='form-group col-md-8'>"
				+ 				"<label>Hours of Homework</label>"
				+  				"<select class='form-control' name='homeworkHoursInputBox' id='InputhomeworkHours' >"
				+					"<option value='0'>0</option>"
				+					"<option value='0.5'>0.5</option>"
				+					"<option value='1'>1</option>"
				+					"<option value='1.5'>1.5</option>"
				+					"<option value='2'>2</option>"
				+					"<option value='2.5'>2.5</option>"
				+					"<option value='3'>3</option>"
				+				"</select>"
				+ 			"</div>"
				+			"<div class='form-group col-md-8'>"
				+ 				"<label>Retake</label>"
				+  				"<input type='checkbox' class='form-control' name='retake' id='InputRetakeChkBox' value='retake' >"
				+ 			"</div>"
				+			"<div class='form-group col-md-8'>"
				+ 				"<label>Comments</label>"
				+  				"<textarea class='form-control' rows='3' name='comments' id='commentsInputBox'></textarea>"
				+ 			"</div>"
				+			 "<p id='formStatusBox'></p>"
				+			"<div class='form-group col-md-8'>"
				+  				"<input class='btn btn-default' type='submit' value='Submit'>"
				+ 			"</div>"
				+		"</form>"
				+		"</div>"
				+		"<h3 class='col-md-8' >Filter Reviews</h3>"
				+	"<div class='application-form content-padding form-inline'>"	
				+	"<form action='?action=filter' method='post'>"
				+				"<div class='form-group col-md-8'>"
				+ 					"<label>Course Name</label>"
				+  					"<input type='text' class='form-control' name='filterCourseName' id='filterCourseNameInputBox'>"
				+	 			"</div>"
				+				"<p id='formStatusBox'></p>"
				+				"<div class='form-group col-md-8'>"
				+  					"<input class='btn btn-default' type='submit' value='Filter'>"
				+ 				"</div>"
				+	"</form>"
				+"</div>"
				  
				 /**
				+		"<table class='table'>"
				+		"<tr><td> Name <input type='text' class='form-control' > </td></tr>"
				+ 		"<tr><td> Course Name <input type='text' class='form-control' name='courseName' id='courseNameInputBox' </td></tr>"
				+		"<tr><td> Hours of Homework <select class='form-control' name='homeworkHoursInputBox' id='InputhomeworkHours'>"
				+			"<option value='0'>0</option>"
				+			"<option value='0.5'>0.5</option>"
				+			"<option value='1'>1</option>"
				+			"<option value='1.5'>1.5</option>"
				+			"<option value='2'>2</option>"
				+			"<option value='2.5'>2.5</option>"
				+			"<option value='3'>3</option>"
				+		"</select></td></tr>"
				+		"<tr><td> Retake <input type='checkbox' class='form-control' name='retake' id='InputRetakeChkBox' value='retake'</td></tr>"
				+		"<tr><td> Comments <textarea class='form-control' rows='3' name='comments' id='commentsInputBox'></textarea></td></tr>"
				+	 "<tr><td><input class='btn btn-default' type='submit' value='Submit'></td></tr>"
				+	"</table></form>"
				+	 "<p id='formStatusBox'></p>" */
				
				+	"<h3 class='col-md-8' >Reviews</h3>"
				+  "</div>";  
		/**
				"<div class='application-form content-padding form-inline'>"
		+	 "<h3 class='col-md-8'>Write a Review</h3>"
		+	 "<form action='?action=add' method='post'>"
		+		"<table ><tr><td class='col-md-6'> Course Name: </td><td> <input type='text' class='form-control' name='courseName' id='courseNameInputBox' </td></tr>"
		+		"<tr><td class='col-md-6'> Hours of Homework: </td><td><select class='form-control' name='homeworkHoursInputBox' id='InputhomeworkHours'>"
		+			"<option value='0'>0</option>"
		+			"<option value='0.5'>0.5</option>"
		+			"<option value='1'>1</option>"
		+			"<option value='1.5'>1.5</option>"
		+			"<option value='2'>2</option>"
		+			"<option value='2.5'>2.5</option>"
		+			"<option value='3'>3</option>"
		+		"</select></td></tr>"
		+		"<tr><td class='col-md-6'> Retake: </td><td><input type='checkbox' class='form-control' name='retake' id='InputRetakeChkBox' value='retake'</td></tr>"
		+		"<tr><td class='col-md-6'> Comments:</td><td> <input type='text' class='form-control' name='comments' id='commentsInputBox'></td></tr>"
		+	 "<tr><td class='col-md-6'><input class='btn btn-default' type='submit' value='Submit'></td></tr>"
		+	"</form></table>"
		+	 "<p id='formStatusBox'></p>"
		+  "</div>";  */
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
	public String buildCollegeApplicationList(String filter, String filterCourseName) {		
		// TODO render out all the college applications. To do this you'll need to:
		//		- get the data from appStorage
		//		- loop through the data, render out html: see CollegeApplication.toHTMLElement()
		List<ForecastItApplication> apps = this.appStorage.read();
		String appString = "";
		
		if (filter.equals("false"))
		{
			// put following in method buildFullCollegeApplicationList
			for (int i = 0; i < apps.size(); i++)
			{
				appString += apps.get(i).toHTMLElement() + " ";
			}			
		}
		else
		{
			
			// put this in method renderFilter
			// copy the logic from renderFilter
			for(ForecastItApplication app : appStorage.read())
			{
				if(!filterCourseName.isEmpty())
				{
					if(app.getName().compareToIgnoreCase(filterCourseName) == 0)
						{
							appString += app.toHTMLElement();
						}
				}
					
			}
		}
		
		return appString;
	}
	
}