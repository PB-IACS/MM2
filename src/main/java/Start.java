import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {
    private static final String DB_URL = "jdbc:sqlite:MM2.db";
    public static Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL);

        // In SQLite, foreign key checks are off unless enabled
        try (Statement stmt = conn.createStatement()) {
            //PRAGMA command is sqlite specific due to its default setting
            stmt.execute("PRAGMA foreign_keys = ON");
            /**
             * PRAGMA is used for changing sqlite settings or getting some meta data
             * such as PRAGMA table_info(students)
             * this will
             */
        }

        return conn;}
    public static void createTables() throws SQLException {
        String sqlCategory = """
            CREATE TABLE IF NOT EXISTS Category (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                catName TEXT NOT NULL UNIQUE,
            );
            """;
        String sqlMedicine = """
            CREATE TABLE IF NOT EXISTS Medicine (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                medName TEXT NOT NULL UNIQUE,
                cmAmount INTEGER,
                dmAmount INTEGER,
                medCategory TEXT NOT NULL,
                FOREIGN KEY (medcategory) REFERENCES Category(catname)
            );
            """;
        String sqlCurrent = """
            CREATE TABLE IF NOT EXISTS Current (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                cAmount INTEGER NOT NULL DEFAULT 1,
                cName TEXT NOT NULL,
                expDate TEXT,
                isExp INTEGER NOT NULL DEFAULT 0,
                cMedName TEXT NOT NULL,
                FOREIGN KEY (cMedName) REFERENCES Medicine(medName)
            );
            """; //I think sqlite doesnt support boolean
        String sqlDesired = """
            CREATE TABLE IF NOT EXISTS Desired (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                dAmount INTEGER NOT NULL,
                dMedName TEXT NOT NULL,
                FOREIGN KEY (dMedName) REFERENCES Medicine(medName)
            );
            """;
        try (Connection conn = connect(); //instead of passing it we call it here
             //and this means the connection object opens connection and closes it
//             when the block is terminates it's execution
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCategory);
            stmt.execute(sqlMedicine);
            stmt.execute(sqlCurrent);
            stmt.execute(sqlDesired);
        }
    }

    }
