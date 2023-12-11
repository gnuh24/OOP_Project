package HeThongGiaoDuc.CoSoVatChat;
import HeThongGiaoDuc.LopHoc.LopHoc;
import QuanLyDoiTuong.QLLopHoc;
import ThoiGian.CaHoc;
import java.util.ArrayList;

public class PhongHoc {
    private String maPhongHoc;
    private boolean trangThai;
    private CoSo coSoTrucThuoc;
    public PhongHoc(){
    }
    public PhongHoc(String maPhongHoc, boolean trangThai, CoSo coSoTrucThuoc){
        this.maPhongHoc=maPhongHoc;
        this.trangThai=trangThai;
        this.coSoTrucThuoc=coSoTrucThuoc;
    }

    public boolean isBusy(CaHoc caHoc) {
        ArrayList<LopHoc> dsLopHocCaNhan = QLLopHoc.timKiemLopTheoPhongHoc(this.maPhongHoc, true);
        for (LopHoc lopHoc : dsLopHocCaNhan) {
            CaHoc caHoc1 = lopHoc.getCaHocMacDinh().get(0);
            CaHoc caHoc2 = lopHoc.getCaHocMacDinh().get(1);
            if (caHoc1.equal(caHoc) || caHoc2.equal(caHoc)) {
                return true;
            }
        }

        return false;
    }

    public String getMaPhongHoc() {
        return maPhongHoc;
    }
    public void setMaPhongHoc(String maPhongHoc) {
        this.maPhongHoc = maPhongHoc;
    }
    public boolean getTrangThai(){
        return this.trangThai;
    }
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    public CoSo getCoSoTrucThuoc() {
        return coSoTrucThuoc;
    }
    public void setCoSoTrucThuoc(CoSo coSoTrucThuoc) {
        this.coSoTrucThuoc = coSoTrucThuoc;
    }
}
