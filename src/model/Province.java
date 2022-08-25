package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Province implements Serializable{
	private int provinceID;
	private String provinceName;
	public Province(int provinceID, String provinceName) {
		this.provinceID = provinceID;
		this.provinceName = provinceName;
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Province [provinceID=" + provinceID + ", provinceName=" + provinceName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(provinceID, provinceName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return provinceID == other.provinceID && Objects.equals(provinceName, other.provinceName);
	}
	
	public static ArrayList<Province> getListProvince() {
		String[] listProvince = { 
				"An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bạc Liêu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Dương",
				"Bình Định",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cao Bằng",
				"Cần Thơ",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Thành phố Hồ Chí Minh",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lạng Sơn",
				"Lào Cai",
				"Lâm Đồng",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái"
		};
		
		ArrayList<Province> list = new ArrayList<Province>();
		int i = 0;
		for (String province : listProvince) {
			Province province_ = new Province(i, province);
			list.add(province_);
			i++;
		}
		
		return list;
	}
	
	public static Province getProvinceByID(int provinceID) {
		return Province.getListProvince().get(provinceID);
	}
	public static Province getProvinceByName(String provinceName) {
		// TODO Auto-generated method stub
		ArrayList<Province> list = Province.getListProvince();
		for (Province province : list) {
			if (province.provinceName.equals(provinceName)) {
				return province;
			}
		}
		return null;
	}

}
