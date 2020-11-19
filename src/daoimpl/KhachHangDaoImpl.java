package daoimpl;

import dao.KhachHangDao;
import model.KhachHang;
import model.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDaoImpl implements KhachHangDao {
    MyConnection myConnection = new MyConnection();
    public KhachHang getObject(ResultSet resultSet) throws SQLException {
        KhachHang khachHang  = null;
        khachHang = new KhachHang(resultSet.getString("ma_hk"),
                resultSet.getString("ten_kh"),
                resultSet.getString("cmnd"),
                resultSet.getBoolean("gioi_tinh"),
                resultSet.getString("dia_chi"),
                resultSet.getString("dien_thoai"),
                resultSet.getString("quoc_tich"),
                resultSet.getDate("ngay_sinh"),
                resultSet.getString("nghe_nghiep"),
                resultSet.getString("phan_loai_kh"),
                resultSet.getString("ten_to_chuc"));
        
		khachHang.setActive(resultSet.getBoolean("active"));

        return khachHang;
    }

    public List<KhachHang> getList(ResultSet resultSet) throws SQLException {
        List<KhachHang> list = new ArrayList<KhachHang>();
        while (resultSet.next()){
            KhachHang khachHang = getObject(resultSet);
            if (khachHang!=null) list.add(khachHang);
        }
        return list;
    }

    public List<KhachHang> findAll() throws SQLException {
        String sql = "selete * from khach_hang";
        PreparedStatement preparedStatement = myConnection.prepare(sql);
        return  getList(preparedStatement.executeQuery());
    }

    public KhachHang findById(int id) throws SQLException {
        return null;
    }

    public KhachHang insert(KhachHang khachHang) throws SQLException {
        return null;
    }

    public boolean update(KhachHang khachHang) throws SQLException {
        return false;
    }

	@Override
	public boolean delete(KhachHang t) throws SQLException {
		t.setActive(false);
		return update(t);
	}
}
