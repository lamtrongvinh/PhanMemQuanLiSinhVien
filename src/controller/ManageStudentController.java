package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Province;
import model.Student;
import view.ManageStudentView;

public class ManageStudentController implements ActionListener {
	private ManageStudentView manageStudentView;
	public ManageStudentController(ManageStudentView manageStudentView) {
		super();
		this.manageStudentView = manageStudentView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();

		
		if (actionCommand.equals("Thêm")) {
			this.manageStudentView.deleteForm();
			this.manageStudentView.manageStudentList_.setChoose_("Thêm");
		} else if (actionCommand.equals("Lưu")) {
			try {
				this.manageStudentView.insertStudentByButtonInsert();
//				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (actionCommand.equals("Sửa")) {
			this.manageStudentView.showStudentChoosed();
//			this.manageStudentView.updateStudent(student_);
		} else if (actionCommand.equals("Xóa")) {
			this.manageStudentView.deleteStudentOnTable();
		} else if (actionCommand.equals("Hủy")) {
			
			this.manageStudentView.deleteForm();
		} else if (actionCommand.equals("Tìm")) {
			
			this.manageStudentView.searchStudent();
		} else if (actionCommand.equals("Cancel")){
			this.manageStudentView.cancelSearchStudent();
		} else if (actionCommand.equals("About me")){
			JOptionPane.showMessageDialog(manageStudentView, "Phần Mềm Quản Lí Sinh Viên Được Thực Hiện Bởi LÂM TRỌNG VINH");
		} else if (actionCommand.equals("Exit")){
			this.manageStudentView.quitProgram();
		} else if (actionCommand.equals("Save")){
			this.manageStudentView.handleSaveFile();
		} else if (actionCommand.equals("Open")){
			this.manageStudentView.handleOpenFile();
		}
	}

}
