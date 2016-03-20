package collegeApp;

import java.util.List;

import collegeApp.storage.IStorage;

public class HtmlUtil {

	// Put your CSS URL here
	private static final String CUSTOM_CSS_URL = "collegeapplicationstyle.css";
	private static final String CUSTOM_JS_URL = "collegeapplication.js";

	private IStorage<CollegeApplication> appStorage;
	
	public HtmlUtil(IStorage<CollegeApplication> appStorage) {
		this.appStorage = appStorage;
	}
	
	/**
	 * Renders out the HTML head. 
	 * @return the <head> element of the page
	 */
	public String buildHtmlHead() {
		return "<head>"
			+ 	 "<title>HNA College Application Tool</title>"
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
			+	  "<h1>HNA College Application Tool</h1>"
			+	"</div>";
	}

	/**
	 * Renders out the college application form
	 * @return the college application form
	 */
	public String buildApplicationForm() {
		// TODO add more functionality to the form to support:
		//		- textbox for college name (already implemented)
		//		- dropdown for safety/match/reach
		//		- checkbox for completed
		//		- textbox for due date
		//		- anything else you want to add
		return "<div class='application-form content-padding form-inline'>"
			+	 "<h3>Please enter a new college application</h3>"
			+	 "<form action='?action=add' method='post'>"
			+		"College Name: <input type='text' class='form-control' name='collegeName' id='collegeNameInputBox' />"
					// Add those things here!
			+	 "</form>"
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
		return "";
	}
}