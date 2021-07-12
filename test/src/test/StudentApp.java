package test;

import java.util.Scanner;

public class StudentApp {

	private static StudentApp singleton = new StudentApp();

	StudentApp() {
	}

	public static StudentApp getInstance() {
		return singleton;
	}

	static Scanner scn = new Scanner(System.in);
	static Student[] students = new Student[10];

	public void main() {
		while (true) {
			showMenu();
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				studentAdd();
			} else if (menu == 2) {
				studentEdit();
			} else if (menu == 3) {
				studentDelete();
			} else if (menu == 4) {
				studentList();
			} else if (menu == 5) {
				searchByName();
			} else if (menu == 6) {
				analysis();
			} else if (menu == 7) {
				break;
			}

		}
		System.out.println("프로그램을 종료합니다.");
	}

	public void studentAdd() {
		int studentNo = scanInt("학번 > ");
		String name = scanString("이름 > ");
		scn.nextLine();
		int eScore = scanInt("영어점수 > ");
		int mScore = scanInt("수학점수 > ");
		System.out.println("학생이 등록되었습니다.");

		Student student = new Student(studentNo, name, eScore, mScore);

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				break;
			}
		}

	}

	public void studentEdit() {
		int editNo = scanInt("수정하실 학번을 선택하세요.");
		scn.nextLine();
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentNo() == editNo) {
				int eScoreEdit = scanInt("영어점수 > ");
				int mScoreEdit = scanInt("수학점수 > ");
				if (eScoreEdit != 0) {
					students[i].seteScore(eScoreEdit);
					exist = true;
				}
				if (mScoreEdit != 0) {
					students[i].setmScore(mScoreEdit);
					exist = true;
				}
				if (exist) {
					System.out.println("수정되었습니다.");
				}

			}

		}
	}

	public void studentDelete() {
		int delNo = scanInt("삭제하실 학번을 입력하세요.");
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentNo() == delNo) {
				students[i] = null;
				System.out.println("1건 삭제되었습니다.");
				break;
			}
		}
	}

	public void studentList() {
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.println(students[i].showInfo());
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("회원정보가 없습니다.");
		}
	}

	public void searchByName() {
		String name = scanString("조회하실 이름을 입력하세요.");
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getName().equals(name)) {
				System.out.println(students[i].showInfo());
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("찾으시려는 학생은 조회되지 않습니다");
		}

	}

	public void analysis() {
		int maxValue = 0;
		Student maxStudent = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i].geteScore() > maxValue) {
				maxValue = students[i].geteScore();
				maxStudent = students[i];
			}
		}
		for (int j = 0; j < students.length; j++) {
			if (students[j].getmScore() > maxValue) {
				maxValue = students[j].getmScore();
				maxStudent = students[j];
			}
		}
		System.out.println("수학의 최고점수: " + maxStudent.geteScore() + "이름: " + maxStudent.getName());
		System.out.println("영어의 최고점수: " + maxStudent.getmScore() + "이름: " + maxStudent.getName());
	}

	public static String scanString(String arg) {
		System.out.println(arg);
		String val = scn.nextLine();
		return val;
	}

	public static int scanInt(String arg) {
		int val = 0;
		while (true) {
			try {
				System.out.println(arg);
				val = scn.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("숫자만 입력가능합니다.");
				scn.nextLine();
			}
		}
		return val;
	}

	public static void showMenu() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("1.입력 | 2.수정 | 3.삭제 | 4.학생리스트 | 5.단건(이름)조회 | 6.분석 | 7.종료");
		System.out.println("------------------------------------------------------------------");
		System.out.println("선택 > ");
	}
}
