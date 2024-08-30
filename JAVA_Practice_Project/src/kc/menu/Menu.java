package kc.menu;

import java.util.Scanner;

public class Menu {

	kc.studentcontroller.StudentController st = new kc.studentcontroller.StudentController();
	private static final String Y = null;
	private Scanner sc = new Scanner(System.in);
	private int failcount = 0;

	public void MainMenu() {

		while (true) {

			System.out.println("======== 학생 관리 프로그램 ========");
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 관리자 메뉴");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 선택 : ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				this.studentmenu();
				break;
			case 2:
				this.login();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다.");
				this.MainMenu();

			}
		}
	}

	public void studentmenu() {

		System.out.println("성적을 확인하겠습니까 ?(Y/N) : ");
		String choice = sc.next();
		if (choice.equals("Y") || choice.equals("y")) {
			System.out.println("학생 이름 : ");
			String name = sc.next();

			kc.student.Student student = st.searchStudent(name);
			if (student != null) {
				System.out.println("이름 : " + student.getName() + "  1시험 : " + student.getFirstScore() + "  2시험 : "
						+ student.getSecondScore() + "  3시험 : " + student.getFinalScore() + "  합계 : "
						+ student.getSumScore() + "  평균 : " + student.getAverage());
			} else {
				System.out.println("학생을 찾을 수 없습니다");
			}
		}

	}

	public void login() {

		while (failcount < 5) {
			System.out.println("관리자 번호를 입력하세요 : ");

			String num = sc.next();

			if (num.equals("0515") || num.equals("0301")) {
				this.adminmenu();
			} else {
				this.faillogin();
			}

		}
		System.out.println("5번 틀렸습니다. 프로그램을 종료합니다.");
		System.exit(0); // while 루프를 빠져나온 후 프로그램 종료
	}

	public void adminmenu() {
		kc.admin.Admin ad = new kc.admin.Admin(st);
		ad.adminMenu();

	}

	public void faillogin() {
		failcount++;
		System.out.println("잘못 입력하셨습니다.");
		System.out.println("현재 " + failcount + "번 틀리셨습니다.");
		System.out.println("5번 실패 시 프로그램을 종료합니다.");

		if (failcount >= 5) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0); // 5번 틀리면 즉시 프로그램 종료
		} else {
			System.out.println("다시 입력하시겠습니까 ? (Y/N) : ");
			String choice = sc.next();

			if (choice.equalsIgnoreCase("Y")) {
				// 여기서는 아무것도 하지 않으면 while 루프에서 login이 다시 시도됨
			} else {
				System.out.println("메인 메뉴로 돌아갑니다.");
				this.MainMenu();
				return;
			}
		}
	}
}
