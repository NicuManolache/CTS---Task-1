package sql.acs.ase.ro.main;

import java.sql.Connection;
import java.sql.DriverManager;
import static sql.acs.ase.ro.classes.createTable.createTable;
import static sql.acs.ase.ro.classes.insertData.insertData;
import static sql.acs.ase.ro.classes.readData.readData;
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            createTable(connection);
            insertData(connection);
            readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
