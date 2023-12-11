package QuanLyDoiTuong;

import NguoiDung.User;
import NguoiDung.VaiTro;
import TaiKhoan.*;
import Utils.Convert;
import Utils.DocGhiFile;
import Utils.ScannerUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class QLUser {
    public static ArrayList<User> dsUser = new ArrayList<>();

    public static ArrayList<User> getDsUser() {
        return dsUser;
    }

    public static void setDsUser(ArrayList<User> dsUser) {
        QLUser.dsUser = dsUser;
    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua duLieu và bắt đầu xử lý!
        for (String temp : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = temp.split("#");

            // thiết lập các thuộc tính cho đối tượng

            String id = cacThuocTinh[0];
            String hoTen = cacThuocTinh[1];
            String email = cacThuocTinh[2];
            boolean gioiTinh = (cacThuocTinh[3].equals("1"));

            LocalDate localDate = Convert.stringToDate(cacThuocTinh[4]);

            String sdt = cacThuocTinh[5];
            String diaChi = cacThuocTinh[6];
            VaiTro vaiTro = VaiTro.toEnum(cacThuocTinh[7]);
            boolean trangThai = (cacThuocTinh[8].equals("1"));

            // tạo ra dối tượng và thêm vào dsGiangVien
            QLUser.getDsUser().add(new User(id, hoTen, email, gioiTinh, localDate, sdt, diaChi, vaiTro, trangThai));
        }
    }

    // Tạo ra chuỗi thông tin từ danh sách để lưu
    public static ArrayList<String> trichXuatDuLieu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (User user : QLUser.getDsUser()) {

            boolean gt = user.isGioiTinh();
            String gioiTinh = (gt) ? "1" : "0";

            boolean tt = user.isTrangThai();
            String trangThai = (tt) ? "1" : "0";

            String ngaySinh = Convert.dateToString(user.getNgaySinh());
            String vaiTro = VaiTro.toString(user.getVaiTro());

            StringBuilder sb = new StringBuilder();
            sb.append(user.getMaUser()).append("#");
            sb.append(user.getHoTen()).append("#");
            sb.append(user.getEmail()).append("#");
            sb.append(gioiTinh).append("#");
            sb.append(ngaySinh).append("#");
            sb.append(user.getSoDienThoai()).append("#");
            sb.append(user.getDiaChi()).append("#");
            sb.append(vaiTro).append("#");
            sb.append(trangThai);
            sb.append(System.lineSeparator());

            duLieu.add(sb.toString());
        }

        return duLieu;
    }

    // Hàm load dữ liệu từ file
    public static void loadDuLieu() {
        String filePath = "src\\\\Data\\\\qlUser.txt";
        ArrayList<String> duLieu = DocGhiFile.docDuLieuFile(filePath);
        xuLyDuLieu(duLieu);
        System.out.println("Đã tải xong USER");
    }

    // Hàm save dữ liệu vào file
    public static void saveDuLieu() {
        String filePath = "src\\\\Data\\\\qlUser.txt";
        ArrayList<String> duLieu = trichXuatDuLieu();
        DocGhiFile.ghiDuLieuFile(filePath, duLieu);
        System.out.println("Đã lưu xong USER");

    }

    public static void inThongTin(ArrayList<User> dsUser) {
        System.out.println("*".repeat(186));

        System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-30s* %-15s* %-20s*\n", "Mã user", "Họ và tên",
                "Email",
                "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Vại trò", "Trạng Thái");

        System.out.println("*".repeat(186));

        for (User user : dsUser) {
            String gioiTinh = (user.isGioiTinh()) ? "Nam" : "Nu";
            String trangThai = (user.isTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

            System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-30s* %-15s* %-20s*\n",
                    user.getMaUser(),
                    user.getHoTen(),
                    user.getEmail(),
                    gioiTinh,
                    Convert.dateToString(user.getNgaySinh()),
                    user.getSoDienThoai(),
                    user.getDiaChi(),
                    VaiTro.toString(user.getVaiTro()),
                    trangThai);
        }
        System.out.println("*".repeat(186));
    }

    public static User timUserTheoMa(String idUser) {
        for (User user : QLUser.getDsUser()) {
            if (user.getMaUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoMa(String idUser, ArrayList<User> dsUser) {
        for (User user : dsUser) {
            if (user.getMaUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> timUserTheoVaiTro(VaiTro vaiTro, boolean trangThai) {
        ArrayList<User> ketQua = new ArrayList<>();
        for (User user : QLUser.getDsUser()) {
            if (user.getVaiTro().equals(vaiTro) && user.isTrangThai() == trangThai) {
                ketQua.add(user);
            }
        }
        return ketQua;
    }

    public static ArrayList<User> timUserTheoVaiTro(VaiTro vaiTro) {
        ArrayList<User> ketQua = new ArrayList<>();
        for (User user : QLUser.getDsUser()) {
            if (user.getVaiTro().equals(vaiTro)) {
                ketQua.add(user);
            }
        }
        return ketQua;
    }

    public static int demUserTheoVaiTro(VaiTro vaiTro) {
        int count = 0;
        for (User user : QLUser.getDsUser()) {
            if (user.getVaiTro().equals(vaiTro)) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<User> timNhungUserChuaCoTaiKhoan(){
        ArrayList<User> dsNhungNguoiCoTaiKhoan = new ArrayList<>();
        for (User user: QLUser.getDsUser()){
            for (TaiKhoan tk: QLTaiKhoan.getDsTaiKhoan()){
                if (user.getMaUser().equals(tk.getUser().getMaUser())){
                    dsNhungNguoiCoTaiKhoan.add(user);
                }
            }
        }
        ArrayList<User> temp = new ArrayList<>(QLUser.getDsUser());
        temp.removeAll(dsNhungNguoiCoTaiKhoan);
        return temp;
    }

    public static User themUserMoi(){
        String hoTen = ScannerUtils.inputName();
        String email = ScannerUtils.inputEmail();
        boolean gioiTinh = ScannerUtils.inputGioiTinh();
        LocalDate ngaySinh = ScannerUtils.inputDate("Nhập ngày sinh. ");
        String soDienThoai = ScannerUtils.inputSDT();
        String diaChi = ScannerUtils.inputDiaChi();
        VaiTro vaiTro = ScannerUtils.inputVaiTro();
        User newUser = new User(hoTen, email, gioiTinh, ngaySinh,soDienThoai,diaChi, vaiTro);
        QLUser.getDsUser().add(newUser);
        System.out.println("Bạn đã thêm thông tin User thành công !!");
        return newUser;
    }

    public static void thayDoiThongTin(){
        QLUser.inThongTin(QLUser.getDsUser());
        System.out.println("Bạn muốn thay đổi thông tin nào ? (Nhập ID)");
        System.out.println("Ấn 1 để thoát !!");
        String id = ScannerUtils.inputString();
        if (id.equals("1")){
            return;
        }
        User user = QLUser.timUserTheoMa(id);
        while (user == null){
            System.err.println("Không tìm thấy User !! Nhập lại :3");
            System.out.println("Ấn 1 để thoát !!");
            id = ScannerUtils.inputString();
            if (id.equals("1")){
                return;
            }
            user = QLUser.timUserTheoMa(id);
        }

        System.out.println("Bạn muốn thay đổi thông tin nào ?");
        System.out.println("1. Họ tên");
        System.out.println("2. Email");
        System.out.println("3. Giới tính");
        System.out.println("4. Ngày sinh");
        System.out.println("5. SĐT");
        System.out.println("6. Địa chỉ");
        System.out.println("7. Trạng thái");
        int choice = ScannerUtils.inputInt();
        while(choice < 0 | choice > 7){
            System.err.println("Lựa chọn không hợp lệ !! Chọn lại ");
            choice = ScannerUtils.inputInt();
        }
            switch (choice){
                case 1:
                    String name = ScannerUtils.inputName();
                    user.setHoTen(name);
                    System.out.println("Thay đổi tên thành công !!");
                    break;

                case 2:
                    String email = ScannerUtils.inputEmail();
                    user.setEmail(email);
                    System.out.println("Thay đổi email thành công !!");
                    break;

                case 3:
                    boolean gioiTinh = ScannerUtils.inputGioiTinh();
                    user.setGioiTinh(gioiTinh);
                    System.out.println("Thay đổi giới tính thành công !!");
                    break;
                case 4:
                    LocalDate ngaySinh = ScannerUtils.inputDate("Hãy nhập ngày sinh mới");
                    user.setNgaySinh(ngaySinh);
                    System.out.println("Thay đổi ngày sinh thành công !!");
                    break;
                case 5:
                    String sdt = ScannerUtils.inputSDT();
                    user.setSoDienThoai(sdt);
                    System.out.println("Thay đổi số điện thoại thành công !!");
                    break;
                case 6:
                    String diaChi = ScannerUtils.inputDiaChi();
                    user.setDiaChi(diaChi);
                    System.out.println("Thay đổi địa chỉ thành công !!");
                    break;
                case 7:
                    boolean trangThai = ScannerUtils.inputTrangThaiUser();
                    user.setTrangThai(trangThai);
                    System.out.println("Thay đổi trạng thái user thành công !!");
                    break;

        }
    }
}
