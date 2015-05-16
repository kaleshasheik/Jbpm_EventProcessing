package com.aricent.process;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Map;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aricent.process.ProcessBean;



public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProcessBean processService;


	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		Map<String, Object> params = new HashMap<String, Object>();
		String notifytype=(String)req.getParameter("notifytype");

		
		params.put("notifytype", notifytype);

		try {

			 processService.startProcess(
						"com.aricent.bpmn.process",params);
				out.println("Events processed");
				out.println("<a href=\"ProcessEvent.jsp\">Process Events Again</a> <br/>");


		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	
}
