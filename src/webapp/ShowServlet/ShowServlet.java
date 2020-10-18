package webapp.ShowServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		 if (request.getAttribute("message") == null) {
	         request.setAttribute("message", "This is your post " + id);

	      Connection conn = null;
	 	  PreparedStatement ps = null;
	 	  ResultSet rs = null;

	      // 接続情報
			 String url="jdbc:mariadb://localhost:3306/Memo";
			 String user="user01";
			 String password="user01";

		try {
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT * FROM posts WEHRE id= ?";
		    ps =conn.prepareStatement(sql);
		    rs =ps.executeQuery();

		    while(rs.next()) {

		    	String Postid =rs.getString("id");
		    	request.setAttribute("Postid",Postid);

		    	String content =rs.getString("content");
		    	request.setAttribute("content",content);

		    	String title =rs.getString("title");
		    	request.setAttribute("title",title);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}

	    String view ="/WEB-INF/views/post.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
	}
   }
}
