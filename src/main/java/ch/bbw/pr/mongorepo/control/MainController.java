package ch.bbw.pr.mongorepo.control;

import ch.bbw.pr.mongorepo.model.Customer;
import ch.bbw.pr.mongorepo.service.MainService;
import org.springframework.web.bind.annotation.*;

/**
 * The RestController
 * @author Andrin Renggli
 * @version 22.1.2024
 */
@RestController
public class MainController {

   private final MainService mainService;

   public MainController(MainService mainService) {
      this.mainService = mainService;
   }

   @GetMapping("/setup")
   public Iterable<Customer> setupUsers() {
      return mainService.setupUsers();
   }

   @GetMapping("/getall")
   public Iterable<Customer> getAllUsers() {
      return mainService.getAllCustomers();
   }

   @GetMapping("/findbyfirstname")
   public Customer findByName(@RequestParam String firstname) {
      return mainService.findByFirstname(firstname);
   }

   @GetMapping("/findbylastname")
   public Iterable<Customer> findByLastname(@RequestParam String lastname) {
      return mainService.findByLastname(lastname);
   }

   @PutMapping("/update")
   public String updateByFirstname(@RequestParam String firstname, @RequestParam String newFirstname) {
      return mainService.updateFirstname(firstname, newFirstname);
   }

   @PutMapping("/addarticle")
   public String addArticle(@RequestParam String firstname, @RequestParam String type, @RequestParam double prize) {
      return mainService.addArticle(firstname, type, prize);
   }

   @DeleteMapping("/delete")
   public String deleteCustomerByLastname(@RequestParam String lastname) {
      return mainService.deleteByLastname(lastname);
   }
}