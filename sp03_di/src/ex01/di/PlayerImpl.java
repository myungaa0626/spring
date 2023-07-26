package ex01.di;

import java.util.Scanner;

import lombok.Data;

@Data
public class PlayerImpl implements Player {

	private String name, position, sport;

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("선수 이름: ");	 	this.name = sc.next();
		System.out.println("포지션: "); 		this.position = sc.next();
		System.out.println("종목: "); 		this.sport = sc.next();

	}

	@Override
	public void info() {
		System.out.println("\n=-=-=-=-= 선수정보 =-=-=-=");
		System.out.println("선수 이름: " + this.name);
		System.out.println("포지션: " + this.position);
		System.out.println("종목: " + this.sport);
		System.out.println();

	}

}
