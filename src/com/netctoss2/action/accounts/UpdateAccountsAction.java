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
 * Servlet implementation class UpdateAccountsAction
 */
public class UpdateAccountsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountsAction() {
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
		acc.setAcc_name(request.getParameter("name"));
		if(!"".equals(request.getParameter("psw"))){
			acc.setAcc_psw(request.getParameter("psw"));
		}
		acc.setAcc_phone(request.getParameter("phone"));
		acc.setAcc_recidcard(request.getParameter("recidcard"));
		acc.setAcc_email(request.getParameter("email"));
		acc.setAcc_job(request.getParameter("job"));
		acc.setAcc_sex(request.getParameter("radSex"));
		acc.setAcc_address(request.getParameter("address"));
		acc.setAcc_qq(request.getParameter("qq"));
		acc.setAcc_zipcode(request.getParameter("zipcode"));
		boolean b = accService.updateAcc(acc);
		System.out.println(b);
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
