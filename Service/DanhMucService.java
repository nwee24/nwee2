package Service;

import Model.DanhMuc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DanhMucService extends SQLServerService{

    public Vector<DanhMuc> DocToanBoDanhMuc(){
        Vector<DanhMuc> vec= new Vector<DanhMuc>();
        try{
            String sql="select * from DanhMuc where IsDeleted =0";
            Statement statement= conn.createStatement();
            ResultSet result= statement.executeQuery(sql);
            while (result.next()){
                DanhMuc dm= new DanhMuc();
                dm.setMaDM(result.getString(1));
                dm.setTenDM(result.getString(2));
                dm.setIsDelete(0);
                vec.add(dm);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return vec;
    }

    public int themDanhMuc(DanhMuc dm){
        int result= 0;
        try {
            String sql = "INSERT INTO DanhMuc VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,dm.getMaDM());
            preparedStatement.setString(2, dm.getTenDM());
            preparedStatement.setInt(3,0);
            return preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public int capNhatDanhMuc(DanhMuc danhMuc){
        try{
            String sql = "UPDATE DanhMuc SET TenDM= ? WHERE MaDM= ?";
            PreparedStatement preparedStatement= conn.prepareStatement(sql);
            preparedStatement.setString(1, danhMuc.getTenDM() );
            preparedStatement.setString(2, danhMuc.getMaDM());
            return preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
