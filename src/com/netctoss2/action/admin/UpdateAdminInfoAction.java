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
 * Servlet implementation class UpdateAdminInfoAction
 */
public class UpdateAdminInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminInfoAction() {
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
		admin.setAdminLog(request.getParameter("adminLog"));
		admin.setAdminName(request.getParameter("name"));
		admin.setAdminPhone(request.getParameter("phone"));
		admin.setAdminEmail(request.getParameter("email"));
		boolean b = adminService.updateAdmin(admin);
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
