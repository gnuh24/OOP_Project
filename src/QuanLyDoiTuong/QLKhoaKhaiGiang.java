package QuanLyDoiTuong;

import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import Utils.Convert;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class QLKhoaKhaiGiang {

	private static ArrayList<KhoaKhaiGiang> dsKhoaKhaiGiang = new ArrayList<>();

	public static ArrayList<KhoaKhaiGiang> getDsKhoaKhaiGiang() {
		return dsKhoaKhaiGiang;
	}

	public static void setDsKhoaKhaiGiang(ArrayList<KhoaKhaiGiang> dsKhoaKhaiGiang) {
		QLKhoaKhaiGiang.dsKhoaKhaiGiang = dsKhoaKhaiGiang;
	}

	public static void inDanhSachKhoaKhaiGiang(ArrayList<KhoaKhaiGiang> DSKhoaKhaiGiang) {
		System.out.println("***********************************************");
		System.out.printf("* %-10s* %-15s* %-15s*\n",
				"Mã khóa",
				"Ngày bắt đầu",
				"Ngày kết thúc");
		System.out.println("***********************************************");

		for (KhoaKhaiGiang khoaKhaiGiang : DSKhoaKhaiGiang) {

			System.out.printf("* %-10s* %-15s* %-15s*\n",
					khoaKhaiGiang.getMaKhoa(),
					Convert.dateToString(khoaKhaiGiang.getNgayBatDau()),
					Convert.dateToString(khoaKhaiGiang.getNgayKetThuc()));
		}
		System.out.println("***********************************************");

	}

	// Hàm tìm kiếm khóa khai giảng theo tên khóa
	public static KhoaKhaiGiang timKiemTheoMaKhoa(String maKhoa) {
		// Duyệt qua tất cả các khóa khai giảng
		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
			if (khoaKhaiGiang.getMaKhoa().equals(maKhoa)) // nếu tìm thấy khóa có tên khóa cần tìm
				return khoaKhaiGiang; // thì trả về khóa khai giảng đó

		// nếu không tìm thấy, trả về null
		return null;
	}

	// Hàm đếm số lượng khóa học theo năm
	public static int demSoKhoaCungNam(int nam) {
		int dem = 0;
		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang) {
			if (khoaKhaiGiang.getNgayBatDau().getYear() == nam) {
				dem++;
			}
		}
		return dem;
	}

	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (String temp : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = temp.split("#");

			// thiết lập các thuộc tính cho đối tượng
			String tenKhoa = cacThuocTinh[0];

			LocalDate ngayBatDau = Convert.stringToDate(cacThuocTinh[1]);

			LocalDate ngayKetThuc = Convert.stringToDate(cacThuocTinh[2]);

			dsKhoaKhaiGiang.add(new KhoaKhaiGiang(tenKhoa, ngayBatDau, ngayKetThuc));
		}
	}

	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (var khoaKhaiGiang : dsKhoaKhaiGiang) {

			String tam = khoaKhaiGiang.getMaKhoa() + "#"
					+ Convert.dateToString(khoaKhaiGiang.getNgayBatDau()) + "#"
					+ Convert.dateToString(khoaKhaiGiang.getNgayKetThuc()) + "\n";

			duLieu.add(tam);
		}

		return duLieu;
	}

	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		String filePath = "src\\Data\\qlKhoaKhaiGiang.txt";
		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
	}

	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "src\\Data\\qlKhoaKhaiGiang.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
	}


	public static void taoKhoaMoi(){
		LocalDate ngayBatDau = ScannerUtils.inputDate("Nhập ngày bắt đầu");
		while(ngayBatDau.isBefore(LocalDate.now())){
			System.err.println("Ngày bắt đầu của khóa mới không thể nằm trong quá khứ được !!");
			ngayBatDau = ScannerUtils.inputDate("Nhập ngày bắt đầu");
		}

		LocalDate ngayKetThuc = ScannerUtils.inputDate("Nhập ngày kết thúc");

		while(ngayKetThuc.isBefore(LocalDate.now()) || ngayKetThuc.isBefore(ngayBatDau)){
			if (ngayKetThuc.isBefore(LocalDate.now())){
				System.err.println("Ngày kết thúc của khóa mới không thể nằm trong quá khứ được !!");
			}else{
				System.err.println("Ngày kết thúc không thể nằm trước ngày bắt đầu !!");
			}
			ngayKetThuc = ScannerUtils.inputDate("Nhập ngày Kết thúc");
		}

		KhoaKhaiGiang khoaKhaiGiangMoi = new KhoaKhaiGiang(ngayBatDau, ngayKetThuc);
		QLKhoaKhaiGiang.getDsKhoaKhaiGiang().add(khoaKhaiGiangMoi);
		System.out.println("Đã thêm khóa");
	}

	public static ArrayList<KhoaKhaiGiang> timKiemKhoaChuaBatDau(){
		ArrayList<KhoaKhaiGiang> ketQua = new ArrayList<>();
		LocalDate ngayHienTai = LocalDate.now();
		for (KhoaKhaiGiang khoaKhaiGiang : QLKhoaKhaiGiang.getDsKhoaKhaiGiang()) {
			if( khoaKhaiGiang.getNgayBatDau().isAfter(ngayHienTai) ){
				ketQua.add(khoaKhaiGiang);
			}
		}
		return ketQua;
	}

	

}
