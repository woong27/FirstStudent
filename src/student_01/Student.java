package student_01;

public class Student {
	// 필드(학번,이름,성별,국어,영어,수학,평점,평균,등급,등수), 인멤상수(과목수)
	public static double SU = 3.0;
	private String no;
	private String name;
	private boolean gender;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avr;
	private String grade;
	private int rank;

	// 생성자(매생(학번,이름,성별,국어,영어,수학))
	public Student(String no, String name, boolean gender, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// 메소드(총점,평균,등급)
	public void calTotal() {
		this.total = this.kor + this.eng + this.math;
	}

	public void calAvr() {
		String data = String.format("%.2f", (double) this.total / SU);
		this.avr = Double.parseDouble(data);
	}

	public void calGrade() {
		if (this.avr >= 90) {
			this.grade = "A";
		} else if (this.avr >= 80) {
			this.grade = "B";
		} else if (this.avr >= 70) {
			this.grade = "C";
		} else if (this.avr >= 60) {
			this.grade = "D";
		} else {
			this.grade = "F";

		}
	}

	// 메소드(get,set)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public double getAvr() {
		return avr;
	}

	public void setAvr(double avr) {
		this.avr = avr;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// 메소드(plint)
	@Override
	public String toString() {
		char charValue = this.gender == true ? '남' : '여';
		System.out.println(
				"=============================================================================================================");
		return "학생번호 : " + no + "\t이름 : " + name + "\t성별 : " + charValue + "\n| 국어 : " + kor + "\t| 영어 : " + eng
				+ "\t| 수학 : " + math + "\t| 총점 : " + total + "\t| 평균 : " + avr + "\t| 등급 : " + grade + "\t| 등수 : "
				+ rank + "|";

	}

}
