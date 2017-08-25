package com.netctoss2.action.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Services;
import com.netctoss2.service.ServicesService;
import com.netctoss2.service.impl.ServicesServiceImpl;

/**
 * Servlet implementation class UpdateSerStateAction
 */
public class UpdateSerStateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSerStateAction() {
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
		if("btn_start".equals(request.getParameter("class"))){
			ser.setSer_state("1");
		}else if("btn_pause".equals(request.getParameter("class"))){
			ser.setSer_state("0");
		}else{
			System.out.println("ss");
			ser.setSer_state("2");
		}
		boolean b = serService.updateSerState(ser);
		PrintWriter out = response.getWriter();
		System.out.println(b);
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
