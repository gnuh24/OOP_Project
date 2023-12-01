package Menu.Actor;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.LopHoc.KetQua;
import HeThongGiaoDuc.LopHoc.LopHoc;
import QuanLyDoiTuong.QLChuongTrinhHoc;
import QuanLyDoiTuong.QLKetQua;
import QuanLyDoiTuong.QLKhoaKhaiGiang;
import QuanLyDoiTuong.QLLopHoc;
import Utils.Convert;
import Utils.ScannerUtils;

public class ActorQuanLy extends ActorCongTacVien{
    public void giaoDien(){

        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI THUG88-----------------------------------------------");
            System.out.println("1. Tạo khóa mới");
            System.out.println("2. Tạo lớp mới");
            System.out.println("3. Thống kê học sinh theo chương trình học");
            System.out.println("4. Thống kê học sinh theo khóa");
            System.out.println("5. Thống kê học sinh theo năm");
            System.out.println("6. Thống kê doanh thu theo chương trình");
            System.out.println("7. Thống kê doanh thu theo khóa");
            System.out.println("8. Thống kê doanh thu theo tháng");
            System.out.println("9. THống kê doanh thu theo năm");
            System.out.println("10. Đăng xuất");
            System.out.println("Bạn đã có lựa chọn chưa?");
            do{
                choice = ScannerUtils.inputInt();
                if (choice < 1 || choice > 11){
                    System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
                }
            }while(choice < 1 || choice > 11);

            switch (choice){
                case 1:
                    taoKhoaMoi();
                    break;

                case 2:
                    taoLopMoi();
                    break;

                case 3:
                    thongKeHocVienTheoChuongTrinh();
                    break;

                case 4:
                    thongKeHocVienTheoKhoa();
                    break;

                case 5:
                    thongKeHocVienTheoNam();
                    break;

                case 6:
                    
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    System.out.println("Bạn thực sự muốn thoát");
                    exit();
                    break;
            }
        } while (true);
    }


    public void taoKhoaMoi(){
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate ngayBatDau = LocalDate.now();
        ngayBatDau.format(formater);
	    LocalDate ngayKetThuc = LocalDate.now();
        ngayKetThuc.format(formater);
        KhoaKhaiGiang khoaKhaiGiangMoi = new KhoaKhaiGiang(ngayBatDau, ngayKetThuc);
        QLKhoaKhaiGiang.getDsKhoaKhaiGiang().add(khoaKhaiGiangMoi);

        System.out.println("Đã thêm khóa");
    }

    public void taoLopMoi(){
        String tenLop;
        String khoa;
        String chuongTrinhHoc;
        System.out.println("Nhập tên lớp: ");
        tenLop = ScannerUtils.inputString();

        LocalDate ngayBatDau = LocalDate.now();
        System.out.printf("* %-10s* %-15s* %-15s*\n",
				"Mã khóa",
				"Ngày bắt đầu",
				"Ngày kết thúc");
		System.out.println("***********************************************");
		for (KhoaKhaiGiang khoaKhaiGiang : QLKhoaKhaiGiang.getDsKhoaKhaiGiang()) {
            if(khoaKhaiGiang.getNgayBatDau().compareTo(ngayBatDau)>0){
			    System.out.printf("* %-10s* %-15s* %-15s*\n",
                khoaKhaiGiang.getMaKhoa(),
                Convert.dateToString(khoaKhaiGiang.getNgayBatDau()),
                Convert.dateToString(khoaKhaiGiang.getNgayKetThuc()));
            }
		}
        System.out.println("Nhập mã khóa khai giảng");
        khoa = ScannerUtils.inputString();

        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());

        System.out.println("Nhập mã khóa chương trình học");
        chuongTrinhHoc = ScannerUtils.inputString();

        LopHoc lopHoc = new LopHoc(tenLop, QLKhoaKhaiGiang.timKiemTheoMaKhoa(khoa), QLChuongTrinhHoc.timKiemTheoMa(chuongTrinhHoc));

        QLLopHoc.getDsLopHoc().add(lopHoc);
        System.out.println("Đã thêm lớp");
    }


    public void thongKeHocVienTheoChuongTrinh(){
        int []demSoHocVienCTH=new int[17];
        for(int i=0; i<demSoHocVienCTH.length;i++){
            demSoHocVienCTH[i]=0;
        }
        for(KetQua ketQua:QLKetQua.getDsKetQua()){
            switch (ketQua.getLopHoc().getChuongTrinh().getMaChuongTrinh()) {
                case "CTH001":  demSoHocVienCTH[0]++; break;
                case "CTH002":  demSoHocVienCTH[1]++; break;
                case "CTH003":  demSoHocVienCTH[2]++; break;
                case "CTH004":  demSoHocVienCTH[3]++; break;
                case "CTH005":  demSoHocVienCTH[4]++; break;
                case "CTH006":  demSoHocVienCTH[5]++; break;
                case "CTH007":  demSoHocVienCTH[6]++; break;
                case "CTH008":  demSoHocVienCTH[7]++; break;
                case "CTH009":  demSoHocVienCTH[8]++; break;
                case "CTH010":  demSoHocVienCTH[9]++; break;
                case "CTH011": demSoHocVienCTH[10]++; break;
                case "CTH012": demSoHocVienCTH[11]++; break;
                case "CTH013": demSoHocVienCTH[12]++; break;
                case "CTH014": demSoHocVienCTH[13]++; break;
                case "CTH015": demSoHocVienCTH[14]++; break;
                case "CTH016": demSoHocVienCTH[15]++; break;
                case "CTH017": demSoHocVienCTH[16]++; break;
            }
        }
        int min=demSoHocVienCTH[0];
        for(int i=1; i<demSoHocVienCTH.length;i++){
            if(min>demSoHocVienCTH[i])
                min=demSoHocVienCTH[i];
        }
        if(min==0) min=1;
        for(int i=0; i<demSoHocVienCTH.length;i++){
            demSoHocVienCTH[i]/=min;
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i=0; i<demSoHocVienCTH.length; i++){
            System.out.printf("%-10s","CTH"+i+"|"+demSoHocVienCTH[i]+"| ");
            for(int j=0; j<demSoHocVienCTH[i]; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }


    public void thongKeHocVienTheoKhoa(){
        int demHocVien=0;
        QLKhoaKhaiGiang.inDanhSachKhoaKhaiGiang(QLKhoaKhaiGiang.getDsKhoaKhaiGiang());
        System.out.println("Nhập mã Khóa");
        String maKhoa = ScannerUtils.inputString();
        for(KetQua ketQua:QLKetQua.getDsKetQua()){
            if(ketQua.getLopHoc().getKhoa().getMaKhoa().equals(maKhoa)){
                demHocVien++;
            }
        }
        System.out.println("Số học viên của khóa: "+demHocVien);
    }



    public void thongKeHocVienTheoNam(){
        int []demHocVien=new int[13];
        for(int i=0; i<demHocVien.length; i++){
            demHocVien[i]=0;
        }
        System.out.println("Nhập năm muốn kiểm tra: ");
        int nam = ScannerUtils.inputInt();
        for(KetQua ketQua:QLKetQua.getDsKetQua()){
            if(ketQua.getLopHoc().getKhoa().getNgayBatDau().getYear()==nam){
                demHocVien[0]++;
                switch (ketQua.getLopHoc().getKhoa().getNgayBatDau().getMonthValue()) {
                    case 1: demHocVien[1]++; break;
                    case 2: demHocVien[2]++; break;
                    case 3: demHocVien[3]++; break;
                    case 4: demHocVien[4]++; break;
                    case 5: demHocVien[5]++; break;
                    case 6: demHocVien[6]++; break;
                    case 7: demHocVien[7]++; break;
                    case 8: demHocVien[8]++; break;
                    case 9: demHocVien[9]++; break;
                    case 10: demHocVien[10]++; break;
                    case 11: demHocVien[11]++; break;
                    case 12: demHocVien[12]++; break;
                }
            }
        }

        System.out.println("Số học viên năm "+nam+" "+demHocVien[0]);
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i=1; i<demHocVien.length; i++){
            System.out.printf("%-10s","Tháng"+i+"|"+demHocVien[i]+"| ");
            for(int j=0; j<demHocVien[i]; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
