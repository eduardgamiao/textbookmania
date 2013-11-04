package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A object representing a Student's want to buy a Textbook.
 */
public class BuyOffer {

  private String studentName;
  private String textbookName;
  private Integer price;
  private String expirationDate;
  private long id;
  
  /**
   * Constructor.
   * @param studentName The Student that wants to buy.
   * @param textbook The Textbook that is wanted to buy.
   * @param price The price of the text book.
   * @param expirationDate The expiration date of the offer.
   * @param id The ID field.
   */
  public BuyOffer(String studentName, String textbook, Integer price, String expirationDate, long id) {
    this.setStudentName(studentName);
    this.setTextbookName(textbook);
    this.setPrice(price);
    this.setExpirationDate(expirationDate);
    this.setId(id);
  }

  /**
   * @return the studentName
   */
  public String getStudentName() {
    return studentName;
  }

  /**
   * @param studentName the studentName to set
   */
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  /**
   * @return the textbookName
   */
  public String getTextbookName() {
    return textbookName;
  }

  /**
   * @param textbookName the textbookName to set
   */
  public void setTextbookName(String textbookName) {
    this.textbookName = textbookName;
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
