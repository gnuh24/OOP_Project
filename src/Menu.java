import Menu.GiaoDien.GiaoDienKhachHang;
import Menu.LoadDuLieu;

public class Menu {
    private static final GiaoDienKhachHang actorKhachHang = new GiaoDienKhachHang();

    public static void main(String[] args) {
        LoadDuLieu.loading();
        actorKhachHang.giaoDien();
    }
}
