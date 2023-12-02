package TaiKhoan;

//import Menu.Menu;
import NguoiDung.User;
import QuanLyDoiTuong.QLUser;
import Utils.DocGhiFile;

import java.util.ArrayList;

public class QLTaiKhoan {

    public static void main(String[] args) {
        QLUser.loadDuLieu();
        loadDuLieu();
        inDSTaiKhoan(dsTaiKhoan);
        saveDuLieu();
    }
    public static ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<>();

    public static ArrayList<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    public static void setDsTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan) {
        QLTaiKhoan.dsTaiKhoan = dsTaiKhoan;
    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (var tam : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = tam.split("#");

            // thiết lập các thuộc tính cho đối tượng
            String id = cacThuocTinh[0];
            String tenTaiKhoan = cacThuocTinh[1];
            String matKhau = cacThuocTinh[2];
            boolean trangThai = (cacThuocTinh[3].equals("1"));

            // tạo ra dối tượng và thêm vào dsTaiKhoan
            dsTaiKhoan.add(new TaiKhoan(QLUser.timUserTheoMa(id), tenTaiKhoan, matKhau, trangThai));
        }
    }

    public static ArrayList<String> trichXuatDuLieu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (var taiKhoan : dsTaiKhoan) {
            String user = taiKhoan.getUser().getMaUser();
            String tenTaiKhoan = taiKhoan.getTenTaiKhoan();
            String matKhau = taiKhoan.getMatKhau();
            boolean tt = taiKhoan.isTrangThai();
            String trangThai = (tt) ? "1" : "0";

            StringBuilder sb = new StringBuilder();
            sb.append(user).append("#");
            sb.append(tenTaiKhoan).append("#");
            sb.append(matKhau).append("#");
            sb.append(trangThai);
            sb.append(System.lineSeparator());
            duLieu.add(sb.toString());
        }

        return duLieu;
    }


    // Hàm load dữ liệu từ file
    public static void loadDuLieu() {
        String filePath = "src\\Data\\qlTaiKhoan.txt";
        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong TÀI KHOẢN");
    }

    // Hàm save dữ liệu vào file
    public static void saveDuLieu() {
        String filePath = "src\\Data\\qlTaiKhoan.txt";
        ArrayList<String> duLieu = trichXuatDuLieu();
        DocGhiFile.ghiDuLieuFile(filePath, duLieu);
        System.out.println("Đã lưu xong TÀI KHOẢN");

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
            System.out.printf("* %-10s* %-20s* %-18s*\n", tk.getUser().getMaUser(), tk.getTenTaiKhoan(), trangThai);
        }
        System.out.println("*".repeat(55));


    }

    public static TaiKhoan taoTaiKhoanMoi(User user){
        TaiKhoan taiKhoan = new TaiKhoan(user);
        QLTaiKhoan.getDsTaiKhoan().add(taiKhoan);
        System.out.println("Tạo tài khoản mới thành công !!");
        return taiKhoan;
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
