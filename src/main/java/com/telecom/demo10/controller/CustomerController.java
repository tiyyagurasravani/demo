package com.telecom.demo10.controller;



        import java.util.List;
        import java.util.stream.Collectors;

        import javax.validation.Valid;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.Errors;
        import org.springframework.validation.ObjectError;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;

        import org.springframework.web.bind.annotation.RestController;

        import com.telecom.demo10.dto.CustomerDTO;
        import com.telecom.demo10.dto.ErrorMessage;

        import com.telecom.demo10.Exception.NoSuchCustomerException;
        import com.telecom.demo10.service.CustomerService;


@RestController
@RequestMapping("/customers")
//@Api(value = "CustomerController, REST APIs that deal with Customer DTO")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Fetching customer details
    @GetMapping(produces = "application/json")
  //  @ApiOperation(value = "Fetch all the customers of Infytel", response = CustomerDTO.class)
    //@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the customers successfully"),
      //      @ApiResponse(code = 404, message = "Customer details not found") })
    public List<CustomerDTO> fetchCustomer() {
        return customerService.fetchCustomer();
    }

    // Adding a customer
    @PostMapping(consumes = "application/json")
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDTO customerDTO, Errors errors) {
        String response = "";
        if (errors.hasErrors()) {

            response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));
            ErrorMessage error = new ErrorMessage();
            error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
            error.setMessage(response);
            return ResponseEntity.ok(error);
        } else {

            response = customerService.createCustomer(customerDTO);
            return ResponseEntity.ok(response);
        }

    }

    // Updating an existing customer
    @PutMapping(value = "/{phoneNumber}", consumes = "application/json")
    public String updateCustomer(@PathVariable("phoneNumber") long phoneNumber, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(phoneNumber, customerDTO);
    }

    // Deleting a customer
    @DeleteMapping(value = "/{phoneNumber}", produces = "text/html")
    public String deleteCustomer(@PathVariable("phoneNumber") long phoneNumber) throws NoSuchCustomerException {

        return customerService.deleteCustomer(phoneNumber);

    }

}

