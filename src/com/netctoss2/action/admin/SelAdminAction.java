package com.netctoss2.action.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;
import com.netctoss2.service.AdminService;
import com.netctoss2.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class SelAdminAction
 */
public class SelAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String roleName = request.getParameter("roleName");
		String perID = request.getParameter("perID");
		Role role = null;
		Permissions per = null;
		if(!"".equals(roleName)){
			role = new Role();
			role.setRoleName(roleName);
		}
		if(!"0".equals(perID)){
			per = new Permissions();
			per.setPerID(perID);
		}
		AdminService adminService = new AdminServiceImpl();
		List<Admin> la = adminService.getPageAdmin(0, 10,role,per);
		request.setAttribute("adminList", la);
		request.getRequestDispatcher("../view/admin/admin_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
