package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S_Guardar_Cookies
 */
@WebServlet("/S_Guardar_Cookies")
public class S_Guardar_Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public S_Guardar_Cookies() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user="";
	    String password=request.getParameter("password");
		user=request.getParameter("user");
		 
		Cookie cusuario=new Cookie("user",user);
		Cookie cpassword=new Cookie("password",password);
		cusuario.setMaxAge(3600);//durancion de la cookie.
		System.out.println("Realizo la cookie.");
		response.addCookie(cusuario);
		response.addCookie(cpassword);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
