package NguoiDung;

import HeThongGiaoDuc.LopHoc.LopHoc;
import QuanLyDoiTuong.QLLopHoc;
import QuanLyDoiTuong.QLUser;
import ThoiGian.CaHoc;
import ThoiGian.Thu;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalTime;

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

    public boolean isBusy(Thu thu, LocalTime localTime) {
        for (LopHoc lopHoc : QLLopHoc.getDsLopHoc()) {
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
        return false;
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
