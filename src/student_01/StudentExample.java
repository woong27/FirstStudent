package student_01;

import java.util.Scanner;

public class StudentExample {
	public static Scanner sc = new Scanner(System.in);
	public static final int STUDENT_SIZE = 20;
	public static int arrayCount = 0;

	public static void main(String[] args) {

		Student[] stuArray = new Student[STUDENT_SIZE];
		boolean loopFlag = false;
		while (!loopFlag) {
			int num = displayMenu();
			switch (num) {
			case 1:// 입력
				studentInput(stuArray);
				break;
			case 2:// 수정
				studentUpdate(stuArray);
				break;
			case 3:// 검색
				studentSerch(stuArray);
				break;
			case 4: // 삭제
				studentDelete(stuArray);
				break;
			case 5: // 출력
				studintOutput(stuArray);
				break;
			case 6:// 정렬
				studentSort(stuArray);
				break;
			case 7:// 통계(최고점수,최저점수)
				studentStats(stuArray);
				break;
			case 8:
				loopFlag = true;
				break;
			default:
				System.out.println("1~8번 입력요망");
				break;
			}
		}
		System.out.println("종료");
	}

	// 통계
	public static void studentStats(Student[] stuArray) {
		// 입력버퍼클린
		sc.nextLine();
		System.out.print("최고점수:1, 최저점수:2 >>");
		int num = sc.nextInt();

		if (num < 1 || num > 2) {
			System.out.println("최고점수:1, 최저점수:2 안에서 선택요청");

			return;
		}
		// 최고점수
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int index = -1;
		if (num == 1) {
			for (int i = 0; i < arrayCount; i++) {
				if (max < stuArray[i].getTotal()) {
					max = stuArray[i].getTotal();
					index = i;
				}
			}
			System.out.println("가장최고점수정보출력");
			System.out.println(stuArray[index].toString());
		} else {
			// 최저점수
			for (int i = 0; i < arrayCount; i++) {
				if (min > stuArray[i].getTotal()) {
					min = stuArray[i].getTotal();
					index = i;
				}
			}
			System.out.println("가장최저점수정보출력");
			System.out.println(stuArray[index].toString());
		}
	}

