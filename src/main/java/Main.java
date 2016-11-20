import java.sql.SQLException;

/**
 * Created by Vasya on 20.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        ConnectToDb connectToDb = new ConnectToDb();

        try {
            connectToDb.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
