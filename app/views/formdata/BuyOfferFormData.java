package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.BuyOffer;
import models.StudentDB;
import models.TextbookDB;

/**
 * Form data for a BuyOffer.
 */
public class BuyOfferFormData {
  private static final Integer PRICE_FLOOR = 0;
  
  /** Student that wants to buy. */
  public String student = "";
  
  /** Textbook wanted to be bought. */
  public String textbook = "Lol";
  
  /** Price of the textbook. */
  public Integer price = 0;
  
  /** Expiration date of the offer. */
  public String expirationDate = "";
  
  /**
   * Blank constructor.
   */
  public BuyOfferFormData() {
    
  }

  /**
   * Constructor.
   * @param student Student who wants to buy.
   * @param textbook Textbook of interest.
   * @param price Price of Textbook.
   * @param date Date the offer expires.
   */
  public BuyOfferFormData(String student, String textbook, Integer price, String date) {
    this.student = student;
    this.textbook = textbook;
    this.price = price;
    this.expirationDate = date;
  }
  
  /**
   * Constructor.
   * @param offer A BuyOffer object.
   */
  public BuyOfferFormData(BuyOffer offer) {
    this.student = offer.getStudentName();
    this.textbook = offer.getTextbookName();
    this.price = offer.getPrice();
    this.expirationDate = offer.getExpirationDate();
  }

  /**
   * Validation method for the StudentDataForm.
   * @return A List of errors (if they exist), otherwise null.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    /* testing */
    if (this.student == null || this.student == "") {
      errors.add(new ValidationError("student", "A student is required."));
    }
    if (!(StudentDB.isEmailTaken(formatStudentName()))) {
      errors.add(new ValidationError("student", "The Student linked to the email \""
          +  formatStudentName() + "\" is not valid."));
    }
    if (!(TextbookDB.doesIsbnExist(this.textbook))) {
      errors.add(new ValidationError("isbn", "The Textbook with the ISBN \"" + this.textbook + "\""
          + " is not valid."));
    }
    /*
    if (BuyOfferDB.isInteger(this.price.toString())) {
      errors.add(new ValidationError("price", "The price of the offer must be a positive, whole number."));      
    }
    if (this.price < PRICE_FLOOR) {
      errors.add(new ValidationError("price", "The price of the offer must be a positive, whole number."));      
    }
    */
    // Date Validation TODO.
    
    return errors.isEmpty() ? null : errors;
  }
  
  /**
   * Formats Student name from options.
   * @return The email address of the Student extracted from the select menu input.
   */
  private String formatStudentName() {
    return this.student.substring(this.student.indexOf('(') + 1, this.student.indexOf(')'));
  }
  
  

}
