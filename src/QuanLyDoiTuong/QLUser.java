package QuanLyDoiTuong;

import NguoiDung.User;
import NguoiDung.VaiTro;
import Utils.Convert;
import Utils.DocGhiFile;

import java.time.LocalDate;
import java.util.ArrayList;

public class QLUser {

    public static void main(String[] args) {
        loadDuLieu();
        inThongTin(dsUser);
        System.out.println(demUserTheoVaiTro(VaiTro.GiangVien));
        inThongTin(timUserTheoVaiTro(VaiTro.GiangVien));
        saveDuLieu();
    }

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

            LocalDate localDate = Convert.stringToDate(cacThuocTinh[4]);

            String sdt = cacThuocTinh[5];
            String diaChi = cacThuocTinh[6];
            VaiTro vaiTro = VaiTro.toEnum(cacThuocTinh[7]);
            boolean trangThai = (cacThuocTinh[8].equals("1"));

            // tạo ra dối tượng và thêm vào dsGiangVien
            QLUser.getDsUser().add(new User(id, hoTen, email, gioiTinh, localDate, sdt, diaChi, vaiTro, trangThai));
        }
    }

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
        System.out.println("*".repeat(171));

        System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-15s* %-15s* %-20s*\n", "Mã user", "Họ và tên",
                "Email",
                "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Vại trò", "Trạng Thái");

        System.out.println("*".repeat(171));

        for (User user : dsUser) {
            String gioiTinh = (user.isGioiTinh()) ? "Nam" : "Nu";
            String trangThai = (user.isTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

            System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-15s* %-15s* %-20s*\n",
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
        System.out.println("*".repeat(171));
    }

    public static void inThongTin(User user) {
        System.out.println("*".repeat(171));

        System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-15s* %-15s* %-20s*\n", "Mã user", "Họ và tên",
                "Email",
                "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Vại trò", "Trạng Thái");

        System.out.println("*".repeat(171));

        String gioiTinh = (user.isGioiTinh()) ? "Nam" : "Nu";
        String trangThai = (user.isTrangThai()) ? "Hoat dong" : "Ngung hoat dong";

        System.out.printf("* %-10s* %-25s* %-25s* %-12s* %-15s* %-15s* %-15s* %-15s* %-20s*\n",
                user.getMaUser(),
                user.getHoTen(),
                user.getEmail(),
                gioiTinh,
                Convert.dateToString(user.getNgaySinh()),
                user.getSoDienThoai(),
                user.getDiaChi(),
                VaiTro.toString(user.getVaiTro()),
                trangThai);
        System.out.println("*".repeat(171));
    }

    public static User timUserTheoMa(String idUser) {
        for (User user : QLUser.getDsUser()) {
            if (user.getMaUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoHoTen(String tenUser) {
        for (User user : QLUser.getDsUser()) {
            if (user.getHoTen().equals(tenUser)) {
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoEmail(String emailUser) {
        for (User user : QLUser.getDsUser()) {
            if (user.getEmail().equals(emailUser)) {
                return user;
            }
        }
        return null;
    }

    public static User timUserTheoSTD(String sdtUser) {
        for (User user : QLUser.getDsUser()) {
            if (user.getSoDienThoai().equals(sdtUser)) {
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

}
