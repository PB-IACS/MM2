package DBmanager;

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
        }

        return conn;
    }

    public static void createTables() throws SQLException {
        String sqlCategory = """
                CREATE TABLE IF NOT EXISTS Category (
                    categoryId INTEGER PRIMARY KEY AUTOINCREMENT,
                    categoryName TEXT NOT NULL UNIQUE
                );
                """;
        String sqlMedicine = """
                CREATE TABLE IF NOT EXISTS Medicine (
                    medicineId INTEGER PRIMARY KEY AUTOINCREMENT,
                    medicineName TEXT NOT NULL UNIQUE,
                    currentMedicineAmount INTEGER,
                    desiredMedicineAmount INTEGER,
                    medicineCategoryId INTEGER NOT NULL,
                    FOREIGN KEY (medicineCategoryId) REFERENCES Category(categoryId)
                );
                """;
        String sqlCurrent = """
                CREATE TABLE IF NOT EXISTS Current (
                    currentId INTEGER PRIMARY KEY AUTOINCREMENT,
                    currentAmount INTEGER NOT NULL DEFAULT 1,
                    currentName TEXT NOT NULL,
                    expirationDate TEXT,
                    isExpired INTEGER NOT NULL DEFAULT 0,
                    currentMedicineId INTEGER NOT NULL,
                    FOREIGN KEY (currentMedicineId) REFERENCES Medicine(medicineId)
                );
                """; //I think sqlite doesnt support boolean
        String sqlDesired = """
                CREATE TABLE IF NOT EXISTS Desired (
                    desiredId INTEGER PRIMARY KEY AUTOINCREMENT,
                    desiredAmount INTEGER NOT NULL,
                    desiredMedicineId INTEGER NOT NULL,
                    FOREIGN KEY (desiredMedicineId) REFERENCES Medicine(medicineId)
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
    public static void main(String[] args) throws SQLException {
        createTables();
    }

}
