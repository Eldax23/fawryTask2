package Classes.Services;

import Interfaces.Services.IShippingService;

public class ShippingService  implements IShippingService {
    @Override
    public void deliver(String emailAddress) {
        System.out.println("The Product has been delivered to the customer with the email: " + emailAddress);
    }
}
