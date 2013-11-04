package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An Object representing a Student's want to sell a Textbook.
 * @author Alvin Wang
 *
 */
public class SellOffer {

  /** The Student. */
  private String student;
  /** The Textbook. */
  private String textbook;
  /** The selling price. */
  private Integer price;
  /** The expiration date. */
  private String expirationDate;
  /** The ID. */
  private long id;
  
  /**
   * Constructor for SellOffer.
   * @param student The Student that wants to sell.
   * @param textbook THe Textbook that is being sold.
   * @param price The selling price of Textbook.
   * @param expirationDate The expiration date of the offer.
   * @param id The ID.
   */
  public SellOffer(String student, String textbook, Integer price, String expirationDate, long id) {
    this.student = student;
    this.textbook = textbook;
    this.price = price;
    this.expirationDate = expirationDate;
    this.id = id;
  }
  
  /**
   * @return the student
   */
  public String getStudent() {
    return student;
  }
  /**
   * @param student the student to set
   */
  public void setStudent(String student) {
    this.student = student;
  }
  /**
   * @return the textbook
   */
  public String getTextbook() {
    return textbook;
  }
  /**
   * @param textbook the textbook to set
   */
  public void setTextbook(String textbook) {
    this.textbook = textbook;
  }
  /**
   * @return the price
   */
  public Integer getPrice() {
    return price;
  }
  /**
   * @param price the price to set
   */
  public void setPrice(Integer price) {
    this.price = price;
  }
  /**
   * @return the expirationDate
   */
  public String getExpirationDate() {
    return expirationDate;
  }
  /**
   * @param expirationDate the expirationDate to set
   */
  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
  
  /**
   * Check if the BuyOffer has expired.
   * @return True if not expired, false otherwise. 
   * @throws ParseException Thrown if date is invalid.
   */
  public boolean isNotExpired() throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = new Date();
    Date expirationDate = dateFormat.parse(this.expirationDate);
    return currentDate.before(expirationDate);
  }
  
}
