package mainApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainApp.ForecastItApplication;
import mainApp.storage.*;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index.html")
public class Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static IStorage<ForecastItApplication> appStorage = 
			new LocalDiskStorage<ForecastItApplication>();
	
	// Uncomment the following 2 lines if you make it to the task portion of
	// the assignment
//	private static IStorage<CollegeApplicationTask> appTaskStorage = 
//			new LocalDiskStorage<CollegeApplicationTask>();
	
	private HtmlUtil htmlUtil;

	public Index() {
        super();
        appStorage.onStartup();;
        htmlUtil = new HtmlUtil(appStorage);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseHtml = "";
		
		PrintWriter writer = response.getWriter();

		// Open up the HTML document with correct identifier
		responseHtml += "<!DOCTYPE html><html>";

		// Add in the header. This contains metadata about the page, and tells
		// the client about any other resources it should grab (javascript, html
		// css, etc) to successfully render this page
		responseHtml += htmlUtil.buildHtmlHead();

		// Start the body of the html document. This is where all of the visible
		// content on the page is defined
		responseHtml += "<body>";

		// Include the header. This is the content we'll put at the top of the
		// page
		responseHtml += htmlUtil.buildBodyHeader("Jane Doe");

		// *********************************************************************
		// TODO render out the college application form
		responseHtml += htmlUtil.buildApplicationForm();
				
		// TODO render out all the applications
		responseHtml += htmlUtil.buildCollegeApplicationList();
		
		// TODO If you have time,render out the tasks for each application
		// *********************************************************************
		
		responseHtml = this.renderFilter(responseHtml, request);

		// Don't forget to close all the tags that were opened!
		responseHtml += "</body></html>";

		// Finally, let's write out the entire html string we've built to the
		// body of the http response
		response.getWriter().println(responseHtml);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionType = request.getParameter("action");

		if ("add".equals(actionType)) {
			// Get the college name from the request
			String courseName = request.getParameter("courseName");
			String homeworkHours = request.getParameter("homeworkHoursInputBox");
			boolean wouldRetake = "retake".equals(request.getParameter("retake"));
			String comments = request.getParameter("comments");

			// Create a new application object and set the college name
			ForecastItApplication newApp = new ForecastItApplication();
			newApp.setName(courseName);
			newApp.setHours(homeworkHours);
			newApp.setRetake(wouldRetake);
			newApp.setComments(comments);

			// Save the application to storage
			appStorage.create(newApp);
		}
//		else if ("remove".equals(actionType)) {
//			// Delete the existing application
//			String idToDelete = request.getParameter("id");
//		}

		//TO DO: FIX ABOVE TO DELETE 
		
		// Redirect back to the "homepage" (the GET method)
		response.sendRedirect("/Forcasting-Application/index.html");
	}
	
	private String renderFilter(String writer, HttpServletRequest request)
	{
		String courseNameFilter = request.getParameter("courseName");
		String homeworkHoursFilter = request.getParameter("homeworkHoursInputBox");
		boolean retakeFilter = "retake".equals(request.getParameter("retake"));
		
		
		
		for(ForecastItApplication app : appStorage.read())
		{
			if(courseNameFilter !=null)
			{
				if(app.getName().compareToIgnoreCase(courseNameFilter) == 0)
					{
						writer += app.toHTMLElement();
					}
			}
				
			//TO DO fix the 0 issue (can't check if a double value "is null" because not a reference type, primitive	
			else if(homeworkHoursFilter != null)

			{
				if(app.getHours().compareToIgnoreCase((homeworkHoursFilter)) == 0)
					{
						writer += app.toHTMLElement();
					}
			} 
			
			else if(retakeFilter != false)
				{
					writer += app.toHTMLElement();
				}
			
//			else
//				{
//					writer += app.toHTMLElement();
//				}
			
			}
		return writer;
	}
}
