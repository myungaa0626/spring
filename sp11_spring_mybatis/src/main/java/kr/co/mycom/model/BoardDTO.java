package kr.co.mycom.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {

	private int num;
	private String name, email, pwd, subject, content;
	private Date regdate;
	private int hit, parent, sort, tab;
	
	
	
	
}







//CREATE TABLE spring_board (
//		  num NUMBER, 
//		  name VARCHAR2(50), 
//		  email  VARCHAR2(50), 
//		  pwd  VARCHAR2(50), 
//		  subject  VARCHAR2(50), 
//		  content  VARCHAR2(2000), 
//		  regdate  date,
//		  hit  NUMBER, 
//		  parent  NUMBER, 
//		  sort  NUMBER, 
//		  tab  NUMBER
//	);












