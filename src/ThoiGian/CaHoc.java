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

    public boolean equal(CaHoc caHoc) {
        return caHoc.getThu().equals(this.getThu())
        && caHoc.getGioVaoHoc().equals(this.getGioVaoHoc())
        && caHoc.getGioTanHoc().equals(this.getGioTanHoc());
    }

    @Override
    public String toString() {
        String temp = Thu.toString(thu) + ": " + gioVaoHoc + " -> " + gioTanHoc;

        if (thu != null && gioVaoHoc != null && gioTanHoc != null) {
            if (thu.equals(Thu.ChuNhat)) {
                return temp;
            }

            return "Thứ " + temp;
        }

        return "Chưa cập nhật";
    }
}
