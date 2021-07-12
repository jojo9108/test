package test;

public class Student {
	private int studentNo;
	private String name;
	private int eScore;
	private int mScore;

	public Student(int studentNo, String name, int eScore, int mScore) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.eScore = eScore;
		this.mScore = mScore;
	}

	public Student() {
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int geteScore() {
		return eScore;
	}

	public void seteScore(int eScore) {
		this.eScore = eScore;
	}

	public int getmScore() {
		return mScore;
	}

	public void setmScore(int mScore) {
		this.mScore = mScore;
	}

	public String showInfo() {
		String info = "[ 학번: " + studentNo + "  학생이름: " + name + "  영어점수: " + eScore + "  수학점수: " + mScore + " ]";
		return info;
	}

	public void setDetail() {
		System.out.println("[ 학번: " + this.studentNo + "  학생이름: " + this.name + "  영어점수: " + this.eScore + "  수학점수: "
				+ this.mScore + " ]");
	}

	public String getDetail() {
		return "[ 학번: " + studentNo + "  학생이름: " + name + "  영어점수: " + eScore + "  수학점수: " + mScore + " ]";
	}

}
