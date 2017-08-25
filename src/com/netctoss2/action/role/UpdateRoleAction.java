package com.netctoss2.action.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;
import com.netctoss2.service.RoleService;
import com.netctoss2.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class UpdateRoleAction
 */
public class UpdateRoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoleAction() {
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
		role.setRoleName(request.getParameter("roleName"));
		String[] permissions = request.getParameterValues("permission");
		List<Permissions> lpe = new ArrayList<Permissions>();
		for(int i=0;i<permissions.length;i++){
			Permissions per = new Permissions();
			per.setPerID(permissions[i]);
			lpe.add(per);
		}
		role.setLpe(lpe);
		boolean b = roleService.updateRole(role);
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
