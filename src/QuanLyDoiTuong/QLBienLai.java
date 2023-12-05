package QuanLyDoiTuong;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

public class QLBienLai {
    public static ArrayList<BienLai> dsBienLai = new ArrayList<BienLai>();

    public static ArrayList<BienLai> getDsBienLai() {
        return dsBienLai;
    }

    public static void setDsBienLai(ArrayList<BienLai> dsBienLai) {
        QLBienLai.dsBienLai = dsBienLai;
    }

    public static void loadDuLieu() {
        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile("src\\Data\\qlBienLai.txt");
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong biên lai");

    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String dong : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = dong.split("#");

            String maBienLai = cacThuocTinh[0];
            String maDangKy = cacThuocTinh[1];
            double soTienDaDong = Double.parseDouble(cacThuocTinh[2]);
            String Date = cacThuocTinh[3];

            QLBienLai.dsBienLai.add(new BienLai(maBienLai, QLYeuCauDangKy.timKiemTheoMa(maDangKy), soTienDaDong,
                    LocalDateTime.parse(Date)));
        }
    }

    public static void luuDuLieu() {
        ArrayList<String> duLieu = xuLyDuLieuDeLuu();
        if (DocGhiFile.ghiDuLieuFile("src\\Data\\qlBienLai.txt", duLieu)) {
            System.out.println("Đã lưu xong Biên lai");

        }
    }

    public static ArrayList<String> xuLyDuLieuDeLuu() {
        // duyệt qua duLieu và bắt đầu xử lý!
        ArrayList<String> duLieu = new ArrayList<String>();
        for (BienLai bienLai : dsBienLai) {
            StringBuilder sb = new StringBuilder();
            sb.append(bienLai.getMaBienLai()).append("#")
                    .append(bienLai.getYeuCauDangKy().getMaDangKy()).append("#")
                    .append(bienLai.getSoTienDaDong()).append("#")
                    .append(bienLai.getNgayThanhToan()).append(System.lineSeparator());

            duLieu.add(sb.toString());
        }
        return duLieu;
    }

    public static ArrayList<BienLai> timKiemTheoNgay(LocalDateTime ngay) {
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getNgayThanhToan().equals(ngay)) {
                dsBienLais.add(bienLai);
            } else if ((bienLai.getNgayThanhToan().getYear() == ngay.getYear())
                    && bienLai.getNgayThanhToan().getMonthValue() == ngay.getMonthValue()
                    && bienLai.getNgayThanhToan().getDayOfMonth() == ngay.getDayOfMonth()) {
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }

    public static ArrayList<BienLai> timKiemTheoMaKhoa(String maKhoa) {
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getYeuCauDangKy().getLopHoc().getKhoa().getMaKhoa().equals(maKhoa)) {
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }

    public static ArrayList<BienLai> timKiemTheoChuongTrinh(String maChuongTrinh) {
        ArrayList<BienLai> dsBienLais = new ArrayList<BienLai>();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getYeuCauDangKy().getLopHoc().getChuongTrinh().getMaChuongTrinh().equals(maChuongTrinh)) {
                dsBienLais.add(bienLai);
            }
        }
        return dsBienLais;
    }

    public static BienLai timKiemTheoMaBienLai(String maBienLai) {
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getMaBienLai().equals(maBienLai))
                return bienLai;
        }
        System.out.println("Không tìm thấy mã biên lai");
        return null;
    }

    public static void thongKeDoanhThuTheoChuongTrinh() {
        double[] tongDoanhThu = new double[18];
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            tongDoanhThu[0] += bienLai.getSoTienDaDong();
            switch (bienLai.getYeuCauDangKy().getLopHoc().getChuongTrinh().getMaChuongTrinh()) {
                case "CTH001":
                    tongDoanhThu[1] += bienLai.getSoTienDaDong();
                    break;
                case "CTH002":
                    tongDoanhThu[2] += bienLai.getSoTienDaDong();
                    break;
                case "CTH003":
                    tongDoanhThu[3] += bienLai.getSoTienDaDong();
                    break;
                case "CTH004":
                    tongDoanhThu[4] += bienLai.getSoTienDaDong();
                    break;
                case "CTH005":
                    tongDoanhThu[5] += bienLai.getSoTienDaDong();
                    break;
                case "CTH006":
                    tongDoanhThu[6] += bienLai.getSoTienDaDong();
                    break;
                case "CTH007":
                    tongDoanhThu[7] += bienLai.getSoTienDaDong();
                    break;
                case "CTH008":
                    tongDoanhThu[8] += bienLai.getSoTienDaDong();
                    break;
                case "CTH009":
                    tongDoanhThu[9] += bienLai.getSoTienDaDong();
                    break;
                case "CTH010":
                    tongDoanhThu[10] += bienLai.getSoTienDaDong();
                    break;
                case "CTH011":
                    tongDoanhThu[11] += bienLai.getSoTienDaDong();
                    break;
                case "CTH012":
                    tongDoanhThu[12] += bienLai.getSoTienDaDong();
                    break;
                case "CTH013":
                    tongDoanhThu[13] += bienLai.getSoTienDaDong();
                    break;
                case "CTH014":
                    tongDoanhThu[14] += bienLai.getSoTienDaDong();
                    break;
                case "CTH015":
                    tongDoanhThu[15] += bienLai.getSoTienDaDong();
                    break;
                case "CTH016":
                    tongDoanhThu[16] += bienLai.getSoTienDaDong();
                    break;
                case "CTH017":
                    tongDoanhThu[17] += bienLai.getSoTienDaDong();
                    break;

            }
        }

        System.out.println("*".repeat(50));
        System.out.printf("*  %-20s*  %-23s*\n","Chương trình", "Doanh thu");
        System.out.println("*".repeat(50));
        for (int i = 1; i < tongDoanhThu.length; i++) {
            System.out.printf("*  %-20s*  %-23.2f*\n", "CTH"+i, tongDoanhThu[i]);
        }
        System.out.println("*".repeat(50));
        System.out.printf("*  Tong doanh thu: %-30.2f*\n", tongDoanhThu[0]);
        System.out.println("*".repeat(50));

    }
    public static void thongKeDoanhThuTheoKhoa() {
        double tongDoanhThu = 0;
        double tongDoanhThuTheoLichSu = 0;
        System.out.println("*".repeat(50));
        System.out.printf("*  %-20s*  %-23s*\n","Khóa", "Doanh thu");
        System.out.println("*".repeat(50));
        for(KhoaKhaiGiang khoaKhaiGiang:QLKhoaKhaiGiang.getDsKhoaKhaiGiang()){
            for(BienLai bienLai:dsBienLai){
                if (bienLai.getYeuCauDangKy().getLopHoc().getKhoa().getMaKhoa().equals(khoaKhaiGiang.getMaKhoa())) {
                    tongDoanhThu+=bienLai.getSoTienDaDong();
                }
            }
            System.out.printf("*  %-20s*  %-23.2f*\n", khoaKhaiGiang.getMaKhoa(), tongDoanhThu);
            tongDoanhThuTheoLichSu+= tongDoanhThu;
            tongDoanhThu=0;
        }
        System.out.println("*".repeat(50));
        System.out.printf("*  Tong doanh thu:        %-23.2f*\n", tongDoanhThuTheoLichSu);
        System.out.println("*".repeat(50));
    }

    public static void thongKeDoanhThuTheoThang() {
        double[] tongDoanhThu = new double[13];
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getNgayThanhToan().getYear() == nam) {
                tongDoanhThu[0] += bienLai.getSoTienDaDong();
                tongDoanhThu[bienLai.getNgayThanhToan().getMonthValue()] += bienLai.getSoTienDaDong();
            }
        }

        System.out.println("*".repeat(50));
        System.out.printf("*  %-20s*  %-23s*\n","Tháng", "Doanh thu");
        System.out.println("*".repeat(50));
        for (int i = 1; i < tongDoanhThu.length; i++) {
            System.out.printf("*  %-20s*  %-23.2f*\n", i, tongDoanhThu[i]);
        }
        System.out.println("*".repeat(50));
        System.out.printf("*  Tong doanh thu: %-30.2f*\n", tongDoanhThu[0]);
        System.out.println("*".repeat(50));
    }

    public static void thongKeTheoNam() {
        QLBienLai.dsBienLai.sort(Comparator.comparingInt(bienLai->bienLai.getNgayThanhToan().getYear()));
        double tongDoanhThu = 0;
        double tongDoanhThuTheoLichSu = 0;
        int nam = getDsBienLai().get(0).getNgayThanhToan().getYear();
        System.out.println("*".repeat(50));
        System.out.printf("*  %-20s*  %-23s*\n","Năm", "Doanh thu");
        System.out.println("*".repeat(50));
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getNgayThanhToan().getYear() == nam) {
                tongDoanhThu += bienLai.getSoTienDaDong();
            } else {
                System.out.printf("*  %-20s*  %-23.2f*\n", nam, tongDoanhThu);
                tongDoanhThuTheoLichSu+=tongDoanhThu;
                tongDoanhThu = 0;
                nam = bienLai.getNgayThanhToan().getYear();
            }
        }
        System.out.println("*".repeat(50));
        System.out.printf("*  Tong doanh thu: %-30.2f*\n", tongDoanhThuTheoLichSu);
        System.out.println("*".repeat(50));
    }

    public static double soTienConNo(YeuCauDangKy YCDK) {
        double tienNo = YCDK.getTongHocPhi();
        for (BienLai bienLai : QLBienLai.getDsBienLai()) {
            if (bienLai.getYeuCauDangKy().getMaDangKy().equals(YCDK.getMaDangKy())) {
                tienNo -= bienLai.getSoTienDaDong();
            }
        }
        return tienNo;
    }
}