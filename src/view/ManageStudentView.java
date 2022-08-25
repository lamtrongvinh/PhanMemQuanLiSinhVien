package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.ManageStudentList;
import model.Province;
import model.Student;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ManageStudentController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ManageStudentView extends JFrame {

	public Province province;
	public Student student_;
	public ButtonGroup btn_groupSex;
	private JPanel contentPane;
	public ManageStudentList manageStudentList_;
	public JTextField textField_studentIDsearch;
	private JTable table;
	public JTextField textField_infoStudentID;
	public JTextField textField_infoStudentName;
	public JTextField textField_infoStudentBirth;
	public JTextField textField_infostudentPoint1;
	public JTextField textField_infoStudentPoint2;
	public JTextField textField_infoStudentPoint3;
	public JComboBox comboBox_province_1;
	private JRadioButton radioButton_Nam;
	private JRadioButton radioButton_Nu;
	private JTextField textField_searchName;
	private JComboBox comboBox_province;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentView frame = new ManageStudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageStudentView() {
		this.manageStudentList_ = new ManageStudentList();
		this.student_ = new Student();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 674);
		
		ActionListener actionListener = new ManageStudentController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Dialog", Font.BOLD, 16));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Dialog", Font.BOLD, 16));
		menuOpen.addActionListener(actionListener);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.setFont(new Font("Dialog", Font.BOLD, 16));
		menuSave.addActionListener(actionListener);
		menuFile.add(menuSave);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Dialog", Font.BOLD, 16));
		menuClose.addActionListener(actionListener);
		menuFile.add(menuClose);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Dialog", Font.BOLD, 16));
		menuExit.addActionListener(actionListener);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuAboutMe.addActionListener(actionListener);
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_province = new JLabel("Tỉnh");
		label_province.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_province.setBounds(30, 25, 59, 31);
		contentPane.add(label_province);
		
		JLabel label_studentID = new JLabel("Mã Sinh Viên");
		label_studentID.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_studentID.setBounds(220, 25, 134, 31);
		contentPane.add(label_studentID);
		
		textField_studentIDsearch = new JTextField();
		textField_studentIDsearch.setColumns(10);
		textField_studentIDsearch.setBounds(364, 25, 109, 29);
		contentPane.add(textField_studentIDsearch);
		
		JButton btn_search = new JButton("Tìm");
		btn_search.setBackground(Color.GRAY);
		btn_search.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_search.setBounds(654, 25, 95, 29);
		btn_search.addActionListener(actionListener);
		contentPane.add(btn_search);
		
		JButton btn_searchCancel = new JButton("Cancel");
		btn_searchCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_searchCancel.setBackground(Color.GRAY);
		btn_searchCancel.setBounds(759, 25, 95, 29);
		btn_searchCancel.addActionListener(actionListener);
		contentPane.add(btn_searchCancel);
		
		comboBox_province = new JComboBox();
		ArrayList<Province> listProvince_= province.getListProvince();
		comboBox_province.addItem("");
		for (Province province : listProvince_) {
			comboBox_province.addItem(province.getProvinceName());
		}
		comboBox_province.setBounds(86, 25, 103, 29);
		contentPane.add(comboBox_province);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 65, 866, 2);
		contentPane.add(separator_1);
		
		JLabel label_listStudent = new JLabel("Danh Sách Sinh Viên");
		label_listStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_listStudent.setBounds(30, 88, 275, 31);
		contentPane.add(label_listStudent);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 SV", "H\u1ECD T\u00EAn", "Ngày sinh", "Qu\u00EA Qu\u00E1n", "Gi\u1EDBi T\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(29, 133, 847, 160);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 303, 866, 2);
		contentPane.add(separator_1_1);
		
		JLabel label_infoStudent = new JLabel("Thông Tin Sinh Viên");
		label_infoStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_infoStudent.setBounds(30, 315, 259, 31);
		contentPane.add(label_infoStudent);
		
		textField_infoStudentID = new JTextField();
		textField_infoStudentID.setColumns(10);
		textField_infoStudentID.setBounds(159, 356, 172, 26);
		contentPane.add(textField_infoStudentID);
		
		JLabel label_infoStudentID = new JLabel("Mã Sinh Viên");
		label_infoStudentID.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_infoStudentID.setBounds(30, 356, 301, 31);
		contentPane.add(label_infoStudentID);
		
		JLabel label_infoStudentName = new JLabel("Họ và tên");
		label_infoStudentName.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_infoStudentName.setBounds(30, 392, 134, 31);
		contentPane.add(label_infoStudentName);
		
		textField_infoStudentName = new JTextField();
		textField_infoStudentName.setColumns(10);
		textField_infoStudentName.setBounds(159, 392, 172, 26);
		contentPane.add(textField_infoStudentName);
		
		textField_infoStudentBirth = new JTextField();
		textField_infoStudentBirth.setColumns(10);
		textField_infoStudentBirth.setBounds(159, 433, 172, 26);
		contentPane.add(textField_infoStudentBirth);
		
		JLabel label_infoStudentBirth = new JLabel("Ngày sinh");
		label_infoStudentBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_infoStudentBirth.setBounds(30, 433, 134, 31);
		contentPane.add(label_infoStudentBirth);
		
		JLabel label_infoStudentQueQuan = new JLabel("Quê quán");
		label_infoStudentQueQuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_infoStudentQueQuan.setBounds(30, 472, 134, 31);
		contentPane.add(label_infoStudentQueQuan);
		
		textField_infostudentPoint1 = new JTextField();
		textField_infostudentPoint1.setColumns(10);
		textField_infostudentPoint1.setBounds(582, 392, 172, 26);
		contentPane.add(textField_infostudentPoint1);
		
		JLabel label_studentIPoint1 = new JLabel("Điểm môn 1");
		label_studentIPoint1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_studentIPoint1.setBounds(453, 392, 134, 31);
		contentPane.add(label_studentIPoint1);
		
		textField_infoStudentPoint2 = new JTextField();
		textField_infoStudentPoint2.setColumns(10);
		textField_infoStudentPoint2.setBounds(582, 433, 172, 26);
		contentPane.add(textField_infoStudentPoint2);
		
		JLabel label_studentIPoint2 = new JLabel("Điểm môn 2");
		label_studentIPoint2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_studentIPoint2.setBounds(453, 433, 134, 31);
		contentPane.add(label_studentIPoint2);
		
		textField_infoStudentPoint3 = new JTextField();
		textField_infoStudentPoint3.setColumns(10);
		textField_infoStudentPoint3.setBounds(582, 474, 172, 26);
		contentPane.add(textField_infoStudentPoint3);
		
		JLabel label_studentIPoint3 = new JLabel("Điểm môn 3");
		label_studentIPoint3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_studentIPoint3.setBounds(453, 469, 134, 31);
		contentPane.add(label_studentIPoint3);
		
		comboBox_province_1 = new JComboBox();
		ArrayList<Province> listProvince_2= province.getListProvince();
		comboBox_province_1.addItem("");
		for (Province province : listProvince_2) {
			comboBox_province_1.addItem(province.getProvinceName());
		}
		comboBox_province_1.setBounds(156, 476, 175, 26);
		contentPane.add(comboBox_province_1);
		
		JLabel label_studentISex = new JLabel("Giới tính");
		label_studentISex.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_studentISex.setBounds(453, 351, 134, 31);
		contentPane.add(label_studentISex);
		
		radioButton_Nam = new JRadioButton("Nam");
		radioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_Nam.setBounds(582, 351, 59, 31);
		contentPane.add(radioButton_Nam);
		
		radioButton_Nu = new JRadioButton("Nữ");
		radioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radioButton_Nu.setBounds(695, 351, 59, 31);
		contentPane.add(radioButton_Nu);
		
		btn_groupSex = new ButtonGroup();
		btn_groupSex.add(radioButton_Nu);
		btn_groupSex.add(radioButton_Nam);
		
		JButton btn_insert = new JButton("Thêm");
		btn_insert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_insert.setBounds(30, 529, 126, 36);
		btn_insert.addActionListener(actionListener);
		contentPane.add(btn_insert);
		
		JButton btn_fix = new JButton("Sửa");
		btn_fix.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_fix.setBounds(185, 529, 126, 36);
		btn_fix.addActionListener(actionListener);
		contentPane.add(btn_fix);
		
		JButton btn_delete = new JButton("Xóa");
		btn_delete.addActionListener(actionListener);
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_delete.setBounds(359, 529, 126, 36);
		contentPane.add(btn_delete);
		
		JButton btn_save = new JButton("Lưu");
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_save.setBounds(530, 529, 126, 36);
		btn_save.addActionListener(actionListener);
		contentPane.add(btn_save);
		
		JButton btn_cancel = new JButton("Hủy");
		btn_cancel.addActionListener(actionListener);
		btn_cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_cancel.setBounds(707, 529, 126, 36);
		contentPane.add(btn_cancel);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 517, 866, 2);
		contentPane.add(separator_1_1_1);
		
		JLabel label_searchName = new JLabel("Tên");
		label_searchName.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_searchName.setBounds(496, 25, 59, 31);
		contentPane.add(label_searchName);
		
		textField_searchName = new JTextField();
		textField_searchName.setColumns(10);
		textField_searchName.setBounds(546, 25, 83, 29);
		contentPane.add(textField_searchName);
		
		
		
		this.setVisible(true);
	}

	public void deleteForm() {
		textField_infoStudentBirth.setText("");
		textField_infoStudentID.setText("");
		textField_infoStudentName.setText("");
		textField_infoStudentPoint2.setText("");
		textField_infostudentPoint1.setText("");
		textField_infoStudentPoint3.setText("");
		comboBox_province_1.setSelectedIndex(-1);
		btn_groupSex.clearSelection();
		
	}
	
	public void insertDataStudentToTable(Student student) {
		DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { student.getStudentID() + "", 
				student.getStudentName(),
				student.dateToString(),
				student.getHowmTownOfStudent().getProvinceName(), 
				(student.isSex_() ? "Nam" : "Nữ"), 
				student.getPointFistSubject() + "", 
				student.getPointSecondSubject() + "", 
				student.getPointThirdSubject() + ""});
	}
	
	public void insertStudentToTable(Student student) {
		DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
		if (!this.manageStudentList_.isExist(student)) {
			this.manageStudentList_.insertStudent(student);
			this.insertDataStudentToTable(student);
		} else {
			this.manageStudentList_.update(student);
			int numberLinesOfTable = model_table.getRowCount();
			for (int i = 0 ; i <= numberLinesOfTable - 1 ; i++) {
				String studentID = model_table.getValueAt(i, 0) + "";
				if (studentID.equals(student.getStudentID() + "")) {
					model_table.setValueAt(student.getStudentID() + "", i, 0);
					model_table.setValueAt(student.getStudentName() + "", i, 1);
					model_table.setValueAt(student.dateToString() + "", i, 2);
					model_table.setValueAt(student.getHowmTownOfStudent().getProvinceName() + "", i, 3);
					model_table.setValueAt((student.isSex_() ? "Nam" : "Nữ" ) , i, 4);
					model_table.setValueAt(student.getPointFistSubject() + "", i, 5);
					model_table.setValueAt(student.getPointSecondSubject() + "", i, 6);
					model_table.setValueAt(student.getPointThirdSubject() + "", i, 7);
					
				}
			}
		}
		
	}
	

	public void updateStudent(Student student) {
		
	}

	public void showStudentChoosed() {

		Student st = getStudentChoosing();
		
		this.textField_infoStudentName.setText(st.getStudentName());
		this.textField_infoStudentID.setText(st.getStudentID()+"");
		this.textField_infoStudentBirth.setText(st.dateToString() + "");
		this.textField_infostudentPoint1.setText(st.getPointFistSubject() + "");
		this.textField_infoStudentPoint2.setText(st.getPointSecondSubject() + "");
		this.textField_infoStudentPoint3.setText(st.getPointThirdSubject() + "");
		this.comboBox_province_1.setSelectedItem(st.getHowmTownOfStudent().getProvinceName());
		
		if (st.isSex_()) {
			this.radioButton_Nam.setSelected(true);
		} else {
			this.radioButton_Nu.setSelected(true);
		}
		
	}
	
	public Student getStudentChoosing() {
		DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
		int index_row = table.getSelectedRow();
		
		int studentID = Integer.valueOf(model_table.getValueAt(index_row, 0) + "");
		String studentName = model_table.getValueAt(index_row, 1) + "";
		Province provinceOfStudent_ = Province.getProvinceByName(model_table.getValueAt(index_row, 3) + "");
		String dateBirthString = model_table.getValueAt(index_row, 2) + "";
		Date dateBirth = new Date();
		try {
			dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirthString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		String chooseSex = model_table.getValueAt(index_row, 4) + "";
		
		boolean sex = chooseSex.equals("Nam");

		float pointFistSubject = Float.valueOf(model_table.getValueAt(index_row, 5) + "");
		float pointSecondSubject = Float.valueOf(model_table.getValueAt(index_row, 6) + "");
		float pointThirdSubject = Float.valueOf(model_table.getValueAt(index_row, 7) + "");
		
		Student st = new Student(studentName, studentID, dateBirth, provinceOfStudent_, sex, pointFistSubject, pointSecondSubject, pointThirdSubject);
		return st;
	}
	

	public void deleteStudentOnTable() {
		DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
		int rowSelected = table.getSelectedRow();
		int isConfirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ?");
		if (isConfirm == JOptionPane.YES_OPTION) {
			Student st = getStudentChoosing();
			this.manageStudentList_.deleteStudent(st);
			model_table.removeRow(rowSelected);
		}
	}

	public void insertStudentByButtonInsert() {

		int studentID = Integer.valueOf(this.textField_infoStudentID.getText());
		String studentName = this.textField_infoStudentName.getText();
		int provinceID = this.comboBox_province_1.getSelectedIndex();
		Province provinceOfStudent_ = Province.getProvinceByID(provinceID -1 );
		String dateBirthString = this.textField_infoStudentBirth.getText();
		
		Date dateBirth = new Date();
		try {
			dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirthString);
		} catch (ParseException e) {

			e.printStackTrace();
		}  
		
		String chooseSex = this.student_.getSexStudentText(this.btn_groupSex);
		
		boolean sex = true;
		if (chooseSex.equals("Nam")) {
			sex = true;
		} else if (chooseSex.equals("Nữ")) {
			sex = false;
		}

		float pointFistSubject = Float.valueOf(this.textField_infostudentPoint1.getText());
		float pointSecondSubject = Float.valueOf(this.textField_infoStudentPoint2.getText());
		float pointThirdSubject = Float.valueOf(this.textField_infoStudentPoint3.getText());
		
		Student student_ = new Student(studentName, studentID, dateBirth, provinceOfStudent_, sex, pointFistSubject, pointSecondSubject, pointThirdSubject);
		
		this.insertStudentToTable(student_);
	}

	public void searchStudent() {
		// TODO Auto-generated method stub
		//Gọi hàm hủy tìm trước
		this.cancelSearchStudent();

		//Search
		DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
		int numberLines = model_table.getRowCount();
		Set<Integer> linesDelete = new TreeSet<Integer>();
		String studentNameSearch = this.textField_searchName.getText();
		String studentIDsearch = this.textField_studentIDsearch.getText();
		int provinceIDchoosed = this.comboBox_province.getSelectedIndex() - 1;
		
		//Search by Province
		if (provinceIDchoosed >= 0 ) {
			Province provinceChoosed = Province.getProvinceByID(provinceIDchoosed);
			for (int i = 0 ; i < numberLines ; i++) {
				String provinceNameChoosed = model_table.getValueAt(i, 3) + "";
				String studentID = model_table.getValueAt(i, 0) + "";
//				System.out.println("provinceNameChoosed"+ provinceNameChoosed + " " + "provinceChoosed" + provinceChoosed.getProvinceName());
				if (!provinceNameChoosed.equals(provinceChoosed.getProvinceName())) {
					linesDelete.add(Integer.valueOf(studentID));
				}
			}
		}
		//Search By Name
		if (studentNameSearch.length() > 0) {
			for (int i = 0 ; i <= numberLines - 1; i++) {
				String studentNameOnTable = model_table.getValueAt(i, 1) + "";
				String studentID = model_table.getValueAt(i, 0) + "";
				if (studentNameOnTable.indexOf(studentNameSearch) < 0) {
					linesDelete.add(Integer.valueOf(studentID));
				}
			}
		}
		//Search By ID
		if (studentIDsearch.length() > 0) {
//			System.out.println("studentIDsearch : " + studentIDsearch);
			for (int i = 0; i < numberLines ; i++) {
				String studentIdOnTable = model_table.getValueAt(i, 0) + "";
				
				if (!studentIdOnTable.equals(studentIDsearch)) {
					
					linesDelete.add(Integer.valueOf(studentIdOnTable));
				}
			}
		}
		
		//Delete 
		for (Integer idDelete : linesDelete) {
			numberLines = model_table.getRowCount();
			for(int i = 0 ; i < numberLines; i++) {
				String IDStudentOnTable = model_table.getValueAt(i, 0) + "";
				if (IDStudentOnTable.equals(idDelete.toString())) {
					try {
						model_table.removeRow(i);
						
					} catch (Exception e) {					
						e.printStackTrace();
					}
					break;
				} 
				
			}
		}
		
	}

	public void cancelSearchStudent() {
		// TODO Auto-generated method stub
		while(true) {
			DefaultTableModel  model_table = (DefaultTableModel) table.getModel();
			int numberLines = model_table.getRowCount();
			if (numberLines == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		
		for (Student st : this.manageStudentList_.getListStudent_()) {
			
				this.insertDataStudentToTable(st);
		}
	}

	public void quitProgram() {
		int isConfirmQuit = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không ? ", "Thoát", JOptionPane.YES_NO_OPTION);
		if (isConfirmQuit == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	public void saveFile(String src) {
		
		try {
			this.manageStudentList_.setFileName(src);
			FileOutputStream fos = new FileOutputStream(src);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student st : this.manageStudentList_.getListStudent_()) {
				oos.writeObject(st);
			}
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void handleSaveFile() {
		JFileChooser fc = new JFileChooser();
		String fileName = this.manageStudentList_.getFileName();
		
		if (fileName.length() > 0) {
			saveFile(this.manageStudentList_.getFileName());
		} else {
			int returnValue = fc.showSaveDialog(this);
			
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
		
	}

	public void openFile(String src) {
		ArrayList<Student> listStudent = new ArrayList<Student>();
		try {
			this.manageStudentList_.setFileName(src);
			FileInputStream fis = new FileInputStream(src);
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			Student st = null;
			try {
				while((st = (Student) ois.readObject() ) != null) {
					listStudent.add(st);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ois.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.manageStudentList_.setListStudent_(listStudent);
	}

	public void handleOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnValue = fc.showOpenDialog(this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file.getAbsolutePath());
			cancelSearchStudent();
		}
		
	}
}
