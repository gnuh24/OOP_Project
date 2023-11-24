package HeThongGiaoDuc.ChuongTrinhHoc;
import QuanLyDoiTuong.QLKhoaKhaiGiang;

import java.time.LocalDate;
import java.time.LocalTime;


public class KhoaKhaiGiang {
	private String maKhoa;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;

	public KhoaKhaiGiang() {
	}

	public KhoaKhaiGiang(String maKhoa, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		this.maKhoa = maKhoa;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	// Hàm tạo Khóa khai giảng có Tên khóa được sinh từ năm bắt đầu
	public KhoaKhaiGiang(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;

		// Sinh ra tenKhoa phụ thuộc vào năm của ngày bắt đầu khóa khai giảng
		int namBatDau = ngayBatDau.getYear(); // lấy ra năm bắt đầu

		int duoiTen =  QLKhoaKhaiGiang.demSoKhoaCungNam(namBatDau) + 1;
		// thiết lập tên Khóa khai giảng
		this.maKhoa = namBatDau % 100 + "."
				+ duoiTen;
	}

	public String getTenKhoa() {
		return maKhoa;
	}

	public void setTenKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

}