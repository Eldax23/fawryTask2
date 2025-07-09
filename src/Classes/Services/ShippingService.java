package Classes.Services;

import Interfaces.Services.IDeliveryService;

public class ShippingService  implements IDeliveryService {
    @Override
    public void deliver(String address) {
        System.out.println("The Product has been delivered to the customer with the address: " + address);
    }
}
