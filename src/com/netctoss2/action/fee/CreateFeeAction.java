package com.netctoss2.action.fee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netctoss2.entity.Fee;
import com.netctoss2.service.FeeService;
import com.netctoss2.service.impl.FeeServiceImpl;

/**
 * Servlet implementation class CreateFeeAction
 */
public class CreateFeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFeeAction() {
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
		fee.setFeeName(request.getParameter("feeName"));
		fee.setFeeType(request.getParameter("radFeeType"));
		if(request.getParameter("feeBTime")==null){
			fee.setBasicTime(0);
		}else{
			fee.setBasicTime(Integer.parseInt(request.getParameter("feeBTime")));
		}
		if(request.getParameter("feeBFee")==null){
			fee.setBasicFee(0);
		}else{
			fee.setBasicFee(Integer.parseInt(request.getParameter("feeBFee")));
		}
		if(request.getParameter("feeUCost")==null){
			fee.setUnitCost(0);
		}else{
			fee.setUnitCost(Integer.parseInt(request.getParameter("feeUCost")));
		}
		fee.setInstructions(request.getParameter("instructions"));
		System.out.println("fs");
		boolean b = feeService.insertFee(fee);
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
