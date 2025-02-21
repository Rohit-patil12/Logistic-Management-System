import java.util.List;

public class ShipmentService {
    private final IShipmentDAO shipmentDAO;

    public ShipmentService(IShipmentDAO shipmentDAO) {
        this.shipmentDAO = shipmentDAO;
    }

    public void addShipment(String origin, String destination, String status) {
        Shipment shipment = new Shipment();
        shipment.setOrigin(origin);
        shipment.setDestination(destination);
        shipment.setStatus(status);
        shipmentDAO.addShipment(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentDAO.getAllShipments();
    }

    public void updateShipment(int id, String origin, String destination, String status) {
        Shipment shipment = new Shipment();
        shipment.setId(id);
        shipment.setOrigin(origin);
        shipment.setDestination(destination);
        shipment.setStatus(status);
        shipmentDAO.updateShipment(shipment);
    }

    public void deleteShipment(int id) {
        shipmentDAO.deleteShipment(id);
    }
}
