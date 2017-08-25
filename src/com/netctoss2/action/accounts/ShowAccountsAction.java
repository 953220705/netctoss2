package com.netctoss2.action.accounts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Accounts;
import com.netctoss2.service.AccountsService;
import com.netctoss2.service.impl.AccountsServiceImpl;

/**
 * Servlet implementation class ShowAccountsAction
 */
public class ShowAccountsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAccountsAction() {
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
		acc.setAcc_id(request.getParameter("accID"));
		Accounts acc1 = accService.getAccByID(acc);
		if("0".equals(acc1.getAcc_state())){
			acc1.setAcc_state("暂停");
		}
		if("1".equals(acc1.getAcc_state())){
			acc1.setAcc_state("开通");
		}
		if("2".equals(acc1.getAcc_state())){
			acc1.setAcc_state("删除");
		}
		request.setAttribute("accInfo", acc1);
		request.setAttribute("check"+acc1.getAcc_sex(), "checked");
		if("s".equals(request.getParameter("page"))){
			request.getRequestDispatcher("../view/account/account_detail.jsp").forward(request, response);
		}
		if("u".equals(request.getParameter("page"))){
			if("干部".equals(acc1.getAcc_job())){
				request.setAttribute("select1", "selected");
			}
			if("学生".equals(acc1.getAcc_job())){
				request.setAttribute("select2", "selected");
			}
			if("技术人员".equals(acc1.getAcc_job())){
				request.setAttribute("select3", "selected");
			}
			if("其他".equals(acc1.getAcc_job())){
				request.setAttribute("select4", "selected");
			}
			request.getRequestDispatcher("../view/account/account_modi.jsp").forward(request, response);
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
