package task3;

import org.apache.log4j.Logger;
import task3.domain.Customer;
import task3.service.CustomerService;
import task3.util.CustomerLoader;

import java.io.IOException;
import java.util.List;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class);

    private static final String FILE_WITH_CUSTOMERS = "data/customers.txt";

    public static void main(String args[]) {
        CustomerService customerService = new CustomerService();
        List<Customer> customers = null;
        try {
            customers = CustomerLoader.readCustomersFromFile(FILE_WITH_CUSTOMERS);
        } catch (IOException e) {
            log.error("Error occurs during reading customers from file, " + e.getLocalizedMessage());
        }

        List<Customer> customersWithin100KM = customerService.getCustomersWithin100KM(customers);

        for (Customer customer : customersWithin100KM) {
            System.out.printf("%s %d%n", customer.getName(), customer.getUserId());
        }


    }

}
