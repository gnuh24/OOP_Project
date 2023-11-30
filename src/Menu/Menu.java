package Menu;
import Menu.Actor.ActorKhachHang;
public class Menu {
    private static final ActorKhachHang actorKhachHang = new ActorKhachHang();
    public static void main(String[] args) {
        LoadDuLieu.loading();
        actorKhachHang.giaoDien();
    }
}
