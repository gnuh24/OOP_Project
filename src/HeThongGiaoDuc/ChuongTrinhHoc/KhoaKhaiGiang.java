//package HeThongGiaoDuc.ChuongTrinhHoc;
//import QuanLyDoiTuong.QLKhoaKhaiGiang;
//
//
//public class KhoaKhaiGiang {
//	private String maKhoa;
//	private String tenKhoa;
//	private NgayThang ngayBatDau;
//	private NgayThang ngayKetThuc;
//
//
//	// Hàm tạo Khóa khai giảng có Tên khóa được sinh từ năm bắt đầu
//	public KhoaKhaiGiang(String maKhoa, NgayThang ngayBatDau, NgayThang ngayKetThuc) {
//		this.maKhoa = maKhoa;
//		this.ngayBatDau = ngayBatDau;
//		this.ngayKetThuc = ngayKetThuc;
//
//		// Sinh ra tenKhoa phụ thuộc vào năm của ngày bắt đầu khóa khai giảng
//		int namBatDau = ngayBatDau.getNam(); // lấy ra năm bắt đầu
//
//		int duoiTen =  QLKhoaKhaiGiang.demSoKhoaCungNam(namBatDau) + 1;
//		// thiết lập tên Khóa khai giảng
//		this.tenKhoa = namBatDau % 100 + "."
//				+ duoiTen;
//	}
//
//	public String getMaKhoa() {
//		return maKhoa;
//	}
//
//	public void setMaKhoa(String maKhoa) {
//		this.maKhoa = maKhoa;
//	}
//
//	public String getTenKhoa() {
//		return tenKhoa;
//	}
//
//	public void setTenKhoa(String tenKhoa) {
//		this.tenKhoa = tenKhoa;
//	}
//
//	public NgayThang getNgayBatDau() {
//		return ngayBatDau;
//	}
//
//	public void setNgayBatDau(NgayThang ngayBatDau) {
//		this.ngayBatDau = ngayBatDau;
//	}
//
//	public NgayThang getNgayKetThuc() {
//		return ngayKetThuc;
//	}
//
//	public void setNgayKetThuc(NgayThang ngayKetThuc) {
//		this.ngayKetThuc = ngayKetThuc;
//	}
//
//}