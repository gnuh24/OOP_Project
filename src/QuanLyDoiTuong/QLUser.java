package QuanLyDoiTuong;

import NguoiDung.User;
import NguoiDung.VaiTro;
import Utils.DocGhiFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class QLUser {
    public static ArrayList<User> dsUser = new ArrayList<>();

    public static ArrayList<User> getDsUser() {
        return dsUser;
    }

    public static void setDsUser(ArrayList<User> dsUser) {
        QLUser.dsUser = dsUser;
    }

    public static void xuLyDuLieu(ArrayList<String> duLieu) {
        // duyệt qua\ duLieu và bắt đầu xử lý!
        for (String temp : duLieu) {
            // tách chuỗi tam
            String[] cacThuocTinh = temp.split("#");

            // thiết lập các thuộc tính cho đối tượng

            String id = cacThuocTinh[0];
            String hoTen = cacThuocTinh[1];
            String email = cacThuocTinh[2];
            boolean gioiTinh = (cacThuocTinh[3].equals("1"));

            // Định dạng của chuỗi
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // Chuyển đổi chuỗi thành LocalDate
            LocalDate localDate = LocalDate.parse(cacThuocTinh[4], formatter);

            String sdt = cacThuocTinh[5];
            String diaChi = cacThuocTinh[6];
            VaiTro vaiTro = VaiTro.toEnum(cacThuocTinh[7]);
            boolean trangThai = (cacThuocTinh[8].equals("1"));

            // tạo ra dối tượng và thêm vào dsGiangVien
            QLUser.getDsUser().add(new User(id, hoTen, email, gioiTinh, localDate, sdt,diaChi, vaiTro, trangThai));
        }
    }

    public static ArrayList<String> trichXuatDuLieu() {
        ArrayList<String> duLieu = new ArrayList<>();

        for (User user : QLUser.getDsUser()) {



            boolean gt = user.isGioiTinh();
            String gioiTinh = (gt) ? "1" : "0";

            boolean tt = user.isTrangThai();
            String trangThai = (tt) ? "1" : "0";

            //String ngaySinh = ScannerUtils.;

            StringBuilder sb = new StringBuilder();
            sb.append(user.getMaUser()).append("#");
            sb.append(user.getHoTen()).append("#");
            sb.append(user.getEmail()).append("#");
            sb.append(gioiTinh).append("#");

            sb.append(user.getSoDienThoai()).append("#");
            sb.append(ngaySinh).append("#");
            sb.append(user.getDiaChi()).append("#");
            sb.append(user.getMa()).append("#");
            sb.append(trangThai);sb.append(System.lineSeparator());

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



    // Hàm in thông tin giảng viên
    public static void inThongTinGiangVien(ArrayList<GiangVien> dsGiangVien) {
        System.out.println("*".repeat(148));

        System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* Ho ten", "* Email", "* G/tinh",
                "* SDT", "* Ngay sinh", "* Dia chi", "* Ma", "* Trang thai");

        System.out.println("*".repeat(148));

        for (var giangVien : dsGiangVien) {
            String gioiTinh = (giangVien.getGioiTinh()) ? "Nam" : "Nu";
            String trangThai = (giangVien.getTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

            System.out.printf("%-20s %-25s %-10s %-15s %-15s %-25s %-10s %-20s*\n", "* " + giangVien.getHoTen(),
                    "* " + giangVien.getEmail(), "* " + gioiTinh, "* " + giangVien.getSoDienThoai(),
                    "* " + giangVien.getNgaySinh(), "* " + giangVien.getDiaChi(), "* " + giangVien.getMa(),
                    "* " + trangThai);
        }
        System.out.println("*".repeat(148));
    }

    public static User timUserTheoMa(String idUser){
        for (User user: QLUser.getDsUser()) {
            if (user.getMaUser().equals(idUser)){
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoHoTen(String tenUser){
        for (User user: QLUser.getDsUser()) {
            if (user.getHoTen().equals(tenUser)){
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoEmail(String emailUser){
        for (User user: QLUser.getDsUser()) {
            if (user.getEmail().equals(emailUser)){
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoSTD(String sdtUser){
        for (User user: QLUser.getDsUser()) {
            if (user.getSoDienThoai().equals(sdtUser)){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> timUserTheoVaiTro(VaiTro vaiTro){
        ArrayList<User> ketQua = new ArrayList<>();
        for (User user: QLUser.getDsUser()) {
            if (user.getVaiTro().equals(vaiTro)){
                ketQua.add(user);
            }
        }
        return ketQua;
    }

    public static int demUserTheoVaiTro(VaiTro vaiTro){
        int count = 0;
        for (User user: QLUser.getDsUser()) {
            if (user.getVaiTro().equals(vaiTro)){
                count++;
            }
        }
        return count;
    }


}
