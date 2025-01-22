package ch.bbw.pr.mongorepo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Customer
 * @author Andrin Renggli
 * @version 22.1.2024
 */
@Getter
@Setter
@ToString
public class Customer {
   @Id
   private String id;
   private String firstName;
   private String lastName;
   private City city;
   private List<Article> articles;

   public Customer(String firstName, String lastName, City city, List<Article> articles) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.city = city;
      this.articles = articles;
   }
}
