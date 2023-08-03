package com.kosa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	public BoardController() {
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd"); // ~~~~?cmd=list
		System.out.println("cmd: " + cmd);

		if (cmd.equals("list")) {
			list(request, response);

		} else if (cmd.equals("writeForm")) {

			writeForm(request, response);
		} else if (cmd.equals("write")) {

			write(request, response);
		} else if (cmd.equals("detail")) {

			detail(request, response);
		} else if (cmd.equals("update")) {

			update(request, response);
		} else if (cmd.equals("delete")) {

			delete(request, response);
		} else if (cmd.equals("search")) {

			search(request, response);
		} else if (cmd.equals("search2")) {

			search2(request, response);
		} else if (cmd.equals("searchList")) {

			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
			
		}
	} // service end

	// detail page
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seq = request.getParameter("seq");
		BoardDAO dao = new BoardDAO();
		BoardVO dto = dao.detailList(Integer.parseInt(seq));

		if (dto != null) {
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");

		}
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			// response.sendRedirect("index.html");
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);

	}

	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		System.out.println(title + ",\t" + writer + ",\t" + content);

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(title, writer, content);

		int rowcount = dao.insert(vo);

		if (rowcount > 0) {
			response.sendRedirect("board?cmd=list");
		} else {

			response.sendRedirect("views/error.jsp");
		}
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String seq = request.getParameter("seq");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(Integer.parseInt(seq), title, writer, content);
		int count = dao.update(vo);
		if (count > 0) {
			response.sendRedirect("board?cmd=list");
			// list(request,response);

		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {

		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardDAO dao = new BoardDAO();

		int deleteContent = dao.delete(seq);

		if (deleteContent > 0) {
			response.sendRedirect("board?cmd=list");

		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO>list = dao.selectSearchList(map);

		if (list != null) {

			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}

	private void search2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("content", content);
		map.put("writer", writer);
		map.put("keyvalue", keyvalue);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO>list = dao.selectSearchList2(map);
		
		
		if (list != null) {

			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);

		} else {
			response.sendRedirect("/WEB-INF/views/error.jsp");

		}

	}
}
