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
 * Servlet implementation class AddAccountsAction
 */
public class AddAccountsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountsAction() {
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
		acc.setAcc_name(request.getParameter("accname"));
		acc.setAcc_idcard(request.getParameter("accidcard"));
		acc.setAcc_log(request.getParameter("acclog"));
		acc.setAcc_psw(request.getParameter("accpsw"));
		acc.setAcc_phone(request.getParameter("accphone"));
		acc.setAcc_recidcard(request.getParameter("reidcard"));
		acc.setAcc_email(request.getParameter("accemail"));
		acc.setAcc_job(request.getParameter("accjob"));
		acc.setAcc_sex(request.getParameter("radSex"));
		acc.setAcc_address(request.getParameter("accaddress"));
		acc.setAcc_qq(request.getParameter("accqq"));
		acc.setAcc_zipcode(request.getParameter("acczip"));
		boolean b = accService.insertAcc(acc);
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
