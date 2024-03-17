import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcDemo2 {

    public static void main(String[] args) throws SQLException {
        //1、创建数据源
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/java111?CharacterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        //2、建立连接
        Connection connection=(Connection) dataSource.getConnection();

        //输入id及name
        Scanner sc=new Scanner(System.in);
        System.out.println("输入id：");
        int id=sc.nextInt();
        System.out.println("输入name：");
        String name=sc.next();

        //3、建立sql语句
        String str="update test set name=? where id=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(str);
        preparedStatement.setInt(2,id);
        preparedStatement.setString(1,name);


        //4、执行sql
        int n=preparedStatement.executeUpdate();
        System.out.println(n);

        //5、释放资源
        preparedStatement.close();
        connection.close();
    }
}
