package com.netctoss2.action.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Accounts;
import com.netctoss2.entity.Services;
import com.netctoss2.service.ServicesService;
import com.netctoss2.service.impl.ServicesServiceImpl;

/**
 * Servlet implementation class SelSerAction
 */
public class SelSerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelSerAction() {
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
		if(!"".equals(request.getParameter("oslog"))){
			ser.setSer_oslog(request.getParameter("oslog"));
		}
		if(!"".equals(request.getParameter("ip"))){
			ser.setSer_ip(request.getParameter("ip"));
		}
		if(!"".equals(request.getParameter("idcard"))){
			Accounts acc = new Accounts();
			acc.setAcc_idcard(request.getParameter("idcard"));
			ser.setAcc(acc);
		}
		if(!"-1".equals(request.getParameter("state"))){
			ser.setSer_state(request.getParameter("state"));
		}
		List<Services> lser = serService.getPageServices(0, 10, ser);
		request.setAttribute("lser", lser);
		request.getRequestDispatcher("../view/service/service_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
