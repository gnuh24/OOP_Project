package HeThongGiaoDuc.LopHoc;

import HeThongGiaoDuc.ChuongTrinhHoc.ChuongTrinhHoc;
import HeThongGiaoDuc.ChuongTrinhHoc.KhoaKhaiGiang;
import HeThongGiaoDuc.CoSoVatChat.PhongHoc;
import QuanLyDoiTuong.QLLopHoc;
import ThoiGian.CaHoc;
import NguoiDung.User;

import java.util.ArrayList;

public class LopHoc {
  String maLop;
  String tenLop;
  TrangThaiLop trangThai;
  ArrayList<CaHoc> caHocMacDinh;
  KhoaKhaiGiang khoa;
  ChuongTrinhHoc chuongTrinh;
  PhongHoc phongHocMacDinh;
  User giangVien;
  User troGiang;

  public LopHoc() {
  }


  //Dùng khi Quản lý muốn tạo lớp
  public LopHoc(String tenLop, KhoaKhaiGiang khoa, ChuongTrinhHoc chuongTrinh) {
    this.tenLop = tenLop;
    this.khoa = khoa;
    this.chuongTrinh = chuongTrinh;
    this.maLop = autoIncreament();
    this.trangThai = TrangThaiLop.Cho_Sap_Xep;
  }

  private String autoIncreament(){
    int size = QLLopHoc.getDsLopHoc().size() + 1;
    return  "LH" + size;
  }


  //Dùng để đọc từ file ra

  public LopHoc(String maLop, String tenLop, TrangThaiLop trangThai, ArrayList<CaHoc> caHocMacDinh,
                KhoaKhaiGiang khoa, ChuongTrinhHoc chuongTrinh, PhongHoc phongHocMacDinh,
                User giangVien, User troGiang) {
    this.maLop = maLop;
    this.tenLop = tenLop;
    this.trangThai = trangThai;
    this.caHocMacDinh = caHocMacDinh;
    this.khoa = khoa;
    this.chuongTrinh = chuongTrinh;
    this.phongHocMacDinh = phongHocMacDinh;
    this.giangVien = giangVien;
    this.troGiang = troGiang;
  }

  public String getMaLop() {
    return maLop;
  }

  public void setMaLop(String maLop) {
    this.maLop = maLop;
  }

  public String getTenLop() {
    return tenLop;
  }

  public void setTenLop(String tenLop) {
    this.tenLop = tenLop;
  }

  public TrangThaiLop getTrangThai() {
    return trangThai;
  }

  public void setTrangThai(TrangThaiLop trangThai) {
    this.trangThai = trangThai;
  }

  public ArrayList<CaHoc> getCaHocMacDinh() {
    return caHocMacDinh;
  }

  public void setCaHocMacDinh(ArrayList<CaHoc> caHocMacDinh) {
    this.caHocMacDinh = caHocMacDinh;
  }

  public KhoaKhaiGiang getKhoa() {
    return khoa;
  }

  public void setKhoa(KhoaKhaiGiang khoa) {
    this.khoa = khoa;
  }

  public ChuongTrinhHoc getChuongTrinh() {
    return chuongTrinh;
  }

  public void setChuongTrinh(ChuongTrinhHoc chuongTrinh) {
    this.chuongTrinh = chuongTrinh;
  }

  public PhongHoc getPhongHocMacDinh() {
    return phongHocMacDinh;
  }

  public void setPhongHocMacDinh(PhongHoc phongHocMacDinh) {
    this.phongHocMacDinh = phongHocMacDinh;
  }

  public User getGiangVien() {
    return giangVien;
  }

  public void setGiangVien(User giangVien) {
    this.giangVien = giangVien;
  }

  public User getTroGiang() {
    return troGiang;
  }

  public void setTroGiang(User troGiang) {
    this.troGiang = troGiang;
  }
}
