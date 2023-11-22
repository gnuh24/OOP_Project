package TaiKhoan;

public class TaiKhoan {
    private String id;
    private String tenTaiKhoan;
    private String matKhau;
    private boolean trangThai;

    // Constructors
    public TaiKhoan(String id, String tenTaiKhoan, String matKhau, boolean trangThai) {
        this.id = id;
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public TaiKhoan(String id, String tenTaiKhoan, String matKhau) {
        this(id, tenTaiKhoan, matKhau, true);
    }

    // Setters & Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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