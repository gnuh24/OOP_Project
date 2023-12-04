package Menu.GiaoDien;

import Menu.LoadDuLieu;
import Utils.ScannerUtils;

public abstract class GiaoDien {
    public abstract void giaoDien();

    public void backTo(){
        System.out.println("Ấn bất cứ nút nào để trở lại màn hình chính !!");
        ScannerUtils.inputString();
    }

    public void exit(){
        System.out.println("Bạn chuẩn bị thoát chương trình");
        System.out.println("Hẹn gặp lại bạn vào 1 ngày không xa :3");
        LoadDuLieu.saving();
        System.exit(0);
    }
}
