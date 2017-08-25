package com.netctoss2.action.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Services;
import com.netctoss2.service.ServicesService;
import com.netctoss2.service.impl.ServicesServiceImpl;

/**
 * Servlet implementation class ShowSerInfoAction
 */
public class ShowSerInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSerInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServicesService serService = new ServicesServiceImpl();
		Services ser = new Services();
		ser.setSer_id(request.getParameter("serid"));
		Services ser1 = serService.getServicesByID(ser);
		request.setAttribute("serInfo", ser1);
		request.setAttribute("select"+ser.getSer_state(), "selected");
		request.setAttribute("fselect"+ser1.getFee().getFeeID(), "selected");
		if("s".equals(request.getParameter("page"))){
			request.getRequestDispatcher("../view/service/service_detail.jsp").forward(request, response);
		}
		if("u".equals(request.getParameter("page"))){
			request.getRequestDispatcher("../view/service/service_modi.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
