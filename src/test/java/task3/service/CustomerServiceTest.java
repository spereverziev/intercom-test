package task3.service;

import org.junit.Before;
import org.junit.Test;
import task3.domain.Customer;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerServiceTest {

    public static final double RANGE_100KM = 100.0;
    public static final double RANGE_300KM = 300.0;
    public static final double INVALID_RANGE = -1;

    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void testGetCustomersWithinRange() {
        //given
        List<Customer> customers = new LinkedList<>();
        Customer customerTheresaEnright = new Customer(6L, "Theresa Enright", 53.1229599, -6.2705202);
        Customer customerAliceCahill = new Customer(1L, "Alice Cahill", 51.92893, -10.27699);
        Customer customerRichardFinnegan = new Customer(11L, "Richard Finnegan", 53.008769, -6.1056711);
        Customer customerHelenCahill = new Customer(14L, "Helen Cahill", 51.999447, -9.742744);
        customers.add(customerAliceCahill); // distance 313.1 km
        customers.add(customerHelenCahill); //distance 278 km
        customers.add(customerTheresaEnright); // distance 23.95 km
        customers.add(customerRichardFinnegan); // distance 38.03 km

        //when
        List<Customer> customersWithin100KMRange = customerService.getCustomersWithinRange(RANGE_100KM, customers);
        List<Customer> customersWithin300KMRange = customerService.getCustomersWithinRange(RANGE_300KM, customers);

        //then
        assertThat(customersWithin100KMRange).hasSize(2);
        assertThat(customersWithin100KMRange).containsExactly(customerTheresaEnright, customerRichardFinnegan);

        assertThat(customersWithin300KMRange).hasSize(3);
        assertThat(customersWithin300KMRange).containsExactly(customerTheresaEnright, customerRichardFinnegan, customerHelenCahill);
    }

    @Test
    public void testGetCustomersWithinRange_shouldReturnEmptyList_whenCustomersNull() {
        //given
        List<Customer> customers = null;

        //when
        List<Customer> customersWithinRange = customerService.getCustomersWithinRange(RANGE_100KM, customers);

        //then
        assertThat(customersWithinRange).isEmpty();
    }

    @Test
    public void testGetCustomersWithinRange_shouldReturnEmptyList_whenRangeInvalid() {
        //given
        List<Customer> customers = new LinkedList<>();
        Customer customerTheresaEnright = new Customer(6L, "Theresa Enright", 53.1229599, -6.2705202);
        customers.add(customerTheresaEnright);

        //when
        List<Customer> customersWithinRange = customerService.getCustomersWithinRange(INVALID_RANGE, customers);

        //then
        assertThat(customersWithinRange).isEmpty();
    }

}