package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDaoImpl userdao;

	public void init() throws ServletException {
		try {
			userdao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in init" + getClass(), e);
		}

	}

	public void destroy() {
		try {
			userdao.cleanUp();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = userdao.signIn(email, password);

			if (user == null) {
				pw.print("<h5>Invalid Login , Please  <a href='login.html'>Retry</a><h5>");
			} else {
				Cookie c1 = new Cookie("user_details", user.toString());
				response.addCookie(c1);
				if (user.getRole().equals("voter")) {

					if (user.isStatus()) {
						response.sendRedirect("logout");
					} else {
						response.sendRedirect("candidate_list");
					}
				} else if (user.getRole().equals("admin")) {
					response.sendRedirect("admin");
				}
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
