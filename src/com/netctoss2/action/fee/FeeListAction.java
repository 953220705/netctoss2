package com.netctoss2.action.fee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netctoss2.entity.Fee;
import com.netctoss2.service.FeeService;
import com.netctoss2.service.impl.FeeServiceImpl;

/**
 * Servlet implementation class FeeListAction
 */
public class FeeListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeeListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		FeeService feeService = new FeeServiceImpl();
		List<Fee> lf = feeService.selPageFee(0,10,null,null);
		request.setAttribute("feeList", lf);
		HttpSession session = request.getSession();
		session.setAttribute("classunit_cost", "sort_asc");
		session.setAttribute("classbasic_fee", "sort_asc");
		session.setAttribute("classbasic_time", "sort_asc");
		request.getRequestDispatcher("../view/fee/fee_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
