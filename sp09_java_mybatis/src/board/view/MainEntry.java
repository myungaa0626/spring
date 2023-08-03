package board.view;

import java.util.List;
import java.util.Scanner;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();

		Scanner sc = new Scanner(System.in);

		System.out.println("선택: 1.select 2.update 3. insert 4. delete");

		switch (sc.nextInt()) {
		case 1:

			List<BoardVO> list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			break;

		case 2:

			list = dao.selectAll();
			System.out.println(list);

			System.out.print("내용: ");
			vo.setContent(sc.next());
			System.out.print("제목: ");
			vo.setTitle(sc.next());
			System.out.print("작성자: ");
			vo.setWriter(sc.next());
			System.out.print("글 번호: ");
			vo.setSeq(sc.nextInt());
			dao.update(vo);
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			break;

		case 3:

			System.out.println("제목: ");
			vo.setTitle(sc.next());
			System.out.println("작성자: ");
			vo.setWriter(sc.next());
			System.out.println("내용: ");
			vo.setContent(sc.next());
			dao.insert(vo);

			
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}
			
			break;

		case 4: // delete 1

			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			System.out.println("글번호: ");
			vo.setSeq(sc.nextInt());

			dao.delete(vo);
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			break;
			
		case 5: // delete 2

			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			System.out.println("글번호: ");

			dao.delete2(sc.nextInt());
			list = dao.selectAll();
			for (BoardVO board : list) {
				System.out.println(board);
			}

			break;

		default:
			break;
		}

	}
}