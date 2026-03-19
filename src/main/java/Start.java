import java.sql.SQLException;

public class Start {
    private static final String DB_URL = "jdbc:sqlite:MM2.db";
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
    }

    }
