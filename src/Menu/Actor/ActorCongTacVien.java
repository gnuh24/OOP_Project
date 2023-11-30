package Menu.Actor;

import HeThongGiaoDuc.PhongVan.KetQuaPhongVan;
import HeThongGiaoDuc.PhongVan.LichPhongVan;
import HeThongGiaoDuc.PhongVan.LienHe;
import HeThongGiaoDuc.PhongVan.TrangThaiPhongVan;
import NguoiDung.User;
import NguoiDung.VaiTro;
import QuanLyDoiTuong.QLKetQuaPhongVan;
import QuanLyDoiTuong.QLLichPhongVan;
import QuanLyDoiTuong.QLUser;
import Utils.ScannerUtils;
import java.time.LocalDate;
import java.time.LocalTime;

public class ActorCongTacVien extends Actor{
    public  void giaoDien(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Sắp xếp lịch phổng vấn.");
            System.out.println("2. Thay đổi trạng thái lịch phổng vấn ");
            System.out.println("3. Xem danh sách các cuộc phổng vấn đã có kết quả");
            System.out.println("4. Đăng ký khóa học mới");
            System.out.println("5. Đăng xuất");
            System.out.println("6. Thoát chương trình");
            System.out.println("Bạn đã có lựa chọn chưa ?");
            choice = ScannerUtils.inputInt();

            if (choice < 1 || choice > 5 ){
                System.out.println("Bạn chỉ được nhập các lựa chọn  trên màn hình");
            }

            switch (choice){
                case 1:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                    System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
                    System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

                    String id = ScannerUtils.inputString();

                    if (id.equals("1")){
                        giaoDien();
                    }

                    else{
                        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(id);
                        if (lichPhongVan == null){
                            System.out.println("Mã không tồn tại !!!");
                            giaoDien();
                        }
                        else{
                            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                            System.out.println("Hãy chọn giảng viên phù hợp :33");
                            System.out.println("Nếu muốn thoát hãy ấn 1");
                            QLUser.inThongTin(QLUser.timUserTheoVaiTro(VaiTro.GiangVien, true));
                            String idGV = ScannerUtils.inputString();

                            if (idGV.equals("1")){
                                giaoDien();
                            }

                            else {
                                User giangVien = QLUser.timUserTheoMa(idGV);
                                if (giangVien == null){
                                    System.out.println("Giang viên không tồn tại !!");
                                    giaoDien();
                                }
                                else{
                                    lichPhongVan.setGiangVien(giangVien);
                                    System.out.println("Đã thêm giảng vie6n thành công !!");
                                }

                                LocalDate ngayThang = ScannerUtils.inputDate();
                                lichPhongVan.setNgayThang(ngayThang);
                                System.out.println("Đã thêm ngày tháng thành công !!");


                                LocalTime gioHoc = ScannerUtils.inputTime();
                                lichPhongVan.setGioPV(gioHoc);
                                System.out.println("Đã thêm giờ thành công !!");

                                if (lichPhongVan.isValid()){
                                    lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                                    System.out.println("Đã duyệt thành công cho mã phổng vấn " + lichPhongVan.getMaCaPhongVan());
                                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                                    giaoDien();
                                }
                            }
                        }
                    }



                    break;
                case 2:
                    QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                    System.out.println("Bạn muốn xét thay đổi lịch phổng vấn nào (Nhập ID)");
                    System.out.println("Nếu muốn thoát hãy ấn phím 1 !!");

                    String idPV = ScannerUtils.inputString();

                    if (idPV.equals("1")){
                        giaoDien();
                    }

                    else{
                        LichPhongVan lichPhongVan = QLLichPhongVan.timKiemLichPhongVanTheoMa(idPV);
                        if (lichPhongVan == null){
                            System.out.println("Mã không tồn tại !!!");
                            giaoDien();
                        }
                        else{
                            System.out.printf("Bạn đã chọn lịch phổng vấn %s \n", lichPhongVan.getMaCaPhongVan());
                            System.out.println("Hãy chọn trạng thái bạn muốn thay đổi :33");
                            System.out.println("1. Chờ duyệt");
                            System.out.println("2. Chờ phổng vấn");
                            System.out.println("3. Đã phổng vấn");
                            System.out.println("4. Hủy");
                            System.out.println("Ấn bất cứ nút nào khác để thoát về màn hình chính !!");



                            String case2Choice = ScannerUtils.inputString();

                            if (case2Choice.equals("1")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_DUYET);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                            }
                            else if (case2Choice.equals("2")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.CHO_PHONGVAN);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());

                            }
                            else if (case2Choice.equals("3")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.DA_PHONGVAN);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());

                            }
                            else if (case2Choice.equals("4")){
                                lichPhongVan.setTrangThaiPhongVan(TrangThaiPhongVan.HUY);
                                System.out.println("Đã thay đổi thành công !!");
                                QLLichPhongVan.inDSLichPhongVan(QLLichPhongVan.getDsLichPhongVan());
                            }
                        }
                    }



                    break;

                case 3:
                    QLKetQuaPhongVan.inDSKetQuaPhongVan(QLKetQuaPhongVan.getDsKetQuaPhongVan());
                    System.out.println("Bạn có muốn thay đổi ca phổng vấn nào ? (Mã ID)");
                    System.out.println("Ấn phím 1 để thoát ra màn hình chính ");

                    String inputCase3 = ScannerUtils.inputString();
                    if (!inputCase3.equals("1")){
                        KetQuaPhongVan ketQuaPhongVan = QLKetQuaPhongVan.timKetQuaPhongVanTheoMa(inputCase3);
                        if (ketQuaPhongVan != null){
                            // Bạn đã thử liên hệ chưa ? Họ nói gì ?
                            System.out.println("1. Đã liên hệ"); //Đã liên hệ và họ muốn ghi danh
                            System.out.println("2. Đã từ chối");
                            System.out.println("Ấn bất cứ số nào khác 2 số trên để thoát !!");
                            int case3choice = ScannerUtils.inputInt();
                            if (case3choice == 1){
                                System.out.println("");
                            }
                            else if (case3choice == 2){
                                ketQuaPhongVan.setLienHe(LienHe.DaTuChoi);
                            }
                        }
                        else{
                            System.out.println("Không tìm thấy mã bạn yêu cầu !!");
                        }
                    }
                    giaoDien();
                    break;

                case 5:
                    //Form.logout();
                    break;

                case 6:
                    exit();
                    break;
            }
        } while (true);
    }
}
