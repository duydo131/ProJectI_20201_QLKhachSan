package daoimpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ThuePhongDAO;
import model.MyConnection;
import model.ThuePhong;

public class ThuePhongDAOimpl implements ThuePhongDAO{
	private MyConnection myConnection = new MyConnection();
	
	@Override
	public ThuePhong getObject(ResultSet resultSet) throws SQLException {
		ThuePhong tb = new ThuePhong();
		tb.setID(resultSet.getLong("ID"));
		tb.setID_KH(resultSet.getLong("TD_KH"));
		tb.setNgayDangKi(resultSet.getDate("NgayDangKi"));
		tb.setNgayDen(resultSet.getDate("NgayDen"));
		tb.setNgayDi(resultSet.getDate("NgayDi"));
		tb.setNgayHenDi(resultSet.getDate("NgayHenDi"));
		tb.setTienCoc(resultSet.getLong("TienCoc"));
		tb.setActive(resultSet.getBoolean("active"));
		return tb;
	}

	@Override
	public List<ThuePhong> getList(ResultSet resultSet) throws SQLException {
		List<ThuePhong> list = new ArrayList<>();
        while (resultSet.next()) {
            ThuePhong tb = getObject(resultSet);
            if (tb != null) list.add(tb);
        }
        return list;
	}

	@Override
	public List<ThuePhong> findAll() throws SQLException {
		String sql = "select * from thuePhong where active = true";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getList(resultSet);
	}

	@Override
	public ThuePhong findById(int id) throws SQLException {
		ThuePhong tb = null;
        String sql = "select * from thuePhong where ID = ? and active = true";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tb = getObject(resultSet);
        }
        return tb;
	}

	@Override
	public ThuePhong insert(ThuePhong t) throws SQLException {
		ThuePhong tb = null;
        String sql = "insert into thuePhong (ID_KH, NgayDangKi, NgayDen, NgayHenDi, NgayDi, TienCoc) values (?,?,?,?,?,?);";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID_KH());
        preparedStatement.setDate(2, new java.sql.Date(((Date)t.getNgayDangKi()).getTime()));
        preparedStatement.setDate(3, new java.sql.Date(((Date)t.getNgayDen()).getTime()));
        preparedStatement.setDate(4, new java.sql.Date(((Date)t.getNgayHenDi()).getTime()));
        preparedStatement.setDate(5, new java.sql.Date(((Date)t.getNgayDi()).getTime()));
        preparedStatement.setLong(6, t.getTienCoc());
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
	public boolean update(ThuePhong t) throws SQLException {
		boolean result = false;
        String sql = "update thuePhong set ID_KH = ?, NgayDangKi = ?, NgayDen = ?, NgayHenDi = ?, "
        		+ "NgayDi = ?, TienCoc = ?, active = ? where ID = ?;";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID_KH());
        preparedStatement.setDate(2, new java.sql.Date(((Date)t.getNgayDangKi()).getTime()));
        preparedStatement.setDate(3, new java.sql.Date(((Date)t.getNgayDen()).getTime()));
        preparedStatement.setDate(4, new java.sql.Date(((Date)t.getNgayHenDi()).getTime()));
        preparedStatement.setDate(5, new java.sql.Date(((Date)t.getNgayDi()).getTime()));
        preparedStatement.setLong(6, t.getTienCoc());
        preparedStatement.setBoolean(7,  t.getActive());
        preparedStatement.setLong(8, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}

	@Override
	public boolean delete(ThuePhong t) throws SQLException {
		t.setActive(false);
		return update(t);
	}
}
