package com.netctoss2.action.accounts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Accounts;
import com.netctoss2.service.AccountsService;
import com.netctoss2.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class SelAccountsAction
 */
public class SelAccountsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelAccountsAction() {
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
		if(!"".equals(request.getParameter("idcard"))){
			acc.setAcc_idcard(request.getParameter("idcard"));
		}
		if(!"".equals(request.getParameter("name"))){
			acc.setAcc_name(request.getParameter("name"));
		}
		if(!"".equals(request.getParameter("log"))){
			acc.setAcc_log(request.getParameter("log"));
		}
		if(!"-1".equals(request.getParameter("state"))){
			acc.setAcc_state(request.getParameter("state"));
		}
		List<Accounts> lacc = accService.getAccByCondition(0, 10, acc);
		request.setAttribute("lac", lacc);
		request.getRequestDispatcher("../view/account/account_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
