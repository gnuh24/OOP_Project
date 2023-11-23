package QuanLyDoiTuong;

import java.util.ArrayList;

import NguoiDung.CongTacVien;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

/**
 * @author KIET
 * 23 thg 11, 2023
 */
public class QLCongTacVien {
	private static ArrayList<CongTacVien> dsCongTacVien = new ArrayList<>();
	
	
	public static ArrayList<CongTacVien> getDsCongTacVien() {
		return dsCongTacVien;
	}

	public static void setDsCongTacVien(ArrayList<CongTacVien> dsCongTacVien) {
		QLCongTacVien.dsCongTacVien = dsCongTacVien;
	}

	// Hàm in danh sách Cộng tác viên
	public static void inDanhSach(ArrayList<CongTacVien> dsCongTacVien) {
		System.out.println("*".repeat(144));

		System.out.printf(
				"%-20s %-25s %-10s %-15s %-15s %-20s %-10s %-20s %-1s\n", 
				"* Ho ten", "* Email", "* G/tinh", "* SDT", "* Ngay sinh", 
				"* Dia chi", "* Ma", "* Trang thai", "*"
		);

		System.out.println("*".repeat(144));

		for (var congTacVien : dsCongTacVien) {
			String gioiTinh = (congTacVien.getGioiTinh()) ? "nam" : "nu";
			String trangThai = (congTacVien.getTrangThai()) ? "con day" : "mat day";
			
			System.out.printf(
					"%-20s %-25s %-10s %-15s %-15s %-20s %-10s %-20s %-1s\n", 
					"* " + congTacVien.getHoTen(),
					"* " + congTacVien.getEmail(), 
					"* " + gioiTinh, 
					"* " + congTacVien.getSoDienThoai(),
					"* " + congTacVien.getNgaySinh(), 
					"* " + congTacVien.getDiaChi(), 
					"* " + congTacVien.getMa(),
					"* " + trangThai,
					"*"
			);
		}
		System.out.println("*".repeat(144));
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
			dsCongTacVien.add(
					new CongTacVien(ten, email, gioiTinh, sdt, ngaySinh, diaChi, ma, trangThai)
			);
		}
	}

	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (var congTacVien : dsCongTacVien) {
			boolean gioiTinh = congTacVien.getGioiTinh();
			boolean trangThai = congTacVien.getTrangThai();
			String ngaySinh = congTacVien.getNgaySinh().toString().replaceAll("/", "#");

			StringBuilder tam = new StringBuilder();
			tam.append(congTacVien.getHoTen()).append("#")
					.append(congTacVien.getEmail()).append("#")
					.append(gioiTinh ? "1" : "0").append("#")
					.append(congTacVien.getSoDienThoai()).append("#")
					.append(ngaySinh).append("#")
					.append(congTacVien.getDiaChi()).append("#")
					.append(congTacVien.getMa()).append("#")
					.append(trangThai ? "1" : "0")
					.append(System.lineSeparator());


			duLieu.add(tam.toString());
		}

		return duLieu;
	}


	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlCongTacVien.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong CỘNG TÁC VIÊN");

	}
	
	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlCongTacVien.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
		System.out.println("Đã lưu xong CỘNG TÁC VIÊN");

	}
	
	public static void main(String[] args) {
		loadDuLieu();
		inDanhSach(dsCongTacVien);
		saveDuLieu();
	}
}
