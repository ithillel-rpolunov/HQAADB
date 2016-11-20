import java.sql.*;

/**
 * Created by Vasya on 20.11.2016.
 */
public class ConnectToDb {

    private static final String DBNAME = "test";

    public void connect() throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBNAME, "root", "root");

        Statement statement = connection.createStatement();

        statement.execute("DROP TABLE customer");

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS  customer  (\n" +
                "   cust_id  int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
                "   fed_id  varchar(12) NOT NULL,\n" +
                "   cust_type_cd  varchar(12) NOT NULL,\n" +
                "   address  varchar(30) DEFAULT NULL,\n" +
                "   city  varchar(20) DEFAULT NULL,\n" +
                "   state  varchar(20) DEFAULT NULL,\n" +
                "   postal_code  varchar(10) DEFAULT NULL,\n" +
                "  PRIMARY KEY ( cust_id )\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;");

        statement.executeUpdate("INSERT INTO  customer VALUES\n" +
                "\t(1, '111-11-1111', 'I', '47 Mockingbird Ln', 'Lynnfield', 'MA', '01940'),\n" +
                "\t(2, '222-22-2222', 'I', '372 Clearwater Blvd', 'Woburn', 'MA', '01801'),\n" +
                "\t(3, '333-33-3333', 'I', '18 Jessup Rd', 'Quincy', 'MA', '02169'),\n" +
                "\t(4, '444-44-4444', 'I', '12 Buchanan Ln', 'Waltham', 'MA', '02451'),\n" +
                "\t(5, '555-55-5555', 'I', '2341 Main St', 'Salem', 'NH', '03079'),\n" +
                "\t(6, '666-66-6666', 'I', '12 Blaylock Ln', 'Waltham', 'MA', '02451'),\n" +
                "\t(7, '777-77-7777', 'I', '29 Admiral Ln', 'Wilmington', 'MA', '01887'),\n" +
                "\t(8, '888-88-8888', 'I', '472 Freedom Rd', 'Salem', 'NH', '03079'),\n" +
                "\t(9, '999-99-9999', 'I', '29 Maple St', 'Newton', 'MA', '02458'),\n" +
                "\t(10, '04-1111111', 'B', '7 Industrial Way', 'Salem', 'NH', '03079'),\n" +
                "\t(11, '04-2222222', 'B', '287A Corporate Ave', 'Wilmington', 'MA', '01887'),\n" +
                "\t(12, '04-3333333', 'B', '789 Main St', 'Salem', 'NH', '03079'),\n" +
                "\t(13, '04-4444444', 'B', '4772 Presidential Way', 'Quincy', 'MA', '02169');");

        ResultSet resultSet = statement.executeQuery("select * from customer");
        System.out.println("ResultSet output:");

        while  (resultSet.next()){
            System.out.println(resultSet.getString("cust_id") + " | " + resultSet.getString("city") + resultSet.getString(2));
        }




    }

}
