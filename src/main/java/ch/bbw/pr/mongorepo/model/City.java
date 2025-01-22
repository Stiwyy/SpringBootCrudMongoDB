package ch.bbw.pr.mongorepo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * City
 * @author Andrin Renggli
 * @version 22.1.2024
 */
@Getter
@Setter
@ToString
public class City {
   private String name;
   private int plz;

   public City(String name, int plz) {
      this.name = name;
      this.plz = plz;
   }
}
