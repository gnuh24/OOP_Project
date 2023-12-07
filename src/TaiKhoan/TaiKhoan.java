package TaiKhoan;

import NguoiDung.User;

public class TaiKhoan {
    private User user;
    private String tenTaiKhoan;
    private String matKhau;
    private boolean trangThai;

    public TaiKhoan(User user) {
        this.user = user;
        this.tenTaiKhoan = user.getMaUser();
        this.matKhau = "123456";
        this.trangThai = true;
    }

    public TaiKhoan(User user, String tenTaiKhoan, String matKhau, boolean trangThai) {
        this.user = user;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}