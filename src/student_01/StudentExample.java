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
			case 1:// �Է�
				studentInput(stuArray);
				break;
			case 2:// ����
				studentUpdate(stuArray);
				break;
			case 3:// �˻�
				studentSerch(stuArray);
				break;
			case 4: // ����
				studentDelete(stuArray);
				break;
			case 5: // ���
				studintOutput(stuArray);
				break;
			case 6:// ����
				studentSort(stuArray);
				break;
			case 7:// ���(�ְ�����,��������)
				studentStats(stuArray);
				break;
			case 8:
				loopFlag = true;
				break;
			default:
				System.out.println("1~8�� �Է¿��");
				break;
			}
		}
		System.out.println("����");
	}

	// ���
	public static void studentStats(Student[] stuArray) {
		// �Է¹���Ŭ��
		sc.nextLine();
		System.out.print("�ְ�����:1, ��������:2 >>");
		int num = sc.nextInt();

		if (num < 1 || num > 2) {
			System.out.println("�ְ�����:1, ��������:2 �ȿ��� ���ÿ�û");

			return;
		}
		// �ְ�����
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
			System.out.println("�����ְ������������");
			System.out.println(stuArray[index].toString());
		} else {
			// ��������
			for (int i = 0; i < arrayCount; i++) {
				if (min > stuArray[i].getTotal()) {
					min = stuArray[i].getTotal();
					index = i;
				}
			}
			System.out.println("�������������������");
			System.out.println(stuArray[index].toString());
		}
	}

	// ����
	public static void studentSort(Student[] stuArray) {
		sc.nextLine();

		System.out.print("��������:1, ��������:2>>");
		int sort = sc.nextInt();

		if (sort < 1 || sort > 2) {
			System.out.println("��������:1, ��������:2 �ȿ��� �Է��ϼ���.");
			studentSort(stuArray);
			return;
		}
		// ����
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
			// ����
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

	// �˻�
	private static void studentSerch(Student[] stuArray) {
		sc.nextLine();
		System.out.print("�˻��� �л� ��ȣ>>");
		String no = sc.nextLine();
		int findIndex = -1;

		for (int i = 0; i < arrayCount; i++) {
			if (stuArray[i].getNo().equals(no)) {
				System.out.println("<<" + no + "�л�����>>");
				System.out.println(stuArray[i].toString());
				findIndex = i;
				break;
			}
		}

		if (findIndex == -1) {
			System.out.println(no + " ��ȣ�� ���� �л��Դϴ�.");
			return;
		}
	}

	// ����
	public static void studentUpdate(Student[] stuArray) {

		sc.nextLine();
		System.out.print("������ �л� ��ȣ>>");
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
			System.out.println(no + " ��ȣ�� ���� �л��Դϴ�.");
			return;
		}

		System.out.print("���� " + stuArray[findIndex].getKor() + ">>");
		int kor = sc.nextInt();
		stuArray[findIndex].setKor(kor);
		System.out.print("���� " + stuArray[findIndex].getEng() + ">>");
		int eng = sc.nextInt();
		stuArray[findIndex].setEng(eng);
		System.out.print("���� " + stuArray[findIndex].getMath() + ">>");
		int math = sc.nextInt();
		stuArray[findIndex].setMath(math);

		stuArray[findIndex].calTotal();
		stuArray[findIndex].calAvr();
		stuArray[findIndex].calGrade();

		System.out.println(stuArray[findIndex] + "\n�����Ϸ��߽��ϴ�.");
	}

	// ����
	public static void studentDelete(Student[] stu) {
		if (arrayCount == 0) {
			System.out.println("������ �л��� �����ϴ�.");
			return;
		}

		sc.nextLine();
		String no = null;
		try {
			System.out.println("������ �л���ȣ �Է� (��:010101)>>");
			no = sc.nextLine();

		} catch (Exception e) {
			System.out.println("�л���ȣ�Է� �����߻�");
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
			System.out.println("�׷��л������ϴ�.");
			return;
		}
		for (int i = findIndex; i < arrayCount; i++) {
			if (i == arrayCount - 1) {
				stu[i] = null;
			} else {
				stu[i] = stu[i + 1];
			}
		}
		System.out.println(deleteStudent.getNo() + deleteStudent.getName() + "�����Ǿ����ϴ�.");

		arrayCount--;

	}

	// ���
	public static void studintOutput(Student[] stuArray) {
		for (int i = 0; i < arrayCount; i++) {
			System.out.println(stuArray[i].toString());
		}
	}

	// �Է�
	public static void studentInput(Student[] stuArray) {
		if (arrayCount == STUDENT_SIZE) {
			System.out.println("�ο��ʰ�");
			return;
		}
		boolean flag = false;
		String no = null;

		// NO �ߺ��Է±����� ���� ó�����.
		while (!flag) {
			int level = (int) (Math.random() * (3 - 1 + 1) + (1));
			int whatClass = (int) (Math.random() * (9 - 1 + 1) + (1));
			int classNumber = (int) (Math.random() * (30 - 1 + 1) + (1));
			no = String.format("%02d%02d%02d", level, whatClass, classNumber);

			flag = true;

			// ��ó�� �Է��� ������ �߻�
			if (arrayCount == 0) {
				continue;
			}
			// ��ΰ�ü�迭�� ���ؼ� ���� ��ȣ�� �ִ��� ����
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
		System.out.println("�Է¼���");
		arrayCount += 1;
	}

	public static int displayMenu() {
		System.out.println("1.�Է�, 2.����, 3.�˻�, 4.����, 5.���, 6.����, 7.���, 8.���� \n�Է�>>");
		int num = sc.nextInt();
		return num;
	}

}
