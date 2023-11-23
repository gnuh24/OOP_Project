package QuanLyDoiTuong;

import java.util.ArrayList;

import NguoiDung.GiamDoc;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

public class QLGiamDoc {
	// static-propertiy
	private static ArrayList<GiamDoc> dsGiamDoc = new ArrayList<>();

	// static-getter
	public static ArrayList<GiamDoc> getDsQuanLy() {
		return dsGiamDoc;
	}

	// static-getter
	public static void setDsQuanLy(ArrayList<GiamDoc> dsQuanLy) {
		QLGiamDoc.dsGiamDoc = dsQuanLy;
	}

	// Hàm in danh sách Giám đốc
	public static void inDanhSach(ArrayList<GiamDoc> dsQuanLy) {
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
			dsGiamDoc.add(
					new GiamDoc(ten, email, gioiTinh, sdt, ngaySinh, diaChi, ma, trangThai)
			);
		}
	}

	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (var giamDoc : dsGiamDoc) {
			boolean gioiTinh = giamDoc.getGioiTinh();
			boolean trangThai = giamDoc.getTrangThai();
			String ngaySinh = giamDoc.getNgaySinh().toString().replaceAll("/", "#");

			StringBuilder tam = new StringBuilder();
			tam.append(giamDoc.getHoTen()).append("#")
					.append(giamDoc.getEmail()).append("#")
					.append(gioiTinh ? "1" : "0").append("#")
					.append(giamDoc.getSoDienThoai()).append("#")
					.append(ngaySinh).append("#")
					.append(giamDoc.getDiaChi()).append("#")
					.append(giamDoc.getMa()).append("#")
					.append(trangThai ? "1" : "0")
					.append(System.lineSeparator());


			duLieu.add(tam.toString());
		}

		return duLieu;
	}


	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlGiamDoc.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong GIÁM ĐỐC");

	}

	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlGiamDoc.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
		System.out.println("Đã lưu xong GIÁM ĐỐC");

	}

	// test
	public static void main(String[] args) {
		loadDuLieu();
		inDanhSach(dsGiamDoc);
		saveDuLieu();
	}
}
