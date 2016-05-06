package mainApp;

import java.util.List;

import mainApp.ForecastItApplication;
import mainApp.storage.IStorage;

public class HtmlUtil {

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
	 * Renders out the header of the body.
	 * @return the header html
	 */
	public String buildBodyHeader() {
		return /**"<div class='header'>"
			+	  "<h1 class='col-md-8'>HNA Forecasting Tool</h1>"
			+	"</div>";*/
		
			"<header class='container-fluid'>"
		
		+	"<h1 id='title' class='col-md-8'>HNA Forecasting App</h1>"
		
		+	"</header>";
	}

	/**
	 * Renders out the course add and filter form
	 * @return the course form
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
				+			 "<p id='formStatusBox'></p>"
				+ 			"</div>"
				+			"<div class='form-group col-md-8'>"
				+           "<input class='btn btn-default' type='submit' onclick='popup()' value='Submit''>"
				+ 			"</div>"
				+		"</form>"
				+		"</div>"
				+		"<h3 class='col-md-8' >Filter Reviews</h3>"
				+	"<div class='application-form content-padding form-inline'>"	
				+	"<form action='?action=filter' method='post' >"
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
				  
				
				+	"<h3 class='col-md-8' >Reviews</h3>"
				+  "</div>";  
	}

	/**
	 * Renders out the task form
	 * @return the task form
	 */
	public String buildTaskForm(String username, String schoolName) {
		return "";
	}

	/**
	 * Renders out the list of courses
	 * @return the college applications
	 */
	public String buildCourseList(String filter, String filterCourseName) {		
		List<ForecastItApplication> apps = this.appStorage.read();
		String appString = "";
		
		if (filter.equals("false"))
		{
			for (int i = 0; i < apps.size(); i++)
			{
				appString += apps.get(i).toHTMLElement() + " ";
			}			
		}
		else
		{
			
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