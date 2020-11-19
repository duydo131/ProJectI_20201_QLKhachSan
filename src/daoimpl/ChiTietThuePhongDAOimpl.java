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
		String sql = "select * from chiTietThuePhong";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getList(resultSet);
	}

	@Override
	public ChiTietThuePhong findById(int id) throws SQLException {
		ChiTietThuePhong tb = null;
        String sql = "select * from chiTietThuePhong where ID = ?";
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
        String sql = "insert into chiTietThuePhong (ID_P) values (?);";
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
        String sql = "update chiTietThuePhong set ID_P = ? where ID = ?;";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID_P());
        preparedStatement.setLong(2, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}

	@Override
	public boolean delete(ChiTietThuePhong t) throws SQLException {
		boolean result = false;
        String sql = "delete from chiTietThuePhong where ID = ?";
        PreparedStatement preparedStatement = myConnection.prepareUpdate(sql);
        preparedStatement.setLong(1, t.getID());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) result = true;
        return result;
	}
}