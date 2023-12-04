package QuanLyDoiTuong;

import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.Convert;
import Utils.DocGhiFile;

import java.time.LocalTime;
import java.util.ArrayList;

public class QLCaHoc {
	// data
	private static ArrayList<CaHoc> dsCaHoc = new ArrayList<>();

	// getter
	public static ArrayList<CaHoc> getDsCaHoc() {
		return dsCaHoc;
	}

	// setter
	public static void setDsCaHoc(ArrayList<CaHoc> dsCaHoc) {
		QLCaHoc.dsCaHoc = dsCaHoc;
	}

	// Hàm để in ra danh sách các Ca Học
	public static void inDanhSach(ArrayList<CaHoc> dsCaHoc) {
		System.out.println("*".repeat(69));
		System.out.printf("* %-15s* %-15s* %-15s* %-15s*\n", "Số thử tự","Thu", "Giờ bắt đầu", "Giờ kết thúc");
		System.out.println("*".repeat(69));
		int index = 1;
		for (CaHoc caHoc : dsCaHoc) {
			System.out.printf(
					"* %-15d* %-15s* %-15s* %-15s*\n",
					index++,
					Thu.toString(caHoc.getThu()),
					Convert.timeToString(caHoc.getGioVaoHoc()),
					Convert.timeToString(caHoc.getGioTanHoc()));
		}
		System.out.println("*".repeat(69));
	}

	// xử lý dữ liệu từ chuỗi thành đối tượng
	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (var tam : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = tam.split("#");

			// thiết lập các thuộc tính cho đối tượng
			Thu thu = Thu.toThu(cacThuocTinh[0]);
			LocalTime gioVaoHoc = Convert.stringToTime(cacThuocTinh[1]);
			LocalTime gioTanHoc = Convert.stringToTime(cacThuocTinh[2]);

			dsCaHoc.add(new CaHoc(thu, gioVaoHoc, gioTanHoc));
		}
	}

	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		// Sửa đường dẫn này:
		String filePath = "src\\Data\\qlCaHoc.txt";

		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong CA HỌC");
	}

	// xử lý dữ liệu từ đối tượng thành chuỗi để lưu
	public static ArrayList<String> trichXuatDuLieu() {
		ArrayList<String> duLieu = new ArrayList<>();

		for (CaHoc caHoc : dsCaHoc) {
			StringBuilder sb = new StringBuilder();

			sb
					.append(Thu.toString(caHoc.getThu())).append("#")
					.append(Convert.timeToString(caHoc.getGioVaoHoc())).append("#")
					.append(Convert.timeToString(caHoc.getGioTanHoc()))
					.append(System.lineSeparator());

			duLieu.add(sb.toString());
		}

		return duLieu;
	}

	// Hàm save dữ liệu vào file
	public static void saveDuLieu() {
		// sửa đường dẫn này:
		String filePath = "src\\Data\\qlCaHoc.txt";

		ArrayList<String> duLieu = trichXuatDuLieu();
		DocGhiFile.ghiDuLieuFile(filePath, duLieu);
		System.out.println("Đã lưu xong CaHoc");
	}

	public static ArrayList<CaHoc> timCaHocTheoThu(Thu thu) {
		ArrayList<CaHoc> result = new ArrayList<>();
		for (CaHoc caHoc : QLCaHoc.getDsCaHoc()) {
			if (caHoc.getThu().equals(thu)) {
				result.add(caHoc);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		loadDuLieu();
		inDanhSach(QLCaHoc.getDsCaHoc());
		System.out.println("hi..... from a prince");
		saveDuLieu();
	}
}
