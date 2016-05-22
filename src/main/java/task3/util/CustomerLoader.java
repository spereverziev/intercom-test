package task3.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import task3.domain.Customer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerLoader {

    public static List<Customer> readCustomersFromFile(String fileName) throws IOException {
        List<Customer> customers = new LinkedList<>();
        ObjectMapper jsonMapper = new ObjectMapper();

        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {
            customers.add(jsonMapper.readValue(scanner.nextLine(), Customer.class));
        }

        return customers;
    }

}