	// 정렬
	public static void studentSort(Student[] stuArray) {
		sc.nextLine();

		System.out.print("오름차순:1, 내림차순:2>>");
		int sort = sc.nextInt();

		if (sort < 1 || sort > 2) {
			System.out.println("오름차순:1, 내림차순:2 안에서 입력하세요.");
			studentSort(stuArray);
			return;
		}
		// 오름
		if (sort == 1) {
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (stuArray[i].getTotal() < stuArray[j].getTotal()) {
						Student emptyStudent = stuArray[i];
						stuArray[i] = stuArray[j];
						stuArray[j] = emptyStudent;

					}
				}
				stuArray[i].setRank(i + 1);
			}
			// 내림
		} else {
			for (int i = 0; i < arrayCount; i++) {
				for (int j = i + 1; j < arrayCount; j++) {
					if (stuArray[i].getTotal() > stuArray[j].getTotal()) {
						Student emptyStudent = stuArray[i];
						stuArray[i] = stuArray[j];
						stuArray[j] = emptyStudent;

					}
				}
				stuArray[i].setRank(arrayCount - i);
			}
		}

	}

	// 검색
	private static void studentSerch(Student[] stuArray) {
		sc.nextLine();
		System.out.print("검색할 학생 번호>>");
		String no = sc.nextLine();
		int findIndex = -1;

		for (int i = 0; i < arrayCount; i++) {
			if (stuArray[i].getNo().equals(no)) {
				System.out.println("<<" + no + "학생정보>>");
				System.out.println(stuArray[i].toString());
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println(no + " 번호는 없는 학생입니다.");
			return;
		}
	}

	// 수정
	public static void studentUpdate(Student[] stuArray) {

		sc.nextLine();
		System.out.print("수정할 학생 번호>>");
		String no = sc.nextLine();
		int findIndex = -1;

		for (int i = 0; i < arrayCount; i++) {
			if (stuArray[i].getNo().equals(no)) {
				System.out.println(stuArray[i].toString());
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println(no + " 번호는 없는 학생입니다.");
			return;
		}

		System.out.print("국어 " + stuArray[findIndex].getKor() + ">>");
		int kor = sc.nextInt();
		stuArray[findIndex].setKor(kor);
		System.out.print("영어 " + stuArray[findIndex].getEng() + ">>");
		int eng = sc.nextInt();
		stuArray[findIndex].setEng(eng);
		System.out.print("수학 " + stuArray[findIndex].getMath() + ">>");
		int math = sc.nextInt();
		stuArray[findIndex].setMath(math);

		stuArray[findIndex].calTotal();
		stuArray[findIndex].calAvr();
		stuArray[findIndex].calGrade();

		System.out.println(stuArray[findIndex] + "\n수정완료했습니다.");
	}

	// 삭제
	public static void studentDelete(Student[] stu) {
		if (arrayCount == 0) {
			System.out.println("삭제할 학생이 없습니다.");
			return;
		}

		sc.nextLine();
		String no = null;
		try {
			System.out.println("삭제할 학생번호 입력 (예:010101)>>");
			no = sc.nextLine();

		} catch (Exception e) {
			System.out.println("학생번호입력 문제발생");
			return;
		}

		int findIndex = -1;
		Student deleteStudent = null;

		for (int i = 0; i < arrayCount; i++) {
			if (stu[i].getNo().equals(no)) {

				findIndex = i;
				deleteStudent = stu[i];
				stu[i] = null;
				break;
			}
		}
		if (findIndex == -1) {
			System.out.println("그런학생없습니다.");
			return;
		}
		for (int i = findIndex; i < arrayCount; i++) {
			if (i == arrayCount - 1) {
				stu[i] = null;
			} else {
				stu[i] = stu[i + 1];
			}
		}
		System.out.println(deleteStudent.getNo() + deleteStudent.getName() + "삭제되었습니다.");

		arrayCount--;

	}

	// 출력
	public static void studintOutput(Student[] stuArray) {
		for (int i = 0; i < arrayCount; i++) {
			System.out.println(stuArray[i].toString());
		}
	}

	// 입력
	public static void studentInput(Student[] stuArray) {
		if (arrayCount == STUDENT_SIZE) {
			System.out.println("인원초과");
			return;
		}
		boolean flag = false;
		String no = null;

		// NO 중복입력금지를 위한 처리기능.
		while (!flag) {
			int level = (int) (Math.random() * (3 - 1 + 1) + (1));
			int whatClass = (int) (Math.random() * (9 - 1 + 1) + (1));
			int classNumber = (int) (Math.random() * (30 - 1 + 1) + (1));
			no = String.format("%02d%02d%02d", level, whatClass, classNumber);

			flag = true;

			// 맨처음 입력을 했을때 발생
			if (arrayCount == 0) {
				continue;
			}
			// 모두객체배열을 통해서 같은 번호가 있는지 점검
			for (int i = 0; i < arrayCount; i++) {
				if (stuArray[i].getNo().equals(no)) {
					flag = false;
					break;

				}
			}
		}

		RandomValue rn = new RandomValue();
		String name = rn.randomName2();
		boolean gender = (int) (Math.random() * (1 - 0 + 1) + (0)) == 0 ? true : false;

		int kor = (int) (Math.random() * (100 - 0 + 1) + (0));
		int eng = (int) (Math.random() * (100 - 0 + 1) + (0));
		int math = (int) (Math.random() * (100 - 0 + 1) + (0));

		stuArray[arrayCount] = new Student(no, name, gender, kor, eng, math);
		stuArray[arrayCount].calTotal();
		stuArray[arrayCount].calAvr();
		stuArray[arrayCount].calGrade();
		System.out.println("입력성공");
		arrayCount += 1;
	}

	public static int displayMenu() {
		System.out.println("1.입력, 2.수정, 3.검색, 4.삭제, 5.출력, 6.정렬, 7.통계, 8.종료 \n입력>>");
		int num = sc.nextInt();
		return num;
	}

}
