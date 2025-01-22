package ch.bbw.pr.mongorepo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Article
 * @author Andrin Renggli
 * @version 22.1.2024
 */
@Getter
@Setter
@ToString
public class Article{
   private String type;
   private double prize;

   public Article(String type, double prize) {
      this.type = type;
      this.prize = prize;
   }
}
