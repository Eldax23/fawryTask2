package Classes.Services;

import Interfaces.Services.IDeliveryService;

public class MailService implements IDeliveryService {
    @Override
    public void deliver(String emailAddress) {

        System.out.println("The Product has been delivered to the customer with the Email: " + emailAddress);
    }
}
