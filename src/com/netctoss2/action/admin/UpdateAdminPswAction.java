package com.netctoss2.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netctoss2.entity.Admin;
import com.netctoss2.service.AdminService;
import com.netctoss2.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class UpdateAdminPswAction
 */
public class UpdateAdminPswAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminPswAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		AdminService adminService = new AdminServiceImpl();
		HttpSession session = request.getSession();
		Admin admin = new Admin();
		admin.setAdminID(request.getParameter("adminID"));
		admin.setAdminPsw(request.getParameter("newPsw"));
		boolean b = adminService.updateAdminPsw(admin);
		if(b){
			Admin admin1 = (Admin) session.getAttribute("admin");
			admin1.setAdminID(request.getParameter("adminID"));
			admin1.setAdminPsw(request.getParameter("newPsw"));
			session.setAttribute("admin", admin1);
		}
		//request.setAttribute("flag", b);
		//request.getRequestDispatcher("../view/user/user_modi_pwd.jsp").forward(request, response);
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
