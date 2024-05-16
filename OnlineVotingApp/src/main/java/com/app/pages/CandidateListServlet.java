package com.app.pages;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.CandidateDaoImpl;


@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private CandidateDaoImpl cdao;
	

@Override
public void init() throws ServletException {
	try {
		cdao = new CandidateDaoImpl();
	} catch (SQLException e) {
		throw new ServletException("Error in init" + getClass(), e);
	}
	super.init();
}

@Override
public void destroy() {
	try {
		cdao.cleanup();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
