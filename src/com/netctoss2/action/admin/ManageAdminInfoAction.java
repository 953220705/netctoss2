package com.netctoss2.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Role;
import com.netctoss2.service.AdminService;
import com.netctoss2.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class ManageAdminInfoAction
 */
public class ManageAdminInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAdminInfoAction() {
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
		Admin admin = new Admin();
		admin.setAdminID(request.getParameter("adminID"));
		admin.setAdminLog(request.getParameter("adminLog"));
		admin.setAdminName(request.getParameter("adminName"));
		admin.setAdminPhone(request.getParameter("adminPhone"));
		admin.setAdminEmail(request.getParameter("adminEmail"));
		String[] roles = request.getParameterValues("roleID");
		List<Role> lro = new ArrayList<Role>();
		for(int i=0;i<roles.length;i++){
			Role ro = new Role();
			ro.setRoleID(roles[i]);
			lro.add(ro);
		}
		admin.setLro(lro);
		boolean b = adminService.manageAdmin(admin);
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
