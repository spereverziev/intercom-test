package task3.service;

import task3.domain.Customer;
import task3.util.DistanceCalculator;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private static final double RANGE_100_KM = 100;

    private double intercomOfficeLatitude = 53.3381985;
    private double intercomOfficeLongtitude = -6.2592576;


    public List<Customer> getCustomersWithin100KM(List<Customer>  customers) {
        return getCustomersWithinRange(RANGE_100_KM, customers);
    }

    public List<Customer> getCustomersWithinRange(Double range, List<Customer> customers) {
        if (customers == null || range <= 0) {
            return new LinkedList<>();
        }

        return customers.stream()
                .filter(customer -> DistanceCalculator.calculateDistance(
                        intercomOfficeLatitude, intercomOfficeLongtitude, customer.getLatitude(), customer.getLongitude()) <= range)
                .sorted(Comparator.comparing(Customer::getUserId))
                .collect(Collectors.toList());
    }
}
