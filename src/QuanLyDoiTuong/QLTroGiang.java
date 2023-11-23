package QuanLyDoiTuong;

import java.util.ArrayList;

import NguoiDung.TroGiang;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

public class QLTroGiang {
	private static ArrayList<TroGiang> dsTroGiang = new ArrayList<>();


	public static ArrayList<TroGiang> getDsTroGiang() {
		return dsTroGiang;
	}

	public static void setDsTroGiang(ArrayList<TroGiang> dsTroGiang) {
		QLTroGiang.dsTroGiang = dsTroGiang;
	}

	public static void loadDuLieu() {
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlTroGiang.txt");
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong TRỢ GIẢNG");

	}
	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (var dong : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = dong.split("#");

			// thiết lập các thuộc tính cho đối tượng
			String ten = cacThuocTinh[0];
			String email = cacThuocTinh[1];
			Boolean gioiTinh = (cacThuocTinh[2].equals("1"));
			String sdt = cacThuocTinh[3];
			int ngay = Integer.parseInt(cacThuocTinh[4]); // unboxed
			int thang = Integer.parseInt(cacThuocTinh[5]); // unboxed
			int nam = Integer.parseInt(cacThuocTinh[6]); // unboxed: Integer ngầm chuyển thành int một cách an toàn
			NgayThang ngaySinh = new NgayThang(ngay, thang, nam);
			String diaChi = cacThuocTinh[7];
			String ma = cacThuocTinh[8];
			Boolean trangThai = (cacThuocTinh[9].equals("1"));
			// tạo ra dối tượng và thêm vào dsGiangVien
			dsTroGiang.add(new TroGiang(ten, email, gioiTinh, sdt, ngaySinh,diaChi, ma, trangThai));
		}
	}


	public static void luuDuLieu() {
		ArrayList<String> duLieu = xuLyDuLieuDeLuu();
		if(DocGhiFile.ghiDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlTroGiang.txt",duLieu)){
			System.out.println("Đã lưu xong TRỢ GIẢNG");
		}
	}

	public static ArrayList<String> xuLyDuLieuDeLuu() {
		// duyệt qua duLieu và bắt đầu xử lý!
		ArrayList<String> duLieu=new ArrayList<String>();
		for (TroGiang troGiang : dsTroGiang) {
			StringBuilder sb = new StringBuilder();
			sb.append(troGiang.getHoTen());sb.append("#");
			sb.append(troGiang.getEmail());sb.append("#");
			sb.append(troGiang.getGioiTinh());sb.append("#");
			sb.append(troGiang.getSoDienThoai());sb.append("#");

			sb.append(troGiang.getNgaySinh().getNgay());sb.append("#");
			sb.append(troGiang.getNgaySinh().getThang());sb.append("#");
			sb.append(troGiang.getNgaySinh().getNam());sb.append("#");


			sb.append(troGiang.getDiaChi());sb.append("#");
			sb.append(troGiang.getMa());sb.append("#");
			sb.append(troGiang.getTrangThai());
			sb.append(System.lineSeparator());
			duLieu.add(sb.toString());
		}
		return duLieu;
	}


	// Hàm in thông tin trợ giảng
	public static void inThongTinTroGiang(ArrayList<TroGiang> dsTroGiang) {
		System.out.println("*".repeat(148));

		System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* Ho ten", "* Email", "* G/tinh",
				"* SDT", "* Ngay sinh", "* Dia chi", "* Ma", "* Trang thai");

		System.out.println("*".repeat(148));

		for (var troGiang : dsTroGiang) {
			String gioiTinh = (troGiang.getGioiTinh()) ? "Nam" : "Nữ";
			String trangThai = (troGiang.getTrangThai()) ? "Hoạt động" : "Ngừng hoạt động";
			
			System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* " + troGiang.getHoTen(),
					"* " + troGiang.getEmail(), "* " + gioiTinh, "* " + troGiang.getSoDienThoai(),
					"* " + troGiang.getNgaySinh(), "* " + troGiang.getDiaChi(), "* " + troGiang.getMa(),
					"* " + trangThai);
		}
		System.out.println("*".repeat(148));
	}

	public static ArrayList<TroGiang> timKiemTroGiangTheoTen(String ten) {
		ArrayList<TroGiang> ketQua = new ArrayList<>();
		for (TroGiang troGiang : dsTroGiang) {
			if (troGiang.getHoTen().equals(ten)) {
				ketQua.add(troGiang);
			}
		}

		return ketQua;
	}

	public static TroGiang timKiemTroGiangTheoMa(String ma) {
		for (TroGiang troGiang : dsTroGiang) {
			if (troGiang.getMa().equals(ma)) {
				return troGiang;
			}
		}

		return null;
	}

	public static TroGiang timKiemGiangVienTheoEmail(String email) {
		for (TroGiang troGiang : dsTroGiang) {
			if (troGiang.getEmail().equals(email)) {
				return troGiang;
			}
		}

		return null;
	}

	public static TroGiang timKiemGiangVienTheoSDT(String sdt) {
		for (TroGiang troGiang : dsTroGiang) {
			if (troGiang.getSoDienThoai().equals(sdt)) {
				return troGiang;
			}
		}

		return null;
	}

	public static ArrayList<TroGiang> timKiemGiangVienTheoTrangThai(boolean trangThai) {
		ArrayList<TroGiang> ketQua = new ArrayList<>();
		for (TroGiang troGiang : dsTroGiang) {
			if (troGiang.getTrangThai() == trangThai) {
				ketQua.add(troGiang);
			}
		}

		return ketQua;
	}

	public static void main(String[] args) {
		QLTroGiang.loadDuLieu();
		inThongTinTroGiang(QLTroGiang.getDsTroGiang());
		System.out.println(QLTroGiang.timKiemTroGiangTheoMa("TG109").getHoTen());
	}

}
