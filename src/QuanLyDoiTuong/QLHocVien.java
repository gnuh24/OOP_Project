package QuanLyDoiTuong;

import NguoiDung.HocVien;
import ThoiGian.NgayThang;
import Utils.DocGhiFile;

import java.util.ArrayList;


public class QLHocVien {

    public static ArrayList<HocVien> dsHocVien = new ArrayList<>();

    public static ArrayList<HocVien> getDsHocVien() {
        return dsHocVien;
    }

    public static void setDsHocVien(ArrayList<HocVien> dsHocVien) {
        QLHocVien.dsHocVien = dsHocVien;
    }

    public QLHocVien() {
        QLHocVien.dsHocVien = new ArrayList<HocVien>();
    }
    public QLHocVien(ArrayList<HocVien> dsHocVien) {
        QLHocVien.dsHocVien = dsHocVien;
    }

    public static HocVien timKiemHocVienTheoMa(String ma){
        for(HocVien hocVien:dsHocVien){
            if (hocVien.getMa().equals(ma)) {
                return hocVien;
            }
        }
        return null;
    }

    public static void inDSHocVien(ArrayList<HocVien> dsHocVien){
        System.out.println("*".repeat(148));

        System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* Ho ten", "* Email", "* G/tinh",
                "* SDT", "* Ngay sinh", "* Dia chi", "* Ma", "* Trang thai");

        System.out.println("*".repeat(148));

        for (var hocVien : QLHocVien.getDsHocVien()) {
            String gioiTinh = (hocVien.getGioiTinh()) ? "Nam" : "Nu";
            String trangThai = (hocVien.getTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

            System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* " + hocVien.getHoTen(),
                    "* " + hocVien.getEmail(), "* " + gioiTinh, "* " + hocVien.getSoDienThoai(),
                    "* " + hocVien.getNgaySinh(), "* " + hocVien.getDiaChi(), "* " + hocVien.getMa(),
                    "* " + trangThai);
        }
        System.out.println("*".repeat(148));

    }

    public static void loadDuLieu(){
        ArrayList<String> duLieu= DocGhiFile.docDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlHocVien.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong HỌC VIÊN");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
		// duyệt qua duLieu và bắt đầu xử lý!
		for (String dong : duLieu) {
			// tách chuỗi tam 
			String[] cacThuocTinh = dong.split("#");

            String hoTen = cacThuocTinh[0];
            String email = cacThuocTinh[1];
            boolean gioiTinh = Boolean.parseBoolean(cacThuocTinh[2]);
            String soDienThoai = cacThuocTinh[3];
            int ngay = Integer.parseInt(cacThuocTinh[4]);
            int thang = Integer.parseInt(cacThuocTinh[5]);
            int nam = Integer.parseInt(cacThuocTinh[5]);
            NgayThang ngaySinh = new NgayThang(ngay, thang, nam);
            String diaChi = cacThuocTinh[7];
            String ma = cacThuocTinh[8];
            boolean trangThai = Boolean.parseBoolean(cacThuocTinh[9]);

			dsHocVien.add(new HocVien(hoTen, email, gioiTinh, soDienThoai, ngaySinh, diaChi, ma, trangThai));
		}
	}

    public static void luuDuLieu() {
	    ArrayList<String> duLieu = xuLyDuLieuDeLuu();
	    if(DocGhiFile.ghiDuLieuFile("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\SGU OOP - Mr Khai\\ProjectQuanLyTrungTamTiengAnh\\src\\Data\\qlHocVien.txt",duLieu)){
            System.out.println("Đã lưu xong HỌC VIÊN");
        }
	}
    public static ArrayList<String> xuLyDuLieuDeLuu() {
		// duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu=new ArrayList<String>();
		for (HocVien hocVien : dsHocVien) {
            StringBuilder sb = new StringBuilder();
            sb.append(hocVien.getHoTen());sb.append("#");
            sb.append(hocVien.getEmail());sb.append("#");
            sb.append(hocVien.getGioiTinh());sb.append("#");
            sb.append(hocVien.getSoDienThoai());sb.append("#");
            sb.append(hocVien.getNgaySinh().getNgay());sb.append("#");
            sb.append(hocVien.getNgaySinh().getThang());sb.append("#");
            sb.append(hocVien.getNgaySinh().getNam());sb.append("#");
            sb.append(hocVien.getDiaChi());sb.append("#");
            sb.append(hocVien.getMa());sb.append("#");
            sb.append(hocVien.getTrangThai());sb.append(System.lineSeparator());
			duLieu.add(sb.toString());
		}
        return duLieu;
	}

    public static void main(String[] args) {
        new QLHocVien();
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // dsHocVien.add(new HocVien("Nguyen A", "NguyenA@gmail.com", false, "0999999999", new NgayThang(1,2,2000), "Sgu", "hv01", false));
        // luuDuLieu();

        loadDuLieu();
        inDSHocVien(QLHocVien.dsHocVien);
    }
}
