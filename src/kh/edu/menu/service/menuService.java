package kh.edu.menu.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import kh.edu.menu.vo.menuVO;

public class menuService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<menuVO> menuList = new LinkedList<menuVO>();
	
	public menuService() {
		menuList.add( new menuVO(1, "모짜렐라&가지샌드 위치", 9900, "Sandwich") );
		menuList.add(new menuVO(2, "라쟈냐", 25000, "Pasta"));
		menuList.add(new menuVO(3, "미트볼스파게티", 25000, "Pasta"));
		menuList.add(new menuVO(4, "팬케이크", 25000, "Brunch"));
		menuList.add(new menuVO(5, "아메리카노", 6000, "Drink"));
		menuList.add(new menuVO(6, "카푸치노", 6500, "Drink"));
		menuList.add(new menuVO(7, "오렌지에이드", 8500, "Drink"));
	}
		
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("\n===========메뉴판===========\n");
			System.out.println("1. 메뉴 추가 등록");
			System.out.println("2. 메뉴 전체 조회");
			System.out.println("3. 메뉴 정보 수정");
			System.out.println("4. 메뉴 정보 제거");
			//System.out.println("5. 이름으로 검색(일치)");
			System.out.println("5. 랜덤 메뉴 추천");
			
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n메뉴 번호 선택 >> ");
			
			try {
				
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : System.out.println(addMenu()); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println(updateMenu()); break;
				case 4 : System.out.println(removeMenu()); break;
				case 5 : random(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				
				}
				
			} catch(InputMismatchException e) {
				System.out.println("error : 입력 형식이 유효하지 않습니다. 다시 입력해주세요.");
				sc.nextLine();
				menuNum = -1; 

			}
			
		}while(menuNum != 0);
		
	}
	
	
	// 1. 메뉴 추가 등록
	
	public String addMenu() throws InputMismatchException{
		System.out.println("==============메뉴 추가==============");

		System.out.print("메뉴번호 : ");
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("메뉴이름 : ");
		String name = sc.next();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("메뉴타입 : ");
		String menuType = sc.nextLine();
		
		
		if(menuList.add( new menuVO(menuNum, name, price, menuType) ) ) {
			return "성공";
		}else {
			return "실패";
		}
		
	}
	
	
	// 2. 메뉴 전체 조회
	
	public void selectAll() {
				
		System.out.println("========메뉴 전체 조회========");
		
		if(menuList.isEmpty()) {
			System.out.println("메뉴 정보가 없습니다.");
			 
			return;
		}
		
		int index = 0;
		for( menuVO VO : menuList ) {
			System.out.print((index++)+ "번 : ");
			System.out.println(VO);
		}
		
	}
	
	// 3. 메뉴 정보 수정
	
	public String updateMenu() throws InputMismatchException{
		
		System.out.println("==========메뉴 정보 수정==========");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(menuList.isEmpty()) {
			return "입력된 메뉴 정보가 없습니다.";

		}else if(index < 0) {
			return "음수는 입력할 수 없습니다";
			
		}else if(index >= menuList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		
		}else {
			// 수정 코드 작성
			System.out.println(index + "번째 메뉴 정보");
			System.out.println(menuList.get(index));
			
			System.out.print("메뉴번호 : ");
			int menuNum = sc.nextInt();
			sc.nextLine();
			
			System.out.print("메뉴이름 : ");
			String name = sc.next();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("메뉴타입 : ");
			String menuType = sc.nextLine();
			
			menuVO temp = menuList.set(index, new menuVO(menuNum, name, price, menuType));
			
			return temp.getName() + "의 메뉴 정보가 변경되었습니다.";
		}
	}
	
	
	// 4. 메뉴 정보 제거
	
	public String removeMenu() throws InputMismatchException{
		
		System.out.println("==========학생 정보 제거==========");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(menuList.isEmpty()) {
			return "입력된 메뉴 정보가 없습니다.";

		}else if(index < 0) {
			return "음수는 입력할 수 없습니다";
			
		}else if(index >= menuList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		}else {
			
			System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch == 'Y') {
				menuVO temp = menuList.remove(index);
				return temp.getName() + "의 정보가 제거되었습니다."; 
			}else {
				return "취소";
			}
		}
	}
	
	
	// 5. 랜덤 메뉴 추천
	
	public void random() {
		int[] randomArr = new int[menuList.size()];
		for (int i = 0; i < menuList.size(); i++) {
			randomArr[i]= menuList.get(i).getMenuNum();
		}
		Random ran = new Random();
		int randomI = ran.nextInt(randomArr.length);
		int randomNum = randomArr[randomI];
		
		System.out.print("오늘의 추천 메뉴는 : ");
		System.out.println(menuList.get(randomNum));
		System.out.println();
	}
	
	
	
