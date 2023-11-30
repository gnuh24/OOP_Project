package Menu.Actor;

import Utils.ScannerUtils;

public class ActorQuanLy extends ActorCongTacVien{
        public void giaoDien(){
        int choice;
        do{
            System.out.println("-----------------------------------------------CHÀO MỪNG BẠN ĐÃ ĐẾN VỚI TRUNG TÂM ANH NGỮ THUG88-----------------------------------------------");
            System.out.println("1. Xem thời khóa biểu các lớp đang học và sắp khai giảng");
            System.out.println("2. Xem điểm");
            System.out.println("3. Đóng học phí");
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
                    break;
                case 2:
                    break;

                case 3:
                    break;

                case 5:
                    break;

                case 6:
                    exit();
                    break;
            }
        } while (true);
    }
}
