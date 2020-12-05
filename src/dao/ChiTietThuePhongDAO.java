package dao;

import java.sql.SQLException;

import model.ChiTietThuePhong;

public interface ChiTietThuePhongDAO extends BaseDao<ChiTietThuePhong>{
	ChiTietThuePhong insertBook(ChiTietThuePhong t) throws SQLException;
}
