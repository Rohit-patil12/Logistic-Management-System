import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipmentDAO implements IShipmentDAO {
    public void addShipment(Shipment shipment) {
        String sql = "INSERT INTO shipments (origin, destination, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shipment.getOrigin());
            pstmt.setString(2, shipment.getDestination());
            pstmt.setString(3, shipment.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Shipment> getAllShipments() {
        List<Shipment> shipments = new ArrayList<>();
        String sql = "SELECT * FROM shipments";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Shipment shipment = new Shipment();
                shipment.setId(rs.getInt("id"));
                shipment.setOrigin(rs.getString("origin"));
                shipment.setDestination(rs.getString("destination"));
                shipment.setStatus(rs.getString("status"));
                shipments.add(shipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;
    }

    public void updateShipment(Shipment shipment) {
        String sql = "UPDATE shipments SET origin=?, destination=?, status=? WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shipment.getOrigin());
            pstmt.setString(2, shipment.getDestination());
            pstmt.setString(3, shipment.getStatus());
            pstmt.setInt(4, shipment.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteShipment(int id) {
        String sql = "DELETE FROM shipments WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
