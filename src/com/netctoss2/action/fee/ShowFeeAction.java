package com.netctoss2.action.fee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Fee;
import com.netctoss2.service.FeeService;
import com.netctoss2.service.impl.FeeServiceImpl;

/**
 * Servlet implementation class ShowFeeAction
 */
public class ShowFeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFeeAction() {
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
		Fee fee = new Fee();
		fee.setFeeID(request.getParameter("feeID"));
		Fee fee1 = feeService.selFeeByFeeID(fee);
		request.setAttribute("feeInfo", fee1);
		request.setAttribute("check"+fee1.getFeeType(), "checked");
		request.getRequestDispatcher("../view/fee/fee_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
