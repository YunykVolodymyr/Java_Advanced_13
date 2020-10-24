package ua.yunyk.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.yunyk.domain.User;
import ua.yunyk.service.BucketService;
import ua.yunyk.service.impl.BucketServiceImpl;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BucketService bucketService = BucketServiceImpl.getBucketService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("HERE");
		//String bucketId = req.getParameter("bucketId");
		bucketService.delete(Integer.parseInt("71347890-1ab0-44e2-af81-ebe5c333b90f"));
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("Success");
	}

}
