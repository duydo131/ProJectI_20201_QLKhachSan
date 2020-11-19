use ProjectI_QLKhachSan;

Create table khachHang(
	ID bigint primary key auto_increment,
    TenKH nvarchar(255) not null,
    CMND char(30) not null,
    GioiTinh boolean not null,
    DiaChi nvarchar(255),
    DienThoai char(11),
    QuocTich nvarchar(50),
    NgaySinh Date,
    Nghe nvarchar(50)
);

create table login(
	User char(30) not null,
    Password char(30) not null,
    ID_NV bigint not null
);

create table thietbi(
	ID bigint primary key auto_increment,
    TenTB nvarchar(50) not null,
    Gia bigint not null
);

create table danhSachThietBi(
	ID_P bigint not null,
    ID_TB bigint not null,
    SoLuong bigint default 0
);

create table hoaDon(
	ID bigint primary key auto_increment,
    ID_TP bigint not null,
    NgayLap datetime not null,
    Thue bigint not null,
    PhiPhatSinh bigint default 0
);

create table thuePhong(
	ID bigint primary key auto_increment,
		ID_KH bigint not null,
		NgayDangKi datetime not null,
		NgayDen datetime not null,
		NgayHenDi datetime not null,
		NgayDi datetime,
		TienCoc bigint default 0
);

create table phong(
	ID bigint primary key auto_increment,
    LoaiPhong char(5),
    GiaPhong bigint not null,
    TinhTrang nvarchar(50) default N''
);

create table nhanVien(
	ID bigint primary key auto_increment,
    Ten nvarchar(50) not null,
    GioiTinh boolean not null,
    NgaySinh Date not null,
    ChuyenMon nvarchar(50),
    CMND char(30) not null,
    DienThoai char(20)	
);

create table chiTietThuePhong(
	ID bigint primary key auto_increment,
    ID_P bigint not null
);

create table connect(
	ID_TP bigint not null,
    ID_chiTiet bigint not null
); 

alter table login add constraint login_NV foreign key (ID_NV) references nhanVien(ID);
alter table danhSachThietBi add constraint ds_TB foreign key (ID_TB) references thietbi(ID);
alter table hoaDon add constraint hd_tp foreign key (ID_TP) references thuePhong(ID);
alter table thuePhong add constraint tp_KH foreign key (ID_KH) references khachHang(ID);
alter table chiTietThuePhong add constraint ct_p foreign key (ID_P) references phong(ID);
alter table connect add constraint cn_TP foreign key (ID_TP) references thuePhong(ID);
alter table connect add constraint cn_ct foreign key (ID_chiTiet) references chiTietThuePhong(ID);