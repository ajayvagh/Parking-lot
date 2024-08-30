import controller.TicketController;
import dto.TicketRequestDTO;
import dto.TicketResponseDTO;
import exception.GateNotFoundException;
import exception.NoEmptyParkingSlotAvailableException;
import exception.ParkingLotNotFoundException;
import models.ParkingLot;
import models.constants.VehicleType;
import repository.*;
import service.InitService;
import service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException, NoEmptyParkingSlotAvailableException, GateNotFoundException {

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        // First Ticket Request
        TicketRequestDTO ticketRequestDTO1 = new TicketRequestDTO();
        ticketRequestDTO1.setParkingLotId(1);
        ticketRequestDTO1.setGateId(31);  // Ensure this gate ID exists
        ticketRequestDTO1.setName("Mercedes");
        ticketRequestDTO1.setColor("Blue");
        ticketRequestDTO1.setVehicleType(VehicleType.CAR);
        ticketRequestDTO1.setNumber("1234");

        TicketResponseDTO ticketResponseDTO1 = ticketController.createTicket(ticketRequestDTO1);
        System.out.println(ticketResponseDTO1);

        // Second Ticket Request
        TicketRequestDTO ticketRequestDTO2 = new TicketRequestDTO();
        ticketRequestDTO2.setParkingLotId(1);
        ticketRequestDTO2.setGateId(32); // Ensure this gate ID exists
        ticketRequestDTO2.setName("Toyota");
        ticketRequestDTO2.setColor("Red");
        ticketRequestDTO2.setVehicleType(VehicleType.BIKE);
        ticketRequestDTO2.setNumber("5678");

        TicketResponseDTO ticketResponseDTO2 = ticketController.createTicket(ticketRequestDTO2);
        System.out.println(ticketResponseDTO2);

    }
}
