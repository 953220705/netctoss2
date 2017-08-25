package com.netctoss2.action.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Accounts;
import com.netctoss2.entity.Fee;
import com.netctoss2.entity.Services;
import com.netctoss2.service.ServicesService;
import com.netctoss2.service.impl.ServicesServiceImpl;

/**
 * Servlet implementation class AddSerAction
 */
public class AddSerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSerAction() {
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
		Accounts acc = new Accounts();
		Fee fee = new Fee();
		acc.setAcc_log(request.getParameter("acclog"));
		ser.setAcc(acc);
		fee.setFeeID(request.getParameter("feeid"));
		ser.setFee(fee);
		ser.setSer_ip(request.getParameter("ip"));
		ser.setSer_oslog(request.getParameter("oslog"));
		ser.setSer_ospsw(request.getParameter("ospsw"));
		boolean b = serService.addService(ser);
		PrintWriter out = response.getWriter();
		out.println(b);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
