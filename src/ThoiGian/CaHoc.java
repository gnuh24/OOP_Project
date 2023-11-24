package ThoiGian;

import java.time.LocalTime;

public class CaHoc {
    Thu thu;
    LocalTime gioVaoHoc;
    LocalTime gioTanHoc;

    public CaHoc() {
    }

    public CaHoc(Thu thu, LocalTime gioVaoHoc, LocalTime gioTanHoc) {
        this.thu = thu;
        this.gioVaoHoc = gioVaoHoc;
        this.gioTanHoc = gioTanHoc;
    }

    public LocalTime getGioVaoHoc() {
        return gioVaoHoc;
    }

    public void setGioVaoHoc(LocalTime gioVaoHoc) {
        this.gioVaoHoc = gioVaoHoc;
    }

    public LocalTime getGioTanHoc() {
        return gioTanHoc;
    }

    public void setGioTanHoc(LocalTime gioTanHoc) {
        this.gioTanHoc = gioTanHoc;
    }

    public Thu getThu() {
        return thu;
    }

    public void setThu(Thu thu) {
        this.thu = thu;
    }

}
