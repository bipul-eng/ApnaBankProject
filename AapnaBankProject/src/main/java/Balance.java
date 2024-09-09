import java.io.IOException;
import java.sql.SQLException;

import com.bipul.model.LoginDao;
import com.bipul.model.UserBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/balance")
public class Balance extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub=null;
		String accno = req.getParameter("ano");
		String uname = req.getParameter("uname");
		String password = req.getParameter("pass1");
		
		LoginDao ld=new LoginDao();
		
		try {
			
			ub=ld.loginDao(accno, uname, password);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(ub!=null)
		{
		req.setAttribute("customer", ub);
		req.getRequestDispatcher("balance.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("customer", ub);
			req.getRequestDispatcher("balancefail.jsp").forward(req, res);
		}
	}
}
