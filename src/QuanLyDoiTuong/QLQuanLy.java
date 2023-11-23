package QuanLyDoiTuong;

import java.util.ArrayList;

import NguoiDung.QuanLy;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

public class QLQuanLy {
	// static-propertiy
	private static ArrayList<QuanLy> dsQuanLy = new ArrayList<>();
	
	// static-getter
	public static ArrayList<QuanLy> getDsQuanLy() {
		return dsQuanLy;
	}

	// static-getter
	public static void setDsQuanLy(ArrayList<QuanLy> dsQuanLy) {
		QLQuanLy.dsQuanLy = dsQuanLy;
	}

	// Hàm in thông tin Quản lý
	public static void inDanhSach(ArrayList<QuanLy> dsQuanLy) {
		System.out.println("*".repeat(144));

		System.out.printf(
				"%-20s %-25s %-10s %-15s %-15s %-20s %-10s %-20s %-1s\n", 
				"* Ho ten", "* Email", "* G/tinh", "* SDT", "* Ngay sinh", 
				"* Dia chi", "* Ma", "* Trang thai", "*"
		);

		System.out.println("*".repeat(144));

		for (var quanLy : dsQuanLy) {
			String gioiTinh = (quanLy.getGioiTinh()) ? "nam" : "nu";
			String trangThai = (quanLy.getTrangThai()) ? "con day" : "mat day";

			System.out.printf(
					"%-20s %-25s %-10s %-15s %-15s %-20s %-10s %-20s %-1s\n", 
					"* " + quanLy.getHoTen(),
					"* " + quanLy.getEmail(), 
					"* " + gioiTinh, 
					"* " + quanLy.getSoDienThoai(),
					"* " + quanLy.getNgaySinh(), 
					"* " + quanLy.getDiaChi(), 
					"* " + quanLy.getMa(),
					"* " + trangThai, "*"
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
			dsQuanLy.add(
					new QuanLy(ten, email, gioiTinh, sdt, ngaySinh, diaChi, ma, trangThai)
			);
		}
	}

	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (var quanLy : dsQuanLy) {
			boolean gioiTinh = quanLy.getGioiTinh();
			boolean trangThai = quanLy.getTrangThai();
			String ngaySinh = quanLy.getNgaySinh().toString().replaceAll("/", "#");

			StringBuilder tam = new StringBuilder();
			tam.append(quanLy.getHoTen()).append("#")
					.append(quanLy.getEmail()).append("#")
					.append(gioiTinh ? "1" : "0").append("#")
					.append(quanLy.getSoDienThoai()).append("#")
					.append(ngaySinh).append("#")
					.append(quanLy.getDiaChi()).append("#")
					.append(quanLy.getMa()).append("#")
					.append(trangThai ? "1" : "0")
			.append(System.lineSeparator());

			duLieu.add(tam.toString());
		}

		return duLieu;
	}


	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlQuanLy.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong QUẢN LÝ");

	}

	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlQuanLy.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
		System.out.println("Đã lưu xong QUẢN LÝ");

	}

	// test
	public static void main(String[] args) {
		loadDuLieu();
		inDanhSach(dsQuanLy);
		saveDuLieu();
	}
}
