package DBmanager.BaseMedhods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static DBmanager.Start.connect;

public class CategoryRepository {
    public static void addCategory(String name) throws SQLException {
        String sql = "INSERT INTO Category(categoryName) VALUES(?)";
        try (Connection conn = connect()) {//establish connection
            PreparedStatement ps = conn.prepareStatement(sql);//through the connect pass sql argument
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }
}
