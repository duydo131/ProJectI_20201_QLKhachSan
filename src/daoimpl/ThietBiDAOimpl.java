package daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ThietBiDAO;
import model.MyConnection;
import model.ThietBi;

public class ThietBiDAOimpl implements ThietBiDAO{
	private MyConnection myConnection = new MyConnection();
	
	@Override
	public ThietBi getObject(ResultSet resultSet) throws SQLException {
		ThietBi tb = new ThietBi();
		tb.setID(resultSet.getLong("ID"));
		tb.setTenTB(resultSet.getString("TenTB"));
		tb.setGia(resultSet.getLong("Gia"));
		return tb;
	}

	@Override
	public List<ThietBi> getList(ResultSet resultSet) throws SQLException {
		List<ThietBi> list = new ArrayList<>();
        while (resultSet.next()) {
            ThietBi tb = getObject(resultSet);
            if (tb != null) list.add(tb);
        }
        return list;
	}

	@Override
	public List<ThietBi> findAll() throws SQLException {
		String sql = "select * from thietbi";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getList(resultSet);
	}

	@Override
	public ThietBi findById(int id) throws SQLException {
		ThietBi tb = null;
        String sql = "select * from thietbi where ID = ?";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tb = getObject(resultSet);
        }
        return tb;
	}

	@Override
	public ThietBi insert(ThietBi t) throws SQLException {
		ThietBi tb = null;
        String sql = "insert into thietbi (TenTb, Gia) values (?,?);";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setString(1, t.getTenTB());
        preparedStatement.setLong(2, t.getGia());
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
	public boolean update(ThietBi t) throws SQLException {
		boolean result = false;
        String sql = "update thietbi set TenTB = ?, Gia = ? where ID = ?;";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setString(1, t.getTenTB());
        preparedStatement.setLong(2, t.getGia());
        preparedStatement.setLong(3, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}

	@Override
	public boolean delete(ThietBi t) throws SQLException {
		boolean result = false;
        String sql = "delete from thietbi where ID = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}

}