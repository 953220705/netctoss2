package com.netctoss2.action.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;
import com.netctoss2.service.RoleService;
import com.netctoss2.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class UpdateShowAction
 */
public class UpdateShowAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShowAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RoleService roleService = new RoleServiceImpl();
		Role role = new Role();
		role.setRoleID(request.getParameter("roleID"));
		Role role1 = roleService.getRole(role);
		for(Permissions p:role1.getLpe()){
			System.out.println(p.getPerID());
			request.setAttribute("check"+p.getPerID(), "checked");
		} 
		request.setAttribute("role", role1);
		request.getRequestDispatcher("/view/role/role_modi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
