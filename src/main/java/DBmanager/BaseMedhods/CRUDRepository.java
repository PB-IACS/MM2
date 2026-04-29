package DBmanager.BaseMedhods;

import Clases.categoryClass;
import Clases.currentClass;
import Clases.desiredClass;
import Clases.medicineClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBmanager.Start.connect;

public class CRUDRepository {

    // --- Category ---

    public static void addCategory(String name) throws SQLException {
        String sql = "INSERT INTO Category(categoryName) VALUES(?)";
        try (Connection conn = connect()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static List<categoryClass> getAllCategories() throws SQLException {
        List<categoryClass> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categories.add(new categoryClass(
                        rs.getInt("categoryId"),
                        rs.getString("categoryName")
                ));
            }
        }
        return categories;
    }

    public static void updateCategory(int id, String name) throws SQLException {
        String sql = "UPDATE Category SET categoryName = ? WHERE categoryId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public static void deleteCategory(int id) throws SQLException {
        String sql = "DELETE FROM Category WHERE categoryId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // --- Medicine ---

    public static void addMedicine(String name, int currentAmount, int desiredAmount, int categoryId) throws SQLException {
        String sql = "INSERT INTO Medicine(medicineName, currentMedicineAmount, desiredMedicineAmount, medicineCategoryId) VALUES(?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, currentAmount);
            ps.setInt(3, desiredAmount);
            ps.setInt(4, categoryId);
            ps.executeUpdate();
        }
    }

    public static List<medicineClass> getAllMedicines() throws SQLException {
        List<medicineClass> medicines = new ArrayList<>();
        String sql = "SELECT * FROM Medicine";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                medicines.add(new medicineClass(
                        rs.getInt("medicineId"),
                        rs.getString("medicineName"),
                        rs.getInt("currentMedicineAmount"),
                        rs.getInt("desiredMedicineAmount"),
                        rs.getInt("medicineCategoryId")
                ));
            }
        }
        return medicines;
    }

    public static void updateMedicine(int id, String name, int currentAmount, int desiredAmount, int categoryId) throws SQLException {
        String sql = "UPDATE Medicine SET medicineName = ?, currentMedicineAmount = ?, desiredMedicineAmount = ?, medicineCategoryId = ? WHERE medicineId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, currentAmount);
            ps.setInt(3, desiredAmount);
            ps.setInt(4, categoryId);
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

    public static void deleteMedicine(int id) throws SQLException {
        String sql = "DELETE FROM Medicine WHERE medicineId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // --- Current ---

    public static void addCurrent(int amount, String name, String expDate, int isExpired, int medicineId) throws SQLException {
        String sql = "INSERT INTO Current(currentAmount, currentName, expirationDate, isExpired, currentMedicineId) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, amount);
            ps.setString(2, name);
            ps.setString(3, expDate);
            ps.setInt(4, isExpired);
            ps.setInt(5, medicineId);
            ps.executeUpdate();
        }
    }

    public static List<currentClass> getAllCurrents() throws SQLException {
        List<currentClass> currents = new ArrayList<>();
        String sql = "SELECT * FROM Current";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                currents.add(new currentClass(
                        rs.getInt("currentId"),
                        rs.getInt("currentAmount"),
                        rs.getString("currentName"),
                        rs.getString("expirationDate"),
                        rs.getInt("isExpired"),
                        rs.getInt("currentMedicineId")
                ));
            }
        }
        return currents;
    }

    public static void updateCurrent(int id, int amount, String name, String expDate, int isExpired, int medicineId) throws SQLException {
        String sql = "UPDATE Current SET currentAmount = ?, currentName = ?, expirationDate = ?, isExpired = ?, currentMedicineId = ? WHERE currentId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, amount);
            ps.setString(2, name);
            ps.setString(3, expDate);
            ps.setInt(4, isExpired);
            ps.setInt(5, medicineId);
            ps.setInt(6, id);
            ps.executeUpdate();
        }
    }

    public static void deleteCurrent(int id) throws SQLException {
        String sql = "DELETE FROM Current WHERE currentId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // --- Desired ---

    public static void addDesired(int amount, int medicineId) throws SQLException {
        String sql = "INSERT INTO Desired(desiredAmount, desiredMedicineId) VALUES(?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, amount);
            ps.setInt(2, medicineId);
            ps.executeUpdate();
        }
    }

    public static List<desiredClass> getAllDesireds() throws SQLException {
        List<desiredClass> desireds = new ArrayList<>();
        String sql = "SELECT * FROM Desired";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                desireds.add(new desiredClass(
                        rs.getInt("desiredId"),
                        rs.getInt("desiredAmount"),
                        rs.getInt("desiredMedicineId")
                ));
            }
        }
        return desireds;
    }

    public static void updateDesired(int id, int amount, int medicineId) throws SQLException {
        String sql = "UPDATE Desired SET desiredAmount = ?, desiredMedicineId = ? WHERE desiredId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, amount);
            ps.setInt(2, medicineId);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
    }

    public static void deleteDesired(int id) throws SQLException {
        String sql = "DELETE FROM Desired WHERE desiredId = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
