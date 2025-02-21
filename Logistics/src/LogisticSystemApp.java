import java.util.List;
import java.util.Scanner;

public class LogisticSystemApp {
    public static void main(String[] args) {
        IShipmentDAO shipmentDAO = new ShipmentDAO();
        ShipmentService shipmentService = new ShipmentService(shipmentDAO);
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Logistics System Menu:");
            System.out.println("1. Add Shipment");
            System.out.println("2. View Shipments");
            System.out.println("3. Update Shipment");
            System.out.println("4. Delete Shipment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Origin: ");
                    String origin = scanner.nextLine();
                    System.out.print("Destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Status: ");
                    String status = scanner.nextLine();
                    shipmentService.addShipment(origin, destination, status);
                    break;
                case "2":
                    List<Shipment> shipments = shipmentService.getAllShipments();
                    for (Shipment s : shipments) {
                        System.out.println("ID: " + s.getId() + ", Origin: " + s.getOrigin() + ", Destination: " + s.getDestination() + ", Status: " + s.getStatus());
                    }
                    break;
                case "3":
                    System.out.print("Enter Shipment ID to Update: ");
                    int idToUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.print("New Origin: ");
                    String newOrigin = scanner.nextLine();
                    System.out.print("New Destination: ");
                    String newDestination = scanner.nextLine();
                    System.out.print("New Status: ");
                    String newStatus = scanner.nextLine();
                    shipmentService.updateShipment(idToUpdate, newOrigin, newDestination, newStatus);
                    break;
                case "4":
                    System.out.print("Enter Shipment ID to Delete: ");
                    int idToDelete = Integer.parseInt(scanner.nextLine());
                    shipmentService.deleteShipment(idToDelete);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!command.equals("5"));
        
        scanner.close();
    }
}
