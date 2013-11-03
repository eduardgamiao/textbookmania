package views.formdata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
  public String textbook = "";
  
  /** Price of the textbook. */
  public Integer price = 0;
  
  /** Expiration date of the offer. */
  public String expirationDate = "9999/12/31 23:59:59";
  
  /** THe ID field. */
  public long id = 0;
  
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
  public BuyOfferFormData(String student, String textbook, Integer price, String date, long id) {
    this.student = student;
    this.textbook = textbook;
    if (isDateFormatted(date)) {
      this.price = price;
    }
    this.expirationDate = date;
    this.id = id;
  }
  
  /**
   * Constructor.
   * @param offer A BuyOffer object.
   */
  public BuyOfferFormData(BuyOffer offer) {
    this.student = offer.getStudentName();
    this.textbook = offer.getTextbookName();
    if (isDateFormatted(offer.getExpirationDate())) {
      this.price = offer.getPrice();
    }
    this.expirationDate = offer.getExpirationDate();
    System.out.println("FROM BOFD: " + offer.getId());
    this.id = offer.getId();
  }

  /**
   * Validation method for the StudentDataForm.
   * @return A List of errors (if they exist), otherwise null.
   * @throws ParseException 
   */
  public List<ValidationError> validate() throws ParseException {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    /* testing */
    if (this.student == null || this.student == "") {
      errors.add(new ValidationError("student", "A student is required."));
    }
    if (!(StudentDB.isEmailTaken(formatName()))) {
      errors.add(new ValidationError("student", "The Student linked to the email \""
          +  formatName() + "\" is not valid."));
    }
    if (this.textbook == "" || this.textbook == null) {
      errors.add(new ValidationError("textbook", "Textbook is required"));
    }
    if (!(TextbookDB.doesIsbnExist(formatTextName()))) {
      errors.add(new ValidationError("textbook", "The Textbook with the ISBN \"" + formatTextName() + "\""
          + " is not valid."));
    }
    if (this.price < PRICE_FLOOR) {
      errors.add(new ValidationError("price", "The price must be a positive, whole number"));
    }
    if (this.expirationDate == "" || this.expirationDate == null) {
      errors.add(new ValidationError("expirationDate", "The expiration date is required."));
    }
    if (!(isDateValid())) {
      errors.add(new ValidationError("expirationDate", "The expiration date needs to be after the current date/time and"
                                     + " follow the format YYYY/MM/dd hh/mm/ss."));      
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
  /**
   * Formats String to extract email.
   * @return The email address of the Student extracted from the select menu input.
   */
  private String formatName() {
    return this.student == null || this.student == "" 
        ? "" : this.student.substring(this.student.indexOf('(') + 1, this.student.indexOf(')'));
  }
  
  /**
   * Formats String to extract email.
   * @return The email address of the Student extracted from the select menu input.
   */
  private String formatTextName() {
    return this.textbook == null || this.textbook == "" 
        ? "" : this.textbook.substring(this.textbook.indexOf('(') + 1, this.textbook.indexOf(')'));
  }
  
  /**
   * Check if the date.
   * @return False if the current date is after the expiration date, true otherwise.
   * @throws ParseException Thrown if String is not formatted properly.
   */
  private boolean isDateValid() throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = new Date();
    if (isDateFormatted(this.expirationDate)) {
      Date expire = dateFormat.parse(this.expirationDate);
      return !currentDate.after(expire);
    }
    else {
      return false;
    }
  }
  
  /**
   * Check if the date entered is formatted correctly.
   * @param date Date to check.
   * @return True if the date is formatted correctly, otherwise false.
   */
  private boolean isDateFormatted(String date) {
    // Must match ####/##/## ##:##:## format.
    return date.matches("[0-9][0-9][0-9][0-9]/[0-1][0-9]/[0-3][0-9] "
                                       + "[0-2][0-9]:[0-6][0-9]:[0-6][0-9]");
  }
}
