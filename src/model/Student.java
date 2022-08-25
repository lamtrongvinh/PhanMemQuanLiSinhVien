package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Objects;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Student implements Serializable{
	private String studentName;
	private int studentID;
	private Province howmTownOfStudent;
	private boolean sex_;
	private float pointFistSubject, pointSecondSubject, pointThirdSubject;
	private Date studentBirth;
	
	public Date getStudentBirth() {
		return studentBirth;
	}

	public void setStudentBirth(Date studentBirth) {
		this.studentBirth = studentBirth;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public Province getHowmTownOfStudent() {
		return howmTownOfStudent;
	}

	public void setHowmTownOfStudent(Province howmTownOfStudent) {
		this.howmTownOfStudent = howmTownOfStudent;
	}

	public boolean isSex_() {
		return sex_;
	}

	public void setSex_(boolean sex_) {
		this.sex_ = sex_;
	}

	public float getPointFistSubject() {
		return pointFistSubject;
	}

	public void setPointFistSubject(float pointFistSubject) {
		this.pointFistSubject = pointFistSubject;
	}

	public float getPointSecondSubject() {
		return pointSecondSubject;
	}

	public void setPointSecondSubject(float pointSecondSubject) {
		this.pointSecondSubject = pointSecondSubject;
	}

	public float getPointThirdSubject() {
		return pointThirdSubject;
	}

	public void setPointThirdSubject(float pointThirdSubject) {
		this.pointThirdSubject = pointThirdSubject;
	}

	
	
	public Student() {
	}

	public Student(String studentName, int studentID,Date studentBirth, Province howmTownOfStudent, boolean sex_, float pointFistSubject,
			float pointSecondSubject, float pointThirdSubject) {
		this.studentName = studentName;
		this.studentID = studentID;
		this.studentBirth = studentBirth;
		this.howmTownOfStudent = howmTownOfStudent;
		this.sex_ = sex_;
		this.pointFistSubject = pointFistSubject;
		this.pointSecondSubject = pointSecondSubject;
		this.pointThirdSubject = pointThirdSubject;
	}

	

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentID=" + studentID + ", howmTownOfStudent="
				+ howmTownOfStudent + ", sex_=" + sex_ + ", pointFistSubject=" + pointFistSubject
				+ ", pointSecondSubject=" + pointSecondSubject + ", pointThirdSubject=" + pointThirdSubject
				+ ", studentBirth=" + studentBirth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(howmTownOfStudent, pointFistSubject, pointSecondSubject, pointThirdSubject, sex_,
				studentBirth, studentID, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(howmTownOfStudent, other.howmTownOfStudent)
				&& Float.floatToIntBits(pointFistSubject) == Float.floatToIntBits(other.pointFistSubject)
				&& Float.floatToIntBits(pointSecondSubject) == Float.floatToIntBits(other.pointSecondSubject)
				&& Float.floatToIntBits(pointThirdSubject) == Float.floatToIntBits(other.pointThirdSubject)
				&& sex_ == other.sex_ && Objects.equals(studentBirth, other.studentBirth)
				&& studentID == other.studentID && Objects.equals(studentName, other.studentName);
	}

	public String dateToString() {
		String date_= "";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		date_ = formatter.format(this.studentBirth);
		return date_;
	}
	
	public String getSexStudentText(ButtonGroup btnGroup) {
		for (Enumeration<AbstractButton> buttons = btnGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
		
		return "";
	}


	
}
