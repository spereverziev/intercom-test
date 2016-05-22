package task3.util;

import org.junit.Before;
import org.junit.Test;
import task3.domain.Customer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerLoaderTest {

    private static final String FILE_NAME_WITH_TEST_CUSTOMERS = "test-customers";
    private static final String FILE_EXT_WITH_TEST_CUSTOMERS = "txt";
    private String tmpFilePath;

    private String[] customersData;

    @Before
    public void setUp() {
        //{"latitude": "52.986375", "user_id": 12, "name": "Christina McArdle", "longitude": "-6.043701"}
        //{"latitude": "51.92893", "user_id": 1, "name": "Alice Cahill", "longitude": "-10.27699"}

        customersData = new String[2];
        customersData[0] = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";
        customersData[1] = "{\"latitude\": \"51.92893\", \"user_id\": 1, \"name\": \"Alice Cahill\", \"longitude\": \"-10.27699\"}";
    }

    @Test
    public void testReadCustomersFromFile() throws IOException {
        //given
        List<Customer> actualCustomers;
        List<Customer> expectedCustomers = new ArrayList<>();

        expectedCustomers.add(new Customer(12L, "Christina McArdle", 52.986375,-6.043701));
        expectedCustomers.add(new Customer(1L, "Alice Cahill", 51.92893,-10.27699));

        writeToTmpFile(customersData);

        //when
        actualCustomers = CustomerLoader.readCustomersFromFile(tmpFilePath);

        //then
        assertThat(actualCustomers.size()).isEqualTo(2);
        assertThat(actualCustomers.get(0)).isEqualToComparingFieldByField(expectedCustomers.get(0));
        assertThat(actualCustomers.get(1)).isEqualToComparingFieldByField(expectedCustomers.get(1));
    }

    @Test
    public void testReadCustomersFromEmptyFile() throws IOException {
        //given
        List<Customer> actualCustomers;

        writeToTmpFile(new String[0]);

        //when
        actualCustomers = CustomerLoader.readCustomersFromFile(tmpFilePath);

        //then
        assertThat(actualCustomers.size()).isEqualTo(0);
    }


    private void writeToTmpFile(String[] customers) throws IOException {
        File temp = File.createTempFile(FILE_NAME_WITH_TEST_CUSTOMERS, FILE_EXT_WITH_TEST_CUSTOMERS);
        tmpFilePath = temp.getPath();
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        for (String customer : customers) {
            bw.write(customer);
            bw.newLine();
        }
        bw.close();
    }

}