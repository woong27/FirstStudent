package student_01;

public class RandomValue {

	public static String randomName1() {
		// �ѱ� 3�ڸ� ����Ѵ�.
		char[] name = new char[3];
		// �����ڵ� �ѱ۹������� (AC00~D7AF)
		for (int i = 0; i < name.length; i++) {
			name[i] = (char) (Math.random() * (0xD7AF - 0xAC00 + 1) + 0xAC00);
		}
		return new String(name);
	}

	public static String randomName2() {
		String[] firstName = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ȳ", "��", "��",
				"��", "��", "ȫ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ä", "��", "õ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ǥ", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ź", "��", "��", "��", "��", "��", "��", "��", "��" };
		String[] secondName = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "â", "ä", "õ", "ö", "��", "��", "��", "ġ", "Ž", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "ȣ", "ȫ", "ȭ", "ȯ", "ȸ", "ȿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ȥ", "Ȳ", "��", "��", "��", "��", "��", "��", "��", "Ź", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ÿ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��" };

		String name1 = firstName[(int) (Math.random() * (firstName.length))];
		String name2 = secondName[(int) (Math.random() * (firstName.length))];
		String name3 = secondName[(int) (Math.random() * (firstName.length))];
		return name1 + name2 + name3;
	}

	public static String randomId() {
		String[] id = { "A", "B", "C", "D", "E", "F", "a", "b", "c", "d", "f" };

		String createId1 = id[(int) (Math.random() * (id.length))];
		String createId2 = id[(int) (Math.random() * (id.length))];
		String createId3 = id[(int) (Math.random() * (id.length))];

		return createId1 + createId2 + createId3;
	}

	public static int randomNo() {
		int[] no = { 1, 2, 3, 4, 5 };

		int createNo = no[(int) (Math.random() * (no.length))];
		int createNo2 = no[(int) (Math.random() * (no.length))];
		int createNo3 = no[(int) (Math.random() * (no.length))];

		return createNo + createNo2 + createNo3;
	}

	public static int randomPoint() {

		int randomPoint = (int) (Math.random() * (120 - 80 + 1) + 80);

		return randomPoint;
	}
}
