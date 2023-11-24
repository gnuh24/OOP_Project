//package QuanLyDoiTuong;
//
//import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
//
//import java.util.ArrayList;
//
//public class QLHocVienLopHoc {
//    public static ArrayList<HocVienLopHoc> dsHocVienLophoc;
//
//    public static ArrayList<HocVienLopHoc> getDsHocVienLophoc() {
//        return dsHocVienLophoc;
//    }
//
//    public static void setDsHocVienLophoc(ArrayList<HocVienLopHoc> dsHocVienLophoc) {
//        QLHocVienLopHoc.dsHocVienLophoc = dsHocVienLophoc;
//    }
//
//
//    public static HocVienLopHoc timKienTheHocVien(String maHocVien) {
//        for(HocVienLopHoc hocVienLophoc:dsHocVienLophoc) {
//            if (hocVienLophoc.getHocVien().getMa().equals(maHocVien)) {
//                return hocVienLophoc;
//            }
//        }
//        return null;
//    }
//
//
//    public static ArrayList<HocVienLopHoc> timDSHocVienTheoLopHoc(String maLopHoc) {
//        ArrayList<HocVienLopHoc> dsHocVien = new ArrayList<>();
//        for(HocVienLopHoc hocVienLophoc:dsHocVienLophoc) {
//            if (hocVienLophoc.getLopHoc().getMaLop().equals(maLopHoc)) {
//                dsHocVien.add(hocVienLophoc);
//            }
//        }
//        return dsHocVien;
//    }
//
//
//    public static int demHocVienTheoLopHoc(String maLop) {
//        int dem=0;
//        for(HocVienLopHoc hocVienLophoc:dsHocVienLophoc) {
//            if (hocVienLophoc.getLopHoc().getMaLop().equals(maLop)) {
//               dem++;
//            }
//        }
//        return dem;
//    }
//}
