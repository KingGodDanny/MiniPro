package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) throws IOException {

		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader bfr = new BufferedReader(fr);

		List<Person> pList = new ArrayList<Person>();

		Scanner sc = new Scanner(System.in);

		String line = "";
		while (true) {
			line = bfr.readLine();
			if (line == null) { // 문자는 null , 숫자는 -1로 끊는다.
				break;
			}

			// 짜르는 코드
			String[] pInfo = line.split(","); // new String[3]
			// pInfo는 주소고 따라가보면 String[]이 있다!!!!

			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];

			Person person = new Person(name, hp, company);

			pList.add(person);

		}

		System.out.println("***********************************");
		System.out.println("*        전화번호 관리 프로그램          *");
		System.out.println("***********************************");

		while (true) {
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

			} else if (menuNum == 1) {
				for (int i = 0; i < pList.size(); i++) {
					System.out.println(i+1 + ". " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  "
							+ pList.get(i).getCompany());
				}
				
			} else if (menuNum == 2) {
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
						
			} else if(menuNum == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int num = sc.nextInt();
				pList.remove(num-1);
				
			} else if(menuNum == 4) {
				System.out.println("<4. 검색>");
				System.out.print(">이름: ");
				String name = sc.next();
				for(int i=0; i<pList.size(); i++) {
					if(pList.get(i).getName().contains(name)) {
						System.out.println(i+1 + ". " + pList.get(i).getName() + "  " + pList.get(i).getHp() + "  "
								+ pList.get(i).getCompany());
					}
				}
			} else {
				System.out.println("[다시 입력해주세요]");
			}
			
			
		}
		
		Writer fw = new FileWriter("./PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < pList.size(); i++) {
			bw.write(pList.get(i).save()); // 받은 정보들을 메모장의 형식으로 리턴해야하니깐 .save
			bw.newLine();
			bw.flush();
		}
		
		
		bw.close();
		bfr.close();
		sc.close();
	}

}
