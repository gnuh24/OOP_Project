package QuanLyDoiTuong;

import NguoiDung.CaNhan;
import NguoiDung.GiangVien;
import NguoiDung.KhachHang;

import ThoiGian.NgayThang;
import Utils.DocGhiFile;

import java.util.ArrayList;

public class QLKhachHang extends CaNhan {
    private static ArrayList<KhachHang> dsKhachHang = new ArrayList<>();

    public static ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public static void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        QLKhachHang.dsKhachHang = dsKhachHang;
    }


	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (var tam : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = tam.split("#");
			String ma = cacThuocTinh[0];
			// thiết lập các thuộc tính cho đối tượng
			String ten = cacThuocTinh[1];
			String email = cacThuocTinh[2];
			boolean gioiTinh = (cacThuocTinh[3].equals("1"));
			String sdt = cacThuocTinh[4];
			int ngay = Integer.valueOf(cacThuocTinh[5]);
			int thang = Integer.valueOf(cacThuocTinh[6]);
			int nam = Integer.valueOf(cacThuocTinh[7]);
			var ngaySinh = new NgayThang(ngay, thang, nam);
			String diaChi = cacThuocTinh[8];

			// tạo ra dối tượng và thêm vào dsKhachHang
			dsKhachHang.add(new KhachHang(ten, email, gioiTinh, sdt, ngaySinh, diaChi));
		}
	}
	
	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();
		
		for (var khachHang : dsKhachHang) {
			boolean gt = khachHang.getGioiTinh();
			String gioiTinh = (gt == true) ? "1" : "0";

			String ngaySinh = khachHang.getNgaySinh()
					.toString().replaceAll("/", "#");
			
			String tam = khachHang.getMaKhachHang() + "#"
					+ khachHang.getHoTen() + "#"
					+ khachHang.getEmail() + "#"
					+ gioiTinh + "#"
					+ khachHang.getSoDienThoai() + "#"
					+ ngaySinh + "#" 
					+ khachHang.getDiaChi() + "\n";
			
			duLieu.add(tam);
		}
		
		return duLieu;
	}
	
	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlKhachHang.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
	}
	
	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlKhachHang.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
	}

	// Hàm in danh sách khách hàng
	public static void inDanhSach(ArrayList<KhachHang> dsKhachHang) {
		System.out.println("*".repeat(127));

		System.out.printf("%-10s* %-25s* %-25s* %-10s* %-15s* %-15s* %-30s*\n",
				"Mã khách hàng", "Ho ten", "Email", "G/tinh", "SDT", "Ngay sinh", "Dia chi");

		System.out.println("*".repeat(127));

		for (var khachHang : dsKhachHang) {
			String gioiTinh = (khachHang.getGioiTinh()) ? "Nam" : "Nu";

			System.out.printf("%-10s %-25s %-25s %-10s %-15s %-15s %-30s %-1s\n",
					"* " + khachHang.getMaKhachHang(),
					"* " + khachHang.getHoTen(),
					"* " + khachHang.getEmail(), 
					"* " + gioiTinh, 
					"* " + khachHang.getSoDienThoai(),
					"* " + khachHang.getNgaySinh(), 
					"* " + khachHang.getDiaChi(), 
					"*");
		}
		System.out.println("*".repeat(127));
	}

	public static KhachHang timKhachHangTheoMa(String maKH){
		for (KhachHang khachHang: QLKhachHang.getDsKhachHang()) {
			if (khachHang.getMaKhachHang().equals(maKH)){
				return khachHang;
			}
		}
		return null;
	}

	
	public static void main(String[] args) {
		loadDuLieu();
		inDanhSach(dsKhachHang);
		saveDuLieu();
	}
}
