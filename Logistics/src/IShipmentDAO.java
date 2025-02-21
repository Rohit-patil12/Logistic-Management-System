import java.util.List;

public interface IShipmentDAO {
    void addShipment(Shipment shipment);
    List<Shipment> getAllShipments();
    void updateShipment(Shipment shipment);
    void deleteShipment(int id);
}
