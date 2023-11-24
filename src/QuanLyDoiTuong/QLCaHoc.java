//package QuanLyDoiTuong;
//
//import ThoiGian.CaHoc;
//import ThoiGian.Thu;
//import Utils.DocGhiFile;
//
//import java.util.ArrayList;
//
//
//public class QLCaHoc {
//    private static ArrayList<CaHoc> dsCaHoc = new ArrayList<>();
//
//    public static ArrayList<CaHoc> getDsCaHoc() {
//        return dsCaHoc;
//    }
//
//    public static void setDsCaHoc(ArrayList<CaHoc> dsCaHoc) {
//        QLCaHoc.dsCaHoc = dsCaHoc;
//    }
//
//    public static void inDanhSach(ArrayList<CaHoc> dsCaHoc){
//        System.out.println("*".repeat(62));
//        System.out.printf("* %-15s* %-20s* %-20s*\n", "Thu", "Giờ bắt đầu", "Giờ kết thúc");
//        System.out.println("*".repeat(62));
//        for (CaHoc caHoc: dsCaHoc) {
//            System.out.printf(
//            		"* %-15s* %-20s* %-20s*\n",
//            		caHoc.getThu(),
//            		caHoc.getGioVaoHoc(),
//            		caHoc.getGioTanHoc()
//            );
//        }
//        System.out.println("*".repeat(62));
//    }
//
//    public static void xuLyDuLieu(ArrayList<String> duLieu) {
//		// duyệt qua duLieu và bắt đầu xử lý!
//		for (var tam : duLieu) {
//			// tách chuỗi tam
//			String[] cacThuocTinh = tam.split("#");
//
//			// thiết lập các thuộc tính cho đối tượng
//			Thu thu = null;
//			switch (cacThuocTinh[0]) {
//			case "Hai": thu = Thu.Hai; break;
//			case "Ba": thu = Thu.Ba; break;
//			case "Tu": thu = Thu.Tu; break;
//			case "Nam": thu = Thu.Nam; break;
//			case "Sau": thu = Thu.Sau; break;
//			case "Bay": thu = Thu.Bay; break;
//			case "ChuNhat": thu = Thu.ChuNhat; break;
//			}
//			String[] gioVaoHoc = cacThuocTinh[1].split("[hp]");
//			String[] gioTanHoc = cacThuocTinh[2].split("[hp]");
//
//			// tạo ra dối tượng và thêm vào dsCaHoc
//			dsCaHoc.add(
//					new CaHoc(
//							thu,
//							new Gio(Integer.valueOf(gioVaoHoc[0]), Integer.valueOf(gioVaoHoc[1])),
//							new Gio(Integer.valueOf(gioTanHoc[0]), Integer.valueOf(gioTanHoc[1]))
//					)
//			);
//		}
//	}
//
//	// Hàm load dữ liệu từ file
//	public static void loadDuLieu() {
//		String filePath = "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlCaHoc.txt";
//		ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
//		xuLyDuLieu(duLieu);
//		System.out.println("Đã tải xong CA HỌC");
//	}
//
//    public static ArrayList<CaHoc> timCaHocTheoThu(Thu thu){
//        ArrayList<CaHoc> result = new ArrayList<>();
//        for(CaHoc caHoc: QLCaHoc.getDsCaHoc()){
//            if (caHoc.getThu().equals(thu)){
//                result.add(caHoc);
//            }
//        }
//        return result;
//    }
//
//}
