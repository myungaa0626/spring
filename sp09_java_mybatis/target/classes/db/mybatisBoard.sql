select * from mybatisBoard;

create table mybatisBoard (
    seq INT NOT NULL auto_increment,
    title VARCHAR2(50),
    writer VARCHAR2(30),
    content VARCHAR2(200),
    regdate date,
    readcount INT 
);



CREATE TABLE `mybatisBoard` (
	`seq` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(50) NOT NULL DEFAULT 'title',
	`writer` VARCHAR(30) NOT NULL DEFAULT 'writer',
	`content` TEXT(2000) NOT NULL DEFAULT 'contents',
	`regdate` DATE NOT NULL DEFAULT CURDATE(),
	`readcount` INT NULL DEFAULT '0'
)
COLLATE='utf8_general_ci'
;

create SEQUENCE board_seq;

insert into mybatisBoard(title, writer, content, regdate, readcount) 
	values( 'title', 'writer', 'contents', CURDATE(), 0);


---------------- Oracle -----------------------------------------
select * from mybatisBoard;

create table mybatisBoard (
    seq number,
    title VARCHAR2(50),
    writer VARCHAR2(30),
    content VARCHAR2(200),
    regdate date,
    readcount number
);

create SEQUENCE board_seq;

insert into mybatisBoard values(board_seq.nextval, 'title', 'writer', 'contents', sysdate, 0);