package NguoiDung;

import HeThongGiaoDuc.LopHoc.HocVienLopHoc;
import HeThongGiaoDuc.LopHoc.LopHoc;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import QuanLyDoiTuong.QLHocVienLopHoc;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLUser;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.ScannerUtils;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class User {

    private String maUser;
    private String hoTen;
    private String email;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private String diaChi;
    private VaiTro vaiTro;
    private boolean trangThai;

    public User(String maUser, String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai,
            String diaChi, VaiTro vaiTro, boolean trangThai) {
        this.maUser = maUser;
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
    }

    public User(String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai, String diaChi,
            VaiTro vaiTro) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;

        this.trangThai = true;
        autoIncrementID(getVaiTro());
    }

    public User(String hoTen, String email, boolean gioiTinh, LocalDate ngaySinh, String soDienThoai, String diaChi) {
        this.hoTen = hoTen;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;

        this.vaiTro = VaiTro.KhachHang;
        this.trangThai = true;
        autoIncrementID(getVaiTro());

    }

    public User() {
        nhapThongTin();
        this.vaiTro = VaiTro.KhachHang;
        this.trangThai = true;
        autoIncrementID(getVaiTro());
    }

    private void autoIncrementID(VaiTro vaiTro) {
        int so = QLUser.demUserTheoVaiTro(vaiTro) + 1;
        this.maUser = VaiTro.toCode(getVaiTro()) + so;
    }

    public void nhapThongTin(){
        this.hoTen = ScannerUtils.inputName();
        this.email = ScannerUtils.inputEmail();
        this.gioiTinh = ScannerUtils.inputGioiTinh();
        this.ngaySinh = ScannerUtils.inputDate("Nhập ngày sinh: ");
        this.soDienThoai = ScannerUtils.inputSDT();
        this.diaChi = ScannerUtils.inputDiaChi();
    }

    public boolean isThisStudentBusy(CaHoc caHocCanSo) {
        ArrayList<HocVienLopHoc> dsLopHocCaNhan = QLHocVienLopHoc.timKiemTheoHocVien(maUser);
        for (HocVienLopHoc hocVienLopHoc : dsLopHocCaNhan) {
            CaHoc caHoc1 = hocVienLopHoc.getLopHoc().getCaHocMacDinh().get(0);
            CaHoc caHoc2 = hocVienLopHoc.getLopHoc().getCaHocMacDinh().get(1);
            if (caHoc1.equal(caHocCanSo) || caHoc2.equal(caHocCanSo) ){
                return true;
            }
        }
        return false;
    }

    public boolean isThisTeacherBusy(CaHoc caHocCanSo) {
        ArrayList<LopHoc> dsLopHocCaNhan = QLLopHoc.timKiemLopTheoGiangVien(this.getMaUser());
        for (LopHoc lopHoc : dsLopHocCaNhan) {
            CaHoc caHoc1 = lopHoc.getCaHocMacDinh().get(0);
            CaHoc caHoc2 = lopHoc.getCaHocMacDinh().get(1);
            if (caHoc1.equal(caHocCanSo) || caHoc2.equal(caHocCanSo) ){
                return true;
            }
        }

        return false;
    }

    public boolean isThisTutorBusy(CaHoc caHocCanSo) {
        ArrayList<LopHoc> dsLopHocCaNhan = QLLopHoc.timKiemLopTheoTroGiang(this.getMaUser());
        for (LopHoc lopHoc : dsLopHocCaNhan) {
            CaHoc caHoc1 = lopHoc.getCaHocMacDinh().get(0);
            CaHoc caHoc2 = lopHoc.getCaHocMacDinh().get(1);
            if (caHoc1.equal(caHocCanSo) || caHoc2.equal(caHocCanSo) ){
                return true;
            }
        }
        return false;
    }

    public boolean isThisStudentBusy(String maLopHoc) {
        ArrayList<HocVienLopHoc> dsCacLopDaHoc = QLHocVienLopHoc.timKiemTheoHocVien(this.getMaUser());
        for (HocVienLopHoc hocVienLopHoc : dsCacLopDaHoc) {
            if (hocVienLopHoc.getLopHoc().getMaLop().equals(maLopHoc)){
                return true;
            }
        }

        return false;
    }
    public boolean isThisTeacherBusy(Thu thu, LocalTime localTime, LocalDate localDate) {
        ArrayList<LopHoc> dsLopHocCaNhan = QLLopHoc.timKiemLopTheoGiangVien(this.getMaUser());
        for (LopHoc lopHoc : dsLopHocCaNhan) {
            CaHoc caHoc1 = lopHoc.getCaHocMacDinh().get(0);
            CaHoc caHoc2 = lopHoc.getCaHocMacDinh().get(1);

            if (caHoc1.getThu().equals(thu) &&
                    caHoc1.getGioVaoHoc().isBefore(localTime) &&
                    caHoc1.getGioTanHoc().isAfter(localTime)) {
                return true;
            } else if (caHoc2.getThu().equals(thu) &&
                    caHoc2.getGioVaoHoc().isBefore(localTime) &&
                    caHoc2.getGioTanHoc().isAfter(localTime)) {
                return true;
            }
        }

        if (this.vaiTro.equals(VaiTro.GiangVien)) {
            ArrayList<LichPhongVan> dsLichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoGV(this.getMaUser());
            for (LichPhongVan lichPhongVan : dsLichPhongVan) {
                if (lichPhongVan.getTrangThaiPhongVan().equals(TrangThaiPhongVan.CHO_PHONGVAN)
                        && lichPhongVan.getNgayThang().equals(localDate)
                        && lichPhongVan.getGioPV().equals(localTime)) {
                    return true;
                }
            }
        }


        return false;
    }

    public void thayDoiThongTin(){
        System.out.println("Bạn muốn thay đổi thông tin nào ?");
        System.out.println("1. Họ tên");
        System.out.println("2. Email");
        System.out.println("3. Giới tính");
        System.out.println("4. Ngày sinh");
        System.out.println("5. SĐT");
        System.out.println("6. Địa chỉ");
        System.out.println("7. Trạng thái");
        int choice = ScannerUtils.inputInt();
        while(choice < 0 | choice > 7){
            System.err.println("Lựa chọn không hợp lệ !! Chọn lại ");
            choice = ScannerUtils.inputInt();
        }
        switch (choice){
            case 1:
                String name = ScannerUtils.inputName();
                setHoTen(name);
                System.out.println("Thay đổi tên thành công !!");
                break;

            case 2:
                String email = ScannerUtils.inputEmail();
                setEmail(email);
                System.out.println("Thay đổi email thành công !!");
                break;

            case 3:
                boolean gioiTinh = ScannerUtils.inputGioiTinh();
                setGioiTinh(gioiTinh);
                System.out.println("Thay đổi giới tính thành công !!");
                break;
            case 4:
                LocalDate ngaySinh = ScannerUtils.inputDate("Hãy nhập ngày sinh mới");
                setNgaySinh(ngaySinh);
                System.out.println("Thay đổi ngày sinh thành công !!");
                break;
            case 5:
                String sdt = ScannerUtils.inputSDT();
                setSoDienThoai(sdt);
                System.out.println("Thay đổi số điện thoại thành công !!");
                break;
            case 6:
                String diaChi = ScannerUtils.inputDiaChi();
                setDiaChi(diaChi);
                System.out.println("Thay đổi địa chỉ thành công !!");
                break;
            case 7:
                boolean trangThai = ScannerUtils.inputTrangThaiUser();
                setTrangThai(trangThai);
                System.out.println("Thay đổi trạng thái user thành công !!");
                break;
        }
    }

    public String getMaUser() {
        return maUser;
    }

    public void setMaUser(String maUser) {
        this.maUser = maUser;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
