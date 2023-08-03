package board.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {

	private int seq;
	private String title, writer, content;
	private Date regdate;
	private int readcount;

	private String searchCondition;
	private String searchKeyword;

	@Override
	public String toString() {
		return "[seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", readcount=" + readcount + "]";
	}

}

//seq number,
//title VARCHAR2(50),
//writer VARCHAR2(30),
//content VARCHAR2(200),
//regdate date,
//readcount number