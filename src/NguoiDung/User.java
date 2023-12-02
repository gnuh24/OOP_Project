package NguoiDung;

import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;

import java.time.LocalDate;

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
        nhapThongTinBoiKhachHang();
        this.vaiTro = VaiTro.KhachHang;
        this.trangThai = true;
        autoIncrementID(getVaiTro());
    }

    private void autoIncrementID(VaiTro vaiTro) {
        int so = QLUser.demUserTheoVaiTro(vaiTro) + 1;
        this.maUser = VaiTro.toCode(getVaiTro()) + so;
    }

    public void nhapThongTinBoiKhachHang(){
        this.hoTen = ScannerUtils.inputName();
        this.email = ScannerUtils.inputEmail();
        this.gioiTinh = ScannerUtils.inputGioiTinh();
        this.ngaySinh = ScannerUtils.inputDate();
        this.soDienThoai = ScannerUtils.inputSDT();
        this.diaChi = ScannerUtils.inputDiaChi();
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
