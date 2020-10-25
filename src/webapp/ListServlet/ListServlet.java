package webapp.ListServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.beans.MemoInfobeans;
/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("【メモ一覧表示】");
		ArrayList< MemoInfobeans> memoinfo =new ArrayList<>();

	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

		 try {
			// 接続情報
			String url="jdbc:mariadb://localhost:3306/Memo";
			String user="user01";
			String password="user01";

			conn = DriverManager.getConnection(url, user, password);


			String sql =
					"SELECT\r\n" +
					"	posts.id,\r\n" +
					"	posts.title,\r\n" +
					"	posts.content \r\n" +
					"FROM\r\n" +
					"	posts\r\n";

			// デバック用
			System.out.println(sql);
			 ps =conn.prepareStatement(sql);

			 rs = ps.executeQuery();

			 while(rs.next()) {
				 int Id =rs.getInt("id");
				 String Title =rs.getString("title");
				 String Content =rs.getString("content");

				 MemoInfobeans MemoInfo =new MemoInfobeans();
				 MemoInfo.setId(Id);
				 MemoInfo.setTitle(Title);
				 MemoInfo.setContent(Content);

				 memoinfo.add(MemoInfo);
			 }

		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally{
		  try {
			if(conn !=null) {
			conn.close();
			}
		  }catch(SQLException e) {
			e.printStackTrace();
		 }
	 }
	// デバック用
	System.out.println(memoinfo);

	request.setAttribute("memoinfo", memoinfo);



         // view
		 String view ="WEB-INF/views/List.jsp";
		 RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		 dispatcher.forward(request, response);
	}
}
