package edu.kosa.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("ctx.xml");

		UserDAO dao = ctx.getBean("dao", UserDAO.class);

		dao.menu();
		Scanner sc = new Scanner(System.in);

		switch (sc.nextInt()) {
		case 1:
			UserVO vo = new UserVO();
			System.out.println("user id= ");
			vo.setId(sc.next());
			System.out.println("user name= ");
			vo.setName(sc.next());
			System.out.println("user pass= ");
			vo.setPassword(sc.next());

			dao.insert(vo);
			System.out.println(vo.getId() + "추가 성공!!");
			System.out.println("-----------------");
			break;

		case 2: // selectAll
			dao.selectAll();

			break;

		case 3: // selectByID

			System.out.println("user id= ");
			String id = sc.next();

			dao.selectById(id);

			break;

		case 4: // update

			System.out.println("user id= ");
			id = sc.next();
			System.out.println("user name= ");
			String name = sc.next();
			System.out.println("user password= ");
			String pwd = sc.next();

			dao.updateByID(id, name, pwd);

			System.out.println("수정되었습니다.");

			break;

		case 5: // delete

			System.out.println("user id= ");
			id = sc.next();

			dao.deleteByID(id);

			System.out.println(id + " 삭제되었습니다.");

			break;

		default:
			break;
		}
	}
}
