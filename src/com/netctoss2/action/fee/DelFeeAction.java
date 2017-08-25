package com.netctoss2.action.fee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Fee;
import com.netctoss2.service.FeeService;
import com.netctoss2.service.impl.FeeServiceImpl;

/**
 * Servlet implementation class DelFeeAction
 */
public class DelFeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelFeeAction() {
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
		boolean b = feeService.delFee(fee);
		if(b){
			request.setAttribute("delFlag1", "dsf");
			request.setAttribute("delFlag2", "dsf");
		}else{
			request.setAttribute("delFlag1", "dsf");
		}
		List<Fee> lf = feeService.selPageFee(0,10,null,null);
		request.setAttribute("feeList", lf);
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
