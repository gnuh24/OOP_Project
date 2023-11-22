package HeThongGiaoDuc.CoSoVatChat;
public class PhongHoc {
    String maPhongHoc;
    boolean trangThai;
    CoSo coSoTrucThuoc;
    public PhongHoc(){
    }
    public PhongHoc(String maPhongHoc, boolean trangThai, CoSo coSoTrucThuoc){
        this.maPhongHoc=maPhongHoc;
        this.trangThai=trangThai;
        this.coSoTrucThuoc=coSoTrucThuoc;
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
