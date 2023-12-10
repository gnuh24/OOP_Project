package TaiKhoan;

import Menu.Session;
import NguoiDung.User;
import QuanLyDoiTuong.QLUser;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.util.ArrayList;

public class QLTaiKhoan {
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

    public static void thuHoiTaiKhoan(){
        inDSTaiKhoan(QLTaiKhoan.dsTaiKhoan);
        System.out.println("Hãy chọn tài khoản bạn muốn thu hồi (hoặc gỡ thu hồi)");
        System.out.println("Ấn 1 để thoát khỏi đây ");
        String userName = ScannerUtils.inputString();
        if (userName.equals("1")){
            return;
        }
        TaiKhoan taiKhoan = timTaiKhoanTheoUsername(userName);
        while(taiKhoan == null){
            System.err.println("Tài khoản không tồn tại !!. Xin mời nhập lại ");
            System.out.println("Ấn 1 để thoát khỏi đây ");
            userName = ScannerUtils.inputString();
            if (userName.equals("1")){
                return;
            }
            taiKhoan = timTaiKhoanTheoUsername(userName);
        }

        System.out.println("Hãy chọn trạng thái bạn muốn thay đổi !!");
        System.out.println("1. Thu hồi tài khoản (Global ban)");
        System.out.println("2. Gỡ thu hồi");
        System.out.println("3. Thoát khỏi đây ");

        System.out.println("Lưu ý: Nếu tài khoản bị thu hồi sẽ không thể đăng nhập được !!");

        int choice = ScannerUtils.inputInt();
        if (choice == 3){
            return;
        }

        while (choice != 1 && choice != 2){
            System.err.println("Lựa chọn không hợp lệ !!. Chọn lại");
            choice = ScannerUtils.inputInt();
            if (choice == 3){
                return;
            }
        }

        if (choice == 1){
            taiKhoan.setTrangThai(false);
            System.out.println("Đã thu hồi tài khoản thành công !!");
        }else{
            taiKhoan.setTrangThai(true);
            System.out.println("Đã gỡ thu hồi tài khoản thành công !!");
        }
    }

    public static void taoTaiKhoanMoi(User user){
        TaiKhoan taiKhoan = new TaiKhoan(user);
        QLTaiKhoan.getDsTaiKhoan().add(taiKhoan);
        System.out.println("Tạo tài khoản mới thành công !!");
    }

    public static void doiMatKhau(){
        inDSTaiKhoan(QLTaiKhoan.dsTaiKhoan);
        System.out.println("Hãy chọn tài khoản bạn muốn thu hồi (hoặc gỡ thu hồi)");
        System.out.println("Ấn 1 để thoát khỏi đây ");
        String userName = ScannerUtils.inputString();
        if (userName.equals("1")){
            return;
        }
        TaiKhoan taiKhoan = timTaiKhoanTheoUsername(userName);
        while(taiKhoan == null){
            System.err.println("Tài khoản không tồn tại !!. Xin mời nhập lại ");
            System.out.println("Ấn 1 để thoát khỏi đây ");
            userName = ScannerUtils.inputString();
            if (userName.equals("1")){
                return;
            }
            taiKhoan = timTaiKhoanTheoUsername(userName);
        }

        System.out.println("Hãy nhập mật khẩu mới cho tài khoản !!");
        String password = ScannerUtils.inputString();
        System.out.println("Hãy nhập lại mật khẩu của bạn để xác thực danh tính !!");
        String adminPassword = ScannerUtils.inputString();
        if (!adminPassword.equals(Session.getTaiKhoan().getMatKhau())){
            System.err.println("Mật khẩu của bạn nhập không đúng !!!");
            System.err.println("Phát hiện nguy cơ bảo mật. Hệ thống sẽ tự đăng xuất để đảm bảo an toản !!!");
            Session.logout();
        }
        taiKhoan.setMatKhau(password);
        System.out.println("Thay đổi mật khẩu thành công !!");
    }

    public static TaiKhoan timTaiKhoanTheoUsername(String username){
        for (TaiKhoan tk: QLTaiKhoan.getDsTaiKhoan()){
            if (tk.getTenTaiKhoan().equals(username)){
                return tk;
            }
        }
        return null;
    }

    public static void taoTaiKhoanMoi(){
        System.out.println("Bạn muốn tạo tài khoản cho đối tượng nào ?");
        System.out.println("1. Những người đã có thông tin trong cơ sở dữ liệu");
        System.out.println("2. Những người chưa có thông tin trong cơ sở dữ liệu");
        System.out.println("Các số còn lại để thoát !!");
        int choice = ScannerUtils.inputInt();
        switch (choice){
            case 1:
                ArrayList<User> dsNguoiChuaCoTaiKhoan = QLUser.timNhungUserChuaCoTaiKhoan();
                QLUser.inThongTin(dsNguoiChuaCoTaiKhoan);
                System.out.println("Đây là những người chưa có tài khoản !!");
                System.out.println("Bạn muốn tạo tài khoản cho ai ??");
                System.out.println("Ấn 1 để thoát !!");
                String id = ScannerUtils.inputString();
                if (id.equals("1")){
                    return;
                }
                User user = QLUser.timUserTheoMa(id, dsNguoiChuaCoTaiKhoan);
                while (user == null){
                    System.out.println("Không tìm thấy mã thông tin của người bạn cần tạo !!");
                    System.out.println("Ấn 1 để thoát !!");
                    id = ScannerUtils.inputString();
                    if (id.equals("1")){
                        return;
                    }
                    user = QLUser.timUserTheoMa(id, dsNguoiChuaCoTaiKhoan);
                }
                QLTaiKhoan.taoTaiKhoanMoi(user);
                break;
            case 2:
                QLTaiKhoan.taoTaiKhoanMoi(QLUser.themUserMoi());
                break;


        }
    }
}
