package HeThongGiaoDuc.CoSoVatChat;

public class CoSo {
    private String maCoSo;
    private String tenCoSo;
    private String diaChi;
    public CoSo(){
    }
    public CoSo(String maCoSo, String tenCoSo, String diaChi){
        this.maCoSo=maCoSo;
        this.tenCoSo=tenCoSo;
        this.diaChi=diaChi;
    }
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getMaCoSo() {
        return maCoSo;
    }
    public void setMaCoSo(String maCoSo) {
        this.maCoSo = maCoSo;
    }
    public String getTenCoSo() {
        return tenCoSo;
    }
    public void setTenCoSo(String tenCoSo) {
        this.tenCoSo = tenCoSo;
    }
}
