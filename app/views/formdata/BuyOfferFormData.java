package views.formdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import play.data.validation.ValidationError;
import models.BuyOffer;
import models.BuyOfferDB;
import models.Student;
import models.StudentDB;
import models.Textbook;
import models.TextbookDB;

/**
 * Form data for a BuyOffer.
 */
public class BuyOfferFormData {
  private static final Integer PRICE_FLOOR = 0;
  
  /** Student that wants to buy. */
  public Student student;
  
  /** Textbook wanted to be bought. */
  public Textbook textbook;
  
  /** Price of the textbook. */
  public Integer price;
  
  /** Expiration date of the offer. */
  public Date expirationDate;
  
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
  public BuyOfferFormData(Student student, Textbook textbook, Integer price, Date date) {
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
    this.student = offer.getStudent();
    this.textbook = offer.getTextbook();
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
    if (this.student == null) {
      errors.add(new ValidationError("student", "A student is required."));
    }
    if (!(StudentDB.isEmailTaken(this.student.getEmail()))) {
      errors.add(new ValidationError("student", "The Student linked to the email \"" + this.student.getEmail() + "\""
          + " is not valid."));
    }
    if (!(TextbookDB.doesIsbnExist(this.textbook.getIsbn()))) {
      errors.add(new ValidationError("isbn", "The Textbook with the ISBN \"" + this.textbook.getIsbn() + "\""
          + " is not valid."));
    }
    if (BuyOfferDB.isInteger(this.price.toString())) {
      errors.add(new ValidationError("price", "The price of the offer must be a positive, whole number."));      
    }
    if (this.price < PRICE_FLOOR) {
      errors.add(new ValidationError("price", "The price of the offer must be a positive, whole number."));      
    }
    if (this.expirationDate.before(new Date())) {
      errors.add(new ValidationError("expirationDate", "The date \"" + this.expirationDate.toString() + "\" has already"
          + " passed."));       
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
  

}
