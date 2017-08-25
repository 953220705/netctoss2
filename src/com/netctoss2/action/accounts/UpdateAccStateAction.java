package com.netctoss2.action.accounts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Accounts;
import com.netctoss2.service.AccountsService;
import com.netctoss2.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class UpdateAccStateAction
 */
public class UpdateAccStateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccStateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AccountsService accService = new AccountsServiceImpl();
		Accounts acc = new Accounts();
		acc.setAcc_id(request.getParameter("accid"));
		if("btn_pause".equals(request.getParameter("class"))){
			acc.setAcc_state("0");
		}else if("btn_start".equals(request.getParameter("class"))){
			acc.setAcc_state("1");
		}else{
			acc.setAcc_state("2");
		}
		boolean b = accService.updateAccState(acc);
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
