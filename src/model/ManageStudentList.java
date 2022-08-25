package model;

import java.util.ArrayList;

public class ManageStudentList {
	private ArrayList<Student> listStudent_;
	private String choose_;
	private String fileName;

	public ManageStudentList(ArrayList<Student> listStudent_) {
		this.listStudent_ = listStudent_;
		
	} 
	
	public ManageStudentList() {
		this.listStudent_ = new ArrayList<Student>();
		this.choose_ = "";
		this.fileName = "";
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	public String getChoose_() {
		return choose_;
	}

	public void setChoose_(String choose_) {
		this.choose_ = choose_;
	}

	public ArrayList<Student> getListStudent_() {
		return listStudent_;
	}

	public void setListStudent_(ArrayList<Student> listStudent_) {
		this.listStudent_ = listStudent_;
	}
	
	public void insertStudent(Student student_) {
		this.listStudent_.add(student_);
	}
	
	public void deleteStudent(Student student_) {
		this.listStudent_.remove(student_);
	}
	
	public void editInfoStudent(Student student) {
		
	}
	
	public void update(Student student) {
		this.listStudent_.remove(student);
		this.listStudent_.add(student);
	}

	public boolean isExist(Student student_) {
		for (Student student : listStudent_) {
			if ((int)student.getStudentID() == (int)student_.getStudentID()) {
				return true;
			}
		}
		return false;
	}
	
}
