package practice;

import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		

		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("이름?");
		String name = sc.next();
				
		System.out.println("나이?");
		int age = sc.nextInt();
		
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
		
		
		
		
	}

}
