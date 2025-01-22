package ch.bbw.pr.mongorepo.service;

import ch.bbw.pr.mongorepo.model.Article;
import ch.bbw.pr.mongorepo.model.City;
import ch.bbw.pr.mongorepo.model.Customer;
import ch.bbw.pr.mongorepo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final CustomerRepository customerRepository;

    public MainService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> setupUsers() {
        customerRepository.deleteAll();
        customerRepository.save(new Customer(
                "Alice",
                "Keller",
                new City("Winterthur", 8400),
                List.of(new Article("book", 25.99), new Article("table", 250.0))
        ));
        customerRepository.save(new Customer(
                "Bob",
                "Meyer",
                new City("Zurich", 8000),
                List.of(new Article("chair", 45.99), new Article("lamp", 70.0))
        ));
        return customerRepository.findAll();
    }

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer findByFirstname(String firstname) {
        return customerRepository.findByFirstName(firstname);
    }

    public List<Customer> findByLastname(String lastname) {
        return customerRepository.findByLastName(lastname);
    }

    public String updateFirstname(String firstname, String newFirstname) {
        Customer customer = customerRepository.findByFirstName(firstname);
        if (customer != null) {
            customer.setFirstName(newFirstname);
            customerRepository.save(customer);
            return "Updated successfully.";
        }
        return "Customer not found.";
    }

    public String addArticle(String firstname, String type, double prize) {
        Customer customer = customerRepository.findByFirstName(firstname);
        if (customer != null) {
            customer.getArticles().add(new Article(type, prize));
            customerRepository.save(customer);
            return "Article added successfully.";
        }
        return "Customer not found.";
    }

    public String deleteByLastname(String lastname) {
        List<Customer> customers = customerRepository.findByLastName(lastname);
        if (!customers.isEmpty()) {
            customerRepository.deleteAll(customers);
            return "Deleted successfully.";
        }
        return "No customers found with the given last name.";
    }
}