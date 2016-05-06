package mainApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

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
		
		//PrintWriter writer = response.getWriter();

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
		responseHtml += htmlUtil.buildBodyHeader();

		// *********************************************************************
		// render the application form
		responseHtml += htmlUtil.buildApplicationForm();
				
		// render all the applications, or all that match filter if specified
		String filterCourseName = "";

		String filter = request.getParameter("filter");
		if (filter == null)
		{
			filter = "false";
		}

		if (filter.equals("true"))
		{
			filterCourseName = request.getParameter("filterCourseName");		
		}
		responseHtml += htmlUtil.buildCourseList(filter, filterCourseName);
		
		responseHtml += "</body></html>";

		response.getWriter().println(responseHtml);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionType = request.getParameter("action");

		if ("add".equals(actionType)) {
			// Get the course name from the request
			String courseName = request.getParameter("courseName");
			String homeworkHours = request.getParameter("homeworkHoursInputBox");
			boolean wouldRetake = "retake".equals(request.getParameter("retake"));
			String comments = request.getParameter("comments");

			// Create a new application object and set the info
			ForecastItApplication newApp = new ForecastItApplication();
			newApp.setName(courseName);
			newApp.setHours(homeworkHours);
			newApp.setRetake(wouldRetake);
			newApp.setComments(comments);

			// Save the application to storage
			appStorage.create(newApp);
			
			response.sendRedirect("/Forcasting-Application/index.html");
		}
		
		else if ("filter".equals(actionType))
		{
			// Build the filter parameters
			String filterCourseName = request.getParameter("filterCourseName");
			
			String filter="";
			if (!filterCourseName.isEmpty())
			{
				filter += "&filterCourseName=" + URLEncoder.encode(filterCourseName, "UTF-8");
			}
			
			
			if (!filter.isEmpty())
			{
				response.sendRedirect("/Forcasting-Application/index.html?filter=true" + filter);				
			}
			else
				response.sendRedirect("/Forcasting-Application/index.html");
		}
		else {} 
		
	}

// not currently in use
//	private String renderFilter(String writer, HttpServletRequest request)
//	{
//		String courseNameFilter = request.getParameter("courseName");
//				
//		for(ForecastItApplication app : appStorage.read())
//		{
//			if(courseNameFilter !=null)
//			{
//				if(app.getName().compareToIgnoreCase(courseNameFilter) == 0)
//					{
//						writer += app.toHTMLElement();
//					}
//			}
//			
//		 }
//		return writer;
//	}
  }
