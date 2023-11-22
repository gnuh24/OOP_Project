package ThoiGian;


public class Gio {
    int gio;
    int phut;

    public Gio() {
    }

    public Gio(int gio, int phut) {
        this.gio = gio;
        this.phut = phut;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    @Override
    public String toString(){
        return gio+"h"+phut+"p";
    }
}
