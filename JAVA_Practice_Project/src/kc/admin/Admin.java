package kc.admin;

import java.util.List;
import java.util.Scanner;

import kc.studentcontroller.StudentController;

public class Admin{
    
    private Scanner sc = new Scanner(System.in);
    private StudentController st;

	public Admin(StudentController st) {
		super();
		this.st = st;
	}

	public void adminMenu() {
    	
    	
        while (true) {

            System.out.println("======== 관리자 메뉴 ========");
            System.out.println("1. 학생부");
            System.out.println("2. 학생 성적입력");
            System.out.println("3. 학생 수정");
            System.out.println("4. 학생 검색");
            System.out.println("5. 메뉴로 돌아가기");
            System.out.println("9. 종료");
            System.out.println("메뉴 입력 : ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.printStudent();
                    break;
                case 2:
                    this.addStudent();
                    break;
                case 3:
                    this.updateStudent();
                    break;
                case 4:
                    this.searchStudent();
                    break;
                case 5: 
                	return;
                case 9:
                	System.out.println("프로그램을 종료합니다.");
    				System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public void addStudent() {
        System.out.println("======== 학생 성적입력 ========");
        System.out.println("학생 이름 : ");
        String name = sc.next();
        System.out.println("첫 번째 시험 점수 : ");
        int firstScore = sc.nextInt();
        System.out.println("두 번째 시험 점수 : ");
        int secondScore = sc.nextInt();
        System.out.println("마지막 시험 점수 : ");
        int finalScore = sc.nextInt();
        int sumScore = firstScore + secondScore + finalScore;
        int average = sumScore / 3;

        int result = st.addStudent(new kc.student.Student(name, firstScore, secondScore, finalScore, sumScore, average));

        if (result == 1) {
            System.out.println("학생 추가 성공");
        } else {
            System.out.println("학생 추가 실패");
        }
    }

    public void updateStudent() {
        System.out.println("======== 학생 수정 ========");
        System.out.println("수정할 학생 이름 : ");
        String name = sc.next();
        System.out.println("첫 번째 시험 점수 : ");
        int firstScore = sc.nextInt();
        System.out.println("두 번째 시험 점수 : ");
        int secondScore = sc.nextInt();
        System.out.println("마지막 시험 점수 : ");
        int finalScore = sc.nextInt();

        int result = st.updateStudent(name, firstScore, secondScore, finalScore);

        if (result == 1) {
            System.out.println("학생 정보 수정 성공");
        } else {
            System.out.println("학생 정보 수정 실패: 학생을 찾을 수 없습니다.");
        }
    }


    public void searchStudent() {
        System.out.println("======== 학생 검색 ========");
        System.out.println("검색할 학생 이름 : ");
        String name = sc.next();

        kc.student.Student student = st.searchStudent(name);
        if (student != null) {
            System.out.println("이름 : " + student.getName() + "  1시험 : " + student.getFirstScore()
                    + "  2시험 : " + student.getSecondScore() + "  3시험 : " + student.getFinalScore() + "  합계 : "
                    + student.getSumScore() + "  평균 : " + student.getAverage());
        } else {
            System.out.println("학생을 찾을 수 없습니다");
        }
    }


	public void printStudent() {
    System.out.println("======== 학생부 ========");
    List<kc.student.Student> list = st.All();
    for (kc.student.Student student : list) { 
        System.out.println("이름 : " + student.getName() + "  1시험 : " + student.getFirstScore()
                + "  2시험 : " + student.getSecondScore() + "  3시험 : " + student.getFinalScore() + "  합계 : "
                + student.getSumScore() + "  평균 : " + student.getAverage());
    	}
	}
}

