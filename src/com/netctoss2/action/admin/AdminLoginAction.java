package com.netctoss2.action.admin;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.netctoss2.entity.Permissions;
import com.netctoss2.entity.Role;
import com.netctoss2.service.PermissionsService;
import com.netctoss2.service.RoleService;
import com.netctoss2.service.impl.PermissionsServiceImpl;
import com.netctoss2.service.impl.RoleServiceImpl;
import com.netctoss2.entity.Admin;
import com.netctoss2.entity.Fee;
import com.netctoss2.service.AdminService;
import com.netctoss2.service.FeeService;
import com.netctoss2.service.impl.AdminServiceImpl;
import com.netctoss2.service.impl.FeeServiceImpl;

/**
 * Servlet implementation class AdminLoginAction
 */
public class AdminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginAction() {
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
		admin.setAdminLog(request.getParameter("adminLog"));
		admin.setAdminPsw(request.getParameter("adminPsw"));
		Admin admin1 = adminService.login(admin);
		HttpSession session = request.getSession();
		PermissionsService perService = new PermissionsServiceImpl();
		List<Permissions> lpe = perService.getAllPermissions();
		RoleService roleService = new RoleServiceImpl();
		List<Role> lro = roleService.getAllRole();
		FeeService feeService = new FeeServiceImpl();
		List<Fee> lfe = feeService.selAllFee();
		//FeeService feeService = new FeeServiceImpl();
		//List<Fee> lf = feeService.selAllFee();
		if(admin1!=null){
			session.setAttribute("admin", admin1);
			session.setAttribute("error", false);
			session.setAttribute("allRole", lro);
			session.setAttribute("allPer", lpe);
			session.setAttribute("allFee", lfe);
			//session.setAttribute("allFee", lf);
			response.sendRedirect("../view/index.jsp");
		}else{
			session.setAttribute("error", true);
			response.sendRedirect("../view/login.jsp");
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
