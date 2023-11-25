package QuanLyDoiTuong;

import Menu.LoadDuLieu;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.DocGhiFile;

import java.time.LocalTime;
import java.util.ArrayList;

public class QLCaHoc {
	public static void main(String[] args) {
		QLCaHoc.loadDuLieu();
		QLCaHoc.inDanhSach(QLCaHoc.getDsCaHoc());
	}
	private static ArrayList<CaHoc> dsCaHoc = new ArrayList<>();

	public static ArrayList<CaHoc> getDsCaHoc() {
		return dsCaHoc;
	}

	public static void setDsCaHoc(ArrayList<CaHoc> dsCaHoc) {
		QLCaHoc.dsCaHoc = dsCaHoc;
	}

	public static void inDanhSach(ArrayList<CaHoc> dsCaHoc) {
		System.out.println("*".repeat(47));
		System.out.printf("* %-10s* %-15s* %-15s*\n", "Thu", "Giờ bắt đầu", "Giờ kết thúc");
		System.out.println("*".repeat(47));
		for (CaHoc caHoc : dsCaHoc) {
			System.out.printf(
					"* %-10s* %-15s* %-15s*\n",
					caHoc.getThu(),
					caHoc.getGioVaoHoc(),
					caHoc.getGioTanHoc());
		}
		System.out.println("*".repeat(47));
	}

	public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (var tam : duLieu) {
			// tách chuỗi tam
			String[] cacThuocTinh = tam.split("#");

			// thiết lập các thuộc tính cho đối tượng
			Thu thu = Thu.toThu(cacThuocTinh[0]);

			String[] gioVaoHoc = cacThuocTinh[1].split("[hp]");
			String[] gioTanHoc = cacThuocTinh[2].split("[hp]");

			// tạo ra dối tượng và thêm vào dsCaHoc
			dsCaHoc.add(
					new CaHoc(
							thu,
							LocalTime.of(Integer.parseInt(gioVaoHoc[0]), Integer.parseInt(gioVaoHoc[1])),
							LocalTime.of(Integer.parseInt(gioTanHoc[0]), Integer.parseInt(gioTanHoc[1]))));
		}
	}

	// Hàm load dữ liệu từ file
	public static void loadDuLieu() {
		String filePath = "src\\Data\\qlCaHoc.txt";
		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
		xuLyDuLieu(duLieu);
		System.out.println("Đã tải xong CA HỌC");
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

}
