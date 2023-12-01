package Menu.Actor;

import QuanLyDoiTuong.QLChuongTrinhHoc;
import Utils.ScannerUtils;

public class ActorGiamDoc extends ActorQuanLy{
    public void thayDoiHocPhi(){
        QLChuongTrinhHoc.inChuongTrinhHoc(QLChuongTrinhHoc.getDsChuongTrinhHoc());
        System.out.println("Nhập mã chương trình muốn thay đổi học phí");
        String maChuongTrinh=ScannerUtils.inputString();
        System.out.println("Nhập học phí mới mới");
        int hocPhi=ScannerUtils.inputInt();
        QLChuongTrinhHoc.timKiemTheoMa(maChuongTrinh).setHocPhi(hocPhi);
    }
}
