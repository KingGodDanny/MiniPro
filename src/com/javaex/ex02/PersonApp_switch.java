package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.javaex.ex01.Person;

public class PersonApp_switch {

	public static void main(String[] args) throws IOException {

		Reader fr = new FileReader("./PhoneDB02.txt");
		BufferedReader bfr = new BufferedReader(fr);

		List<Person> pList = new ArrayList<Person>();

		Scanner sc = new Scanner(System.in);

		System.out.println("***********************************");
		System.out.println("*        전화번호 관리 프로그램          *");
		System.out.println("***********************************");

		String line = "";

		while (true) {

			line = bfr.readLine();
			
			if (line == null) {
				break;
			}

			String[] pInfo = line.split(",");

			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];

			Person person = new Person(name, hp, company);

			pList.add(person);
		}

			while(true) {
				
				System.out.println("");
				System.out.println("1.리스트	 2.등록	 3.삭제	 4.검색	 5.종료 ");
				System.out.println("----------------------------------------");
				System.out.print(">메뉴번호:");
				int menuNum = sc.nextInt();
				
				if (menuNum == 5) {
					System.out.println("***********************************");
					System.out.println("*        Thank you:)              *");
					System.out.println("***********************************");
					break;
				}
				
					switch (menuNum) {
					
					case 1:
						for (int i = 0; i < pList.size(); i++) {
							System.out.println(i + 1 + ". " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  "
									+ pList.get(i).getCompany());
						}
						break;
						
					case 2:
						System.out.println("<2. 등록>");
						
						System.out.print(">이름: ");
						String name1 = sc.next();
						
						System.out.print(">휴대전화: ");
						String hp1 = sc.next();
						
						System.out.print(">회사전화: ");
						String company1 = sc.next();
						System.out.println("[등록되었습니다.]");
						
						Person newP = new Person(name1, hp1, company1);
						pList.add(newP);
						
						break;
						
					case 3:
						System.out.println("<3.삭제>");
						System.out.print(">번호 : ");
						int num = sc.nextInt();
						pList.remove(num - 1);
						
						break;
						
					case 4:
						System.out.println("<4. 검색>");
						System.out.print(">이름: ");
						String searchN = sc.next();
						for (int i = 0; i < pList.size(); i++) {
							if (pList.get(i).getName().contains(searchN)) {
								System.out.println(i + 1 + ". " + pList.get(i).getName() + "  " + pList.get(i).getHp()
										+ "  " + pList.get(i).getCompany());
							}
						}
						
						break;
						
					default:
						System.out.println("[다시 입력해주세요]");
						break;
					}
				
			}
			

		

		sc.close();
		bfr.close();

	}

}
