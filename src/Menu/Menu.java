package Menu;

import Menu.GiaoDien.GiaoDienKhachHang;

public class Menu {
    private static final GiaoDienKhachHang actorKhachHang = new GiaoDienKhachHang();

    public static void main(String[] args) {
    	System.out.println("hdfds");
        LoadDuLieu.loading();
        actorKhachHang.giaoDien();
    }
}
