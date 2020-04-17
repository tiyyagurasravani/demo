package com.telecom.demo10.repository;


        import java.util.ArrayList;
        import java.util.List;
        import javax.annotation.PostConstruct;
        import org.springframework.stereotype.Repository;
        import com.telecom.demo10.dto.CustomerDTO;
        import com.telecom.demo10.dto.FriendFamilyDTO;
        import com.telecom.demo10.dto.PlanDTO;
        import com.telecom.demo10.Exception.NoSuchCustomerException;
@Repository
public class CustomerRepository {
    List<CustomerDTO> customers = null;
    // Populates customer in hard-coded way
    @PostConstruct
    public void initializer() {
        CustomerDTO customerDTO = new CustomerDTO();
        PlanDTO planDTO = new PlanDTO();
        planDTO.setPlanId(1);
        planDTO.setPlanName("Simple");
        planDTO.setLocalRate(3);
        planDTO.setNationalRate(5);
        customerDTO.setAddress("Chennai");
        customerDTO.setAge(18);
        customerDTO.setCurrentPlan(planDTO);
        customerDTO.setGender('m');
        customerDTO.setName("Jack");
        customerDTO.setEmail("Jack@infy.com");
        customerDTO.setPassword("ABC@123");
        customerDTO.setPhoneNo(9951212222l);
        List<FriendFamilyDTO> friendAndFamily = new ArrayList<>();
        friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 800000145));
        friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 700000145));
        customerDTO.setFriendAndFamily(friendAndFamily);
        customers = new ArrayList<>();
        customers.add(customerDTO);
    }
    // creates customer
    public String createCustomer(CustomerDTO customerDTO) {
        customers.add(customerDTO);
        return "Customer with" + customerDTO.getPhoneNo() + "added successfully";
    }
    // fetches customer
    public List<CustomerDTO> fetchCustomer() {
        return customers;
    }
    // deletes customer - exception handling incorporated
    public String deleteCustomer(long phoneNumber) throws NoSuchCustomerException {
        boolean notfound = true;
        String response = "Customer of:" + phoneNumber + "\t does not exist";
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber) {
                customers.remove(customer);
                response = customer.getName() + " with  phoneNumber " + customer.getPhoneNo() + " deleted successfully";
                notfound = false;
                break;
            }
        }
        if (notfound)
            throw new NoSuchCustomerException("Customer does not exist :" + phoneNumber);
        return response;
    }
    // updates customer
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        String response = "Customer of:" + phoneNumber + "\t does not exist";
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber) {
                if (customerDTO.getName() != null)
                    customer.setName(customerDTO.getName());
                if (customerDTO.getAddress() != null)
                    customer.setAddress(customerDTO.getAddress());
                if (customerDTO.getPassword() != null)
                    customer.setPassword(customerDTO.getPassword());
                customers.set(customers.indexOf(customer), customer);
                response = "Customer of phoneNumber" + customer.getPhoneNo() + "\t got updated successfully";
                break;
            }
        }
        return response;
    }
}
