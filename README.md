# OOP_Project

Những thứ cần làm trong project
a) Nhân vật
	- Cá nhân *
		- void xemDanhSachLopHocDangHoc()
		- void xemDanhSachLopHocKhaiGiang()
		- void xemChuongTrinhHoc() *
		- void xemDanhSachGiangVien

	- Câ nhân trung tâm *
		- 

	- Học viên


	- Khách hàng

	- Trợ giảng * 

		+ public void xemLichDayKhoaHienTai() 

    		+ public void xemLichDayKhoaSapKhaiGiang() 

    		+ public void xemDanhSachHocVienTheoLop(String maLop) 


	- Giảng viên *

		+ public void xemlichPhongVan();




	- Cộng tác viên *
		+ public void xemDSLopTheoKhoa(String maKhoa);
		+ public void xemDSLopTheoKhoa(KhoaKhaiGiang khoa);
		+ public void xemDSLopTheoChuongTrinh(ChuongTrinhHoc chuongTrinhHoc);
		+ public void xemDSHocVienTheoLop(LopHoc lopHoc);
		+ public void thongKeHocVienTheoKhoa(String maKhoa)
		+ public void xemDSHocVienConNo();
		+ public boolean datLichPhongVan();
		+ public boolean chuyenLopChoHocVien();



	- Quản lý *
		+ 

	- Giám đốc *
		+

b) Hệ giống giáo dục
	a) THời gian
		- Thứ *
		- Thời gian *
		- Giờ * 
		- Ca học *
		
	- Chương trình học *
	
	- Cơ sở*
	
	- Phòng học*

	- Thời khóa biểu
	- Khóa khai giảng*
	- HocVienLopHoc
	- Lớp học *
	- Trạng thái lớp*
	- Lịch phổng vấn 
	- Trạng thái phổng vấn
	- Kết quả phổng vấn
	- Yêu cầu đăng ký
	- Biên lai 
	- Trạng thái đăng ký 
c) Quản lý đối tượng 

 	- Quản lý giảng viên *
		+ loadDuLieu*
		+ save Dữ liệu *
		+ void inDSGiangVien(List dsGV) *
		+ List<GiangVien> timKiemGiangVienTheoTen(String ten) *
		+ GiangVien timKiemGiangVienTheoId(String id)*
		+ GiangVien timKiemGiangVienTheoEmail(String email)*
		+ GiangVien timKiemGiangVienTheoSDT(String sdt)*
		+ GiangVien timKiemGiangVienTheoTrangThai(boolean trangTha*

	- Quản lý trợ giảng *
		+ loadDuLieu*
		+ save Dữ liệu *
		+ void inDSTroGiang(List dsTG) *
		+ List<TroGiang> timKiemTroGiangTheoTen(String ten)*
		+ TroGiang timKiemTroGiangTheoId(String id)*
		+ TroGiang timKiemTroGiangTheoEmail(String email)*
		+ TroGiang timKiemTroGiangTheoSDT(String sdt)*
		+ TroGiang timKiemTroGiangTheoTrangThai(boolean trangThai)*




	- QL yêu cầu đăng ký
	- Quản lý học viên


	- QL phổng vấn


	- QL lớp học *
		+ In danh sách lớp đọc *
		+ LopHoc tìm kiếm theo mã lớp *
		+ LopHoc tim kiếm theo tên lớp*
		+ List<LopHoc> tìm kiếm theo chuong trinh*
		+ List<LopHoc> tim kiếm theo khóa*
		+ List<LopHoc> tim kiếm theo trạng thái*

	- QL thời khóa biểu
		- void inThoiKhoaBieu(ArrayList<ThoiKhoaBieu< dsTKB)
		-List<ThoiKhoaBieu> timKIemTheoLop(LopHoc lopHoc) 
		-List<ThoiKhoaBieu> timKiemTheoCaHoc(CaHoc caHoc) 
		-List<ThoiKhoaBieu> timKiemTheoNgayThang(NgayThang ngayThang)
		-List<ThoiKhoaBieu> timKiemTheoGiangVien(GiangVien gv)
		-LIst<ThoiKhoaBieu> timKiemTheoTroGiang(TroGiang troGiang) 

	- QL khóa khai giảng*
		+ Đọc dữ liệu từ file ra
		+ Lưu dữ liệu vào file
		+ In danh sách khóa khai giảng (List danhSach) *
		+ Tìm kiếm theo mã khoá (Stirng ma) *
		+ Tìm kiếm theo tên khóa (String ten) *
		+ Tìm kiếm khóa bắt đầu theo năm (int nam) *
		+ Tìm kiếm khóa bắt đầu theo tháng (int thang, int nam) *
		+ Tìm kiếm khóa kết thúc theo năm (int nam) *
		+ Tìm kiếm khóa kết thúc theo tháng (int thang, int nam) *


	- QL biên lai
	- QL tài khoản *
		+ Tìm tài khoản theo Username*
		+ Tìm tài khoản theo trạng thái*
		+ In danh sách tài khoản theo yêu cầu*
	- QL Phong Hoc *
		+ In danh sách phòng *
		+ Tìm phòng theo trạng thái *
		+ Tìm phòng theo cơ sở *
		+ Tìm phòng theo mã phòng *
	- QL Co so *
		+ In danh sách các cơ sở *
		+ Tìm theo mã cơ sở*
		+ Tìm theo tên cơ sở*
	- QL chương trình học *
		+ In danh sách chương trình học *
		+ Tìm kiếm chương trình học theo mã *
		+ Tìm kiếm chương trình học theo thể loại *
	- QL lý ca học *
		+ inDSCaHoc *
		+ timCaHocTheoThu(Thu thu) *
	- QL HocVienLopHoc *
		+ int Đếm số học viên của lớp (LopHoc lopHoc)
		+ Danh sách học viên theo Lớp (LopHoc lopHoc)
		+ Tìm danh sách lớp học theo học viên (HocVIen)
d) Tài khoản

	+ Tài khoản
