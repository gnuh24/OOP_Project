package Menu.Actor;

import Menu.LoadDuLieu;

public abstract class Actor {
    public abstract void giaoDien();

    public void exit(){
        System.out.println("Bạn chuẩn bị thoát chương trình");
        System.out.println("Hẹn gặp lại bạn vào 1 ngày không xa :3");
        LoadDuLieu.saving();
        System.exit(0);
    }
}
