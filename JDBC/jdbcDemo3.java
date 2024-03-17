import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcDemo3 {
    public static void main(String[] args) throws SQLException {
        //1、建立数据源
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/java111?CharacterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");


        //2、建立连接
        Connection connection=(Connection) dataSource.getConnection();


        //3、建立sql
        String str="select *from test";
        PreparedStatement preparedStatement=connection.prepareStatement(str);

        //4、执行sql
        ResultSet resultSet=preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id=resultSet.getInt("id");
            System.out.println("id="+id);
            String name=resultSet.getString("name");
            System.out.println("name="+name);
        }

        //5、释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
