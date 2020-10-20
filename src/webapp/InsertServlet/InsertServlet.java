package webapp.InsertServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.beans.MemoInfobeans;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("メモ追加");

		MemoInfobeans MemoInfo =new MemoInfobeans();

		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;

		try {
			String url="jdbc:mariadb://localhost:3306/Memo";
			String user="user01";
			String password="user01";

			conn = DriverManager.getConnection(url,user,password);

			String sql=
					"SELECT\r\n"+
					"posts.title,\r\n"+
					"posts.content,\r\n"+
					"FROM\r\n"+
					"posts";

			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			rs =ps.executeQuery();

			System.out.println(rs);

		while(rs.next()) {
			String Title=rs.getString("title");
			String Content =rs.getString("content");

			MemoInfobeans Memoinfo =new MemoInfobeans();
			Memoinfo.setTitle("Title");
			Memoinfo.setContent("Content");

			System.out.println("Title");
			System.out.println("Content");
		}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(ps !=null) {
					ps.close();
				}
				if(rs !=null) {
					rs.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}

			request.setAttribute("MemoInfo",MemoInfo);

			request.getRequestDispatcher("/views/Insert.jsp").forward(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");

		String title =request.getParameter("title");
		System.out.println(title);
		String content =request.getParameter("content");
		System.out.println(content);

		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;

		String url="jdbc:mariadb://localhost:3306/Memo";
		String user="user01";
		String password="user01";

		try {
			conn =DriverManager.getConnection(url,user,password);

			String sql =
					"INSERT INTO posts(\r\n"+
					"id,\r\n"+
					"title,\r\n"+
					"content,\r\n"+
					")\r\n"+
				"VALUES(\r\n"+
				"LAST_INSERT_ID(),\r\n" +
				"?,\r\n				  " +
				"?,\r\n				  " +
				")\r\n";

			System.out.println(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {

			}catch{

			}
		}




	}

}
