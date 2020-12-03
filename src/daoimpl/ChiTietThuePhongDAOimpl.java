package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietThuePhongDAO;
import model.MyConnection;
import model.ChiTietThuePhong;

public class ChiTietThuePhongDAOimpl implements ChiTietThuePhongDAO{
	private MyConnection myConnection = new MyConnection();
	
	@Override
	public ChiTietThuePhong getObject(ResultSet resultSet) throws SQLException {
		ChiTietThuePhong tb = new ChiTietThuePhong();
		tb.setID(resultSet.getLong("ID"));
		tb.setID_P(resultSet.getLong("ID_P"));
		tb.setGhiChu(resultSet.getString("GhiChu"));
		tb.setNgayTraPhong(resultSet.getDate("NgayTraPhong"));
		tb.setTienPhat(resultSet.getLong("TienPhat"));
		tb.setTrangThai(resultSet.getString("TrangThai"));
		tb.setActive(resultSet.getBoolean("active"));
		return tb;
	}

	@Override
	public List<ChiTietThuePhong> getList(ResultSet resultSet) throws SQLException {
		List<ChiTietThuePhong> list = new ArrayList<>();
        while (resultSet.next()) {
            ChiTietThuePhong tb = getObject(resultSet);
            if (tb != null) list.add(tb);
        }
        return list;
	}

	@Override
	public List<ChiTietThuePhong> findAll() throws SQLException {
		String sql = "select * from chiTietThuePhong where and active = true";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getList(resultSet);
	}

	@Override
	public ChiTietThuePhong findById(int id) throws SQLException {
		ChiTietThuePhong tb = null;
        String sql = "select * from chiTietThuePhong where ID = ? and active = true";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tb = getObject(resultSet);
        }
        return tb;
	}

	@Override
	public ChiTietThuePhong insert(ChiTietThuePhong t) throws SQLException {
		ChiTietThuePhong tb = null;
        String sql = "insert into chiTietThuePhong (ID_P, GhiChu, NgayTraPhong, TienPhat, TrangThai) values (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID_P());
        int rs = preparedStatement.executeUpdate();

        if (rs > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                tb = findById((int) resultSet.getLong(1));
            }
        }
        return tb;
	}

	@Override
	public boolean update(ChiTietThuePhong t) throws SQLException {
		boolean result = false;
        StringBuilder sql = new StringBuilder("update chiTietThuePhong set ID_P = ?, GhiChu = ?, NgayTraPhong = ?, TienPhat = ?, ");
        sql.append("TrangThai = ?, active = ? where ID = ?;");
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql.toString());
        preparedStatement.setLong(1, t.getID_P());
        preparedStatement.setBoolean(2, t.getActive());
        preparedStatement.setLong(3, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}

	@Override
	public boolean delete(ChiTietThuePhong t) throws SQLException {
		t.setActive(false);
		return update(t);
	}
}
