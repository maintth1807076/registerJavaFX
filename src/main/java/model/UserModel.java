package model;
import java.sql.*;
import entity.User;

public class UserModel {
    private Connection connection;
    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/myschool?user=root&password=");
        }
    }
    public boolean insert(User obj){
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (username, password, fullName, email, phone) values (?,?,?,?,?)");
            preparedStatement.setString(1,obj.getUsername());
            preparedStatement.setString(2,obj.getPassword());
            preparedStatement.setString(3,obj.getFullName());
            preparedStatement.setString(4,obj.getEmail());
            preparedStatement.setString(5,obj.getPhone());
            preparedStatement.execute();
        } catch (Exception ex){
            System.out.println("Có lỗi xảy ra. Error: " + ex.getMessage());
        }
        return false;
    }
}
