package TaiKhoan;

import Menu.Menu;

import java.util.ArrayList;

public class QLTaiKhoan {
    public static ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();

    public static ArrayList<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    public static void setDsTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan) {
        QLTaiKhoan.dsTaiKhoan = dsTaiKhoan;
    }

    public static void inDSTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan){
        System.out.println("*".repeat(55));
        System.out.printf("* %-10s* %-20s* %-18s*\n", "ID", "Tên tài khoản", "Trạng thái");
        System.out.println("*".repeat(55));
        for (TaiKhoan tk: dsTaiKhoan){
            String trangThai = null;
            if (tk.isTrangThai()){
                trangThai = "Được hoạt động";
            }
            else {
                trangThai = "Bị thu hồi";
            }
            System.out.printf("* %-10s* %-20s* %-18s*\n", tk.getId(), tk.getTenTaiKhoan(), trangThai);
        }
        System.out.println("*".repeat(55));


    }
    public static void main(String[] args) {
        // Tạo 10 tài khoản và thêm vào danh sách
        for (int i = 1; i <= 10; i++) {
            String id = "ID" + i;
            String tenTaiKhoan = "User" + i; // Tên tài khoản mẫu
            String matKhau = "Password" + i; // Mật khẩu mẫu
            boolean trangThai;

            if (i % 2 == 0){
                trangThai       = true; // Có thể thay đổi tùy theo yêu cầu

            } else {
                trangThai       = false; // Có thể thay đổi tùy theo yêu cầu

            }

            TaiKhoan taiKhoan = new TaiKhoan(id, tenTaiKhoan, matKhau, trangThai);
            dsTaiKhoan.add(taiKhoan);
        }

        QLTaiKhoan.inDSTaiKhoan(QLTaiKhoan.getDsTaiKhoan());
        QLTaiKhoan.inDSTaiKhoan(QLTaiKhoan.timTaiKhoanTheoTrangThai(true));
        System.out.println(QLTaiKhoan.timTaiKhoanTheoUsername("User2"));
    }

    public static TaiKhoan timTaiKhoanTheoUsername(String username){
        for (TaiKhoan tk: QLTaiKhoan.getDsTaiKhoan()){
            if (tk.getTenTaiKhoan().equals(username)){
                return tk;
            }
        }
        return null;
    }

    public static ArrayList<TaiKhoan> timTaiKhoanTheoTrangThai(boolean trangThai){
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();
        for (TaiKhoan tk: QLTaiKhoan.getDsTaiKhoan()){
            if (tk.isTrangThai() == trangThai){
                dsTaiKhoan.add(tk);
            }
        }
        return dsTaiKhoan;
    }

}
