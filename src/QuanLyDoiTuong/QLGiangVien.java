package QuanLyDoiTuong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import NguoiDung.GiangVien;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

public class QLGiangVien {
	private static ArrayList<GiangVien> dsGiangVien = new ArrayList<>();

	public static ArrayList<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public static void setDsGiangVien(ArrayList<GiangVien> dsGiangVien) {
		QLGiangVien.dsGiangVien = dsGiangVien;
	}

	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (var tam : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = tam.split("#");

			// thiết lập các thuộc tính cho đối tượng
			String ten = cacThuocTinh[0];
			String email = cacThuocTinh[1];
			Boolean gioiTinh = (cacThuocTinh[2].equals("1"));
			String sdt = cacThuocTinh[3];
			int ngay = Integer.valueOf(cacThuocTinh[4]); // unboxed
			int thang = Integer.valueOf(cacThuocTinh[5]); // unboxed
			int nam = Integer.valueOf(cacThuocTinh[6]); // unboxed: Integer ngầm chuyển thành int một cách an toàn
			NgayThang ngaySinh = new NgayThang(ngay, thang, nam);
			String diaChi = cacThuocTinh[7];
			String ma = cacThuocTinh[8];
			Boolean trangThai = (cacThuocTinh[9].equals("1"));

			// tạo ra dối tượng và thêm vào dsGiangVien
			dsGiangVien.add(new GiangVien(ten, email, gioiTinh, sdt, ngaySinh, diaChi, ma, trangThai));
		}
	}

	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (var giangVien : dsGiangVien) {
			boolean gt = giangVien.getGioiTinh();
			String gioiTinh = (gt) ? "1" : "0";

			boolean tt = giangVien.getTrangThai();
			String trangThai = (tt) ? "1" : "0";

			String ngaySinh = giangVien.getNgaySinh()
					.toString().replaceAll("/", "#");

			String tam = giangVien.getHoTen() + "#"
					+ giangVien.getEmail() + "#"
					+ gioiTinh + "#"
					+ giangVien.getSoDienThoai() + "#"
					+ ngaySinh + "#"
					+ giangVien.getDiaChi() + "#"
					+ giangVien.getMa() + "#"
					+ trangThai;

			duLieu.add(tam);
		}

		return duLieu;
	}

	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlGiangVien.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
	}

	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlGiangVien.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
	}



	// Hàm in thông tin giảng viên
	public static void inThongTinGiangVien(ArrayList<GiangVien> dsGiangVien) {
		System.out.println("*".repeat(148));

		System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* Ho ten", "* Email", "* G/tinh",
				"* SDT", "* Ngay sinh", "* Dia chi", "* Ma", "* Trang thai");

		System.out.println("*".repeat(148));

		for (var giangVien : dsGiangVien) {
			String gioiTinh = (giangVien.getGioiTinh()) ? "Nam" : "Nu";
			String trangThai = (giangVien.getTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

			System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* " + giangVien.getHoTen(),
					"* " + giangVien.getEmail(), "* " + gioiTinh, "* " + giangVien.getSoDienThoai(),
					"* " + giangVien.getNgaySinh(), "* " + giangVien.getDiaChi(), "* " + giangVien.getMa(),
					"* " + trangThai);
		}
		System.out.println("*".repeat(148));
	}

	public static ArrayList<GiangVien> timKiemGiangVienTheoTen(String ten) {
		ArrayList<GiangVien> ketQua = new ArrayList<>();
		for (GiangVien giangVien : dsGiangVien) {
			if (giangVien.getHoTen().equals(ten)) {
				ketQua.add(giangVien);
			}
		}

		return ketQua;
	}

	public static GiangVien timKiemGiangVienTheoMa(String ma) {
		for (GiangVien giangVien : dsGiangVien) {
			if (giangVien.getMa().equals(ma)) {
				return giangVien;
			}
		}

		return null;
	}

	public static GiangVien timKiemGiangVienTheoEmail(String email) {
		for (GiangVien giangVien : dsGiangVien) {
			if (giangVien.getEmail().equals(email)) {
				return giangVien;
			}
		}

		return null;
	}

	public static GiangVien timKiemGiangVienTheoSDT(String sdt) {
		for (GiangVien giangVien : dsGiangVien) {
			if (giangVien.getSoDienThoai().equals(sdt)) {
				return giangVien;
			}
		}

		return null;
	}

	public static ArrayList<GiangVien> timKiemGiangVienTheoTrangThai(boolean trangThai) {
		ArrayList<GiangVien> ketQua = new ArrayList<>();
		for (GiangVien giangVien : dsGiangVien) {
			if (giangVien.getTrangThai() == trangThai) {
				ketQua.add(giangVien);
			}
		}

		return ketQua;
	}

	public static void main(String[] args) {
		loadDuLieu();
		inThongTinGiangVien(QLGiangVien.getDsGiangVien());

	}
}