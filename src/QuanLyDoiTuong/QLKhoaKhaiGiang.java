//package QuanLyDoiTuong;
//
//import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
//import Utils.DocGhiFile;
//
//import java.util.ArrayList;
//
///*
//*
//* ĐANG CHỜ KIỆT GỬI FILE TEST
//*
//* */
//
//public class QLKhoaKhaiGiang {
//	private static ArrayList<KhoaKhaiGiang> dsKhoaKhaiGiang = new ArrayList<>();
//
//
//	public static ArrayList<KhoaKhaiGiang> getDsKhoaKhaiGiang() {
//		return dsKhoaKhaiGiang;
//	}
//
//	public static void setDsKhoaKhaiGiang(ArrayList<KhoaKhaiGiang> dsKhoaKhaiGiang) {
//		QLKhoaKhaiGiang.dsKhoaKhaiGiang = dsKhoaKhaiGiang;
//	}
//
//	private static void inDanhSachKhoaKhaiGiang(ArrayList<KhoaKhaiGiang> DSKhoaKhaiGiang) {
//		System.out.println("************************************************************************");
//		System.out.printf("* %-8s* %-25s* %-15s* %-15s*\n",
//				"ID",
//				"Tên khóa khai giảng",
//				"Ngày bắt đầu",
//				"Ngày kết thúc");
//		System.out.println("************************************************************************");
//
//		for (KhoaKhaiGiang khoaKhaiGiang : DSKhoaKhaiGiang) {
//			String ngayBatDau = khoaKhaiGiang.getNgayBatDau().getNgay() + "/"
//					+ khoaKhaiGiang.getNgayBatDau().getThang() + "/"
//					+ khoaKhaiGiang.getNgayBatDau().getNam();
//
//			String ngayKetThuc = khoaKhaiGiang.getNgayKetThuc().getNgay() + "/"
//					+ khoaKhaiGiang.getNgayKetThuc().getThang() + "/"
//					+ khoaKhaiGiang.getNgayKetThuc().getNam();
//
//			System.out.printf("* %-8s* %-25s* %-15s* %-15s*\n",
//					khoaKhaiGiang.getMaKhoa(),
//					khoaKhaiGiang.getTenKhoa(),
//					ngayBatDau,
//					ngayKetThuc
//			);
//		}
//		System.out.println("************************************************************************");
//
//	}
//
//	// Hàm tìm kiếm khóa khai giảng theo mã khóa
//	public static KhoaKhaiGiang timKiemTheoMaKhoa(String maKhoa) {
//
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang){
//			if (khoaKhaiGiang.getMaKhoa().equals(maKhoa)) {// nếu tìm thấy khóa có mã khóa cần tìm
//				return khoaKhaiGiang; // thì trả về khóa khai giảng đó
//			}
//		}
//
//
//		// nếu không tìm thấy, trả về null
//		return null;
//	}
//
//	// Hàm tìm kiếm khóa khai giảng theo tên khóa
//	public static KhoaKhaiGiang timKiemTheoTenKhoa(String tenKhoa) {
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
//			if (khoaKhaiGiang.getTenKhoa().equals(tenKhoa)) // nếu tìm thấy khóa có tên khóa cần tìm
//				return khoaKhaiGiang; // thì trả về khóa khai giảng đó
//
//		// nếu không tìm thấy, trả về null
//		return null;
//	}
//
//
//	// Hàm tìm các Khóa khai giảng có ngày bắt đầu theo thời gian chỉ định
//	public static ArrayList<KhoaKhaiGiang> timKiemKhoaBatDauTheoThang(int thang, int nam) {
//		ArrayList<KhoaKhaiGiang> cacKhoaTimThay = new ArrayList<>();
//
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
//			if (thang == khoaKhaiGiang.getNgayBatDau().getThang()
//					&& nam == khoaKhaiGiang.getNgayBatDau().getNam())
//				cacKhoaTimThay.add(khoaKhaiGiang);
//
//		if (cacKhoaTimThay.isEmpty())
//			return null;
//
//		return cacKhoaTimThay;
//	}
//
//	// Hàm tìm các Khóa khai giảng có ngày bắt đầu theo thời gian chỉ định
//	public static ArrayList<KhoaKhaiGiang> timKiemKhoaBatDauTheoNam(int nam) {
//		ArrayList<KhoaKhaiGiang> cacKhoaTimThay = new ArrayList<>();
//
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
//			if (nam == khoaKhaiGiang.getNgayBatDau().getNam())
//				cacKhoaTimThay.add(khoaKhaiGiang);
//
//		if (cacKhoaTimThay.isEmpty())
//			return null;
//
//		return cacKhoaTimThay;
//	}
//
//	// Hàm tìm các Khóa khai giảng có ngày kết thúc theo thời gian chỉ định
//	public static ArrayList<KhoaKhaiGiang> timKiemKhoaKetThucTheoThang(int thang, int nam) {
//		ArrayList<KhoaKhaiGiang> cacKhoaTimThay = new ArrayList<>();
//
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
//			if (thang == khoaKhaiGiang.getNgayKetThuc().getThang()
//					&& nam == khoaKhaiGiang.getNgayKetThuc().getNam())
//				cacKhoaTimThay.add(khoaKhaiGiang);
//
//		if (cacKhoaTimThay.isEmpty())
//			return null;
//
//		return cacKhoaTimThay;
//	}
//
//	// Hàm tìm các Khóa khai giảng có ngày kết thúc theo thời gian chỉ định
//	public static ArrayList<KhoaKhaiGiang> timKiemKhoaKetThucTheoNam(int nam) {
//		ArrayList<KhoaKhaiGiang> cacKhoaTimThay = new ArrayList<>();
//
//		// Duyệt qua tất cả các khóa khai giảng
//		for (KhoaKhaiGiang khoaKhaiGiang : dsKhoaKhaiGiang)
//			if (nam == khoaKhaiGiang.getNgayKetThuc().getNam())
//				cacKhoaTimThay.add(khoaKhaiGiang);
//
//		if (cacKhoaTimThay.isEmpty())
//			return null;
//
//		return cacKhoaTimThay;
//	}
//
//	// Hàm đếm số lượng khóa học theo năm
//	public static int demSoKhoaCungNam(int nam) {
//		int dem = 0;
//		for (KhoaKhaiGiang khoaKhaiGiang: dsKhoaKhaiGiang) {
//			if (khoaKhaiGiang.getNgayBatDau().getNam() == nam) {
//				dem++;
//			}
//		}
//		return dem;
//	}
//
//	public static void xuLyDuLieu(ArrayList<String> duLieu) {
//		// duyệt qua duLieu và bắt đầu xử lý!
//		for (var tam : duLieu) {
//			// tách chuỗi tam
//			String[] cacThuocTinh = tam.split("#");
//
//			// thiết lập các thuộc tính cho đối tượng
//			String ma = cacThuocTinh[0];
//
//			int ngay1 = Integer.parseInt(cacThuocTinh[1]); // unboxed
//			int thang1 = Integer.parseInt(cacThuocTinh[2]); // unboxed
//			int nam1 = Integer.parseInt(cacThuocTinh[3]); // unboxed: Integer ngầm chuyển thành int một cách an toàn
//			NgayThang ngayBatDau = new NgayThang(ngay1, thang1, nam1);
//
//			int ngay2 = Integer.parseInt(cacThuocTinh[4]); // unboxed
//			int thang2 = Integer.parseInt(cacThuocTinh[5]); // unboxed
//			int nam2 = Integer.parseInt(cacThuocTinh[6]); // unboxed: Integer ngầm chuyển thành int một cách an toàn
//			NgayThang ngayKetThuc = new NgayThang(ngay2, thang2, nam2);
//
//
//			// tạo ra dối tượng và thêm vào dsGiangVien
//			dsKhoaKhaiGiang.add(new KhoaKhaiGiang(ma, ngayBatDau, ngayKetThuc));
//		}
//	}
//
//	public static ArrayList<String> trichXuatDuLieu() {
//		ArrayList<String> duLieu = new ArrayList<>();
//
//		for (var khoaKhaiGiang : dsKhoaKhaiGiang) {
//			String ngayBatDau = khoaKhaiGiang.getNgayBatDau()
//					.toString().replaceAll("/", "#");
//			String ngayKetThuc = khoaKhaiGiang.getNgayKetThuc()
//					.toString().replaceAll("/", "#");
//
//			String tam = khoaKhaiGiang.getMaKhoa() + "#"
//					+ khoaKhaiGiang.getTenKhoa() + "#"
//					+ ngayBatDau + "#"
//					+ ngayKetThuc;
//
//			duLieu.add(tam);
//		}
//
//		return duLieu;
//	}
//
//
//	// Hàm save dữ liệu vào file
//	public static void saveDuLieu() {
//		String filePath = "C:\\Users\\KIET\\jid\\do-an-oop\\bin\\QuanLyDoiTuong\\output.txt";
//		ArrayList<String> duLieu = trichXuatDuLieu();
//		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
//	}
//
//	// Hàm load dữ liệu từ file
//	public static void loadDuLieu() {
//		String filePath = "C:\\Users\\KIET\\jid\\do-an-oop\\bin\\QuanLyDoiTuong\\input.txt";
//		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
//		xuLyDuLieu(duLieu);
//	}
//
//}
