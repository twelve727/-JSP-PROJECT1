package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrder")
public class PizzaOrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String size = req.getParameter("size"); // R / L
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		// Integer.parseInt("문자열") : 숫자 형태 String -> int 변환
		
		// (기본(10000) + 사이즈(0 or 2000) * 수량(1~10))
		int temp = 0;
		if(size.equals("L")) temp = 2000;
		
		// 최종금액
		int total = (10000 + temp) * amount;
		
		// JSP 요청 위임 객체 생성(JSP 경로 지정)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");
		
		
		// req, resp 객체 JSP로 위임
		req.setAttribute("tot", total);
		dispatcher.forward(req, resp);
		
	}
	
}
