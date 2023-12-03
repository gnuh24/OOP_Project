package QuanLyDoiTuong;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.CoSo;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import HeThongGiaoDuc.DangKy.BienLai;
import HeThongGiaoDuc.DangKy.YeuCauDangKy;
import HeThongGiaoDuc.LopHoc.KetQua;
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
            int soTienDaDong = Integer.parseInt(cacThuocTinh[2]);
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
        int[] tongDoanhThu = new int[18];
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

        System.out.println("Tong doanh thu: " + tongDoanhThu[0]);
        System.out.println("*".repeat(50));
        System.out.printf("%-20s %-20s\n","Chương trình", "Doanh thu");
        System.out.println("*".repeat(50));
        for (int i = 1; i < tongDoanhThu.length; i++) {
            System.out.printf("%-20s %-20s\n", "CTH"+i,tongDoanhThu[i]);
        }
        System.out.println("*".repeat(50));


    }

    public static void thongKeDoanhThuTheoThang() {
        int[] tongDoanhThu = new int[13];
        for (int i = 0; i < tongDoanhThu.length; i++) {
            tongDoanhThu[i] = 0;
        }
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getNgayThanhToan().getYear() == nam) {
                tongDoanhThu[0] += bienLai.getSoTienDaDong();
                tongDoanhThu[bienLai.getNgayThanhToan().getMonthValue()] += bienLai.getSoTienDaDong();
            }
        }

        System.out.println("Tổng doanh thu năm "+nam+": "+tongDoanhThu[0]);
        System.out.println("*".repeat(50));
        System.out.printf("%-20s %-20s\n","Tháng", "Doanh thu");
        System.out.println("*".repeat(50));
        for (int i = 1; i < tongDoanhThu.length; i++) {
            System.out.printf("%-20s %-20s\n", i,tongDoanhThu[i]);
        }
        System.out.println("*".repeat(50));
    }

    public static void thongKeDoanhThuTheoKhoa() {
        int tongDoanhThu = 0;
        System.out.printf("%-20s %-02s\n","Khóa","Doanh thu");
        System.out.println("*".repeat(40));
        for(KhoaKhaiGiang khoaKhaiGiang:QLKhoaKhaiGiang.getDsKhoaKhaiGiang()){
            for(BienLai bienLai:dsBienLai){
                if (bienLai.getYeuCauDangKy().getLopHoc().getKhoa().getMaKhoa().equals(khoaKhaiGiang.getMaKhoa())) {
                    tongDoanhThu+=bienLai.getSoTienDaDong();
                }
            }   
            System.out.printf("%-20s %-20s\n",khoaKhaiGiang.getMaKhoa(),tongDoanhThu);
            tongDoanhThu=0;
        }
        System.out.println("*".repeat(40));
    }

    public static void thongKeTheoNam() {
        QLBienLai.dsBienLai.sort(new Comparator<BienLai>() {
            @Override
            public int compare(BienLai o1, BienLai o2) {
                return o1.getNgayThanhToan().compareTo(o2.getNgayThanhToan());
            }

        });
        int tongDoanhThu = 0, nam = getDsBienLai().get(0).getNgayThanhToan().getYear();
        System.out.printf("%-20s %-02s\n","Năm","Doanh thu");
        System.out.println("*".repeat(40));
        for (BienLai bienLai : QLBienLai.dsBienLai) {
            if (bienLai.getNgayThanhToan().getYear() == nam) {
                tongDoanhThu += bienLai.getSoTienDaDong();
            } else {
                System.out.println();
                tongDoanhThu = 0;
                nam = bienLai.getNgayThanhToan().getYear();
            }
        }
        System.out.println("*".repeat(40));
    }

    public static int soTienConNo(YeuCauDangKy YCDK) {
        int tienNo = YCDK.getTongHocPhi();
        for (BienLai bienLai : QLBienLai.getDsBienLai()) {
            if (bienLai.getYeuCauDangKy().getMaDangKy().equals(YCDK.getMaDangKy())) {
                tienNo -= bienLai.getSoTienDaDong();
            }
        }
        return tienNo;
    }
}