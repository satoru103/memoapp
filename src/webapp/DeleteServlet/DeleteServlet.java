package webapp.DeleteServlet;

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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("削除処理");
		int Id = Integer.parseInt(request.getParameter("id"));

		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;

		String url="jdbc:mariadb://localhost:3306/Memo";
		String user="user01";
		String password="user01";

		try {
			conn =DriverManager.getConnection(url,user,password);

			String sql=
				"DELETE FROM posts\r\n"+
				"WHERE id=?\r\n";

			ps =conn.prepareStatement(sql);

			ps.setInt(1,"id");

			ps.executeUpdate(sql);

			System.out.println(sql);

			conn.commit();

		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
