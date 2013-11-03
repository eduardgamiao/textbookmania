package models;

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
  
  /**
   * Constructor for SellOffer.
   * @param student The Student that wants to sell.
   * @param textbook THe Textbook that is being sold.
   * @param price The selling price of Textbook.
   * @param expirationDate The expiration date of the offer.
   */
  public SellOffer(String student, String textbook, Integer price, String expirationDate) {
    this.student = student;
    this.textbook = textbook;
    this.price = price;
    this.expirationDate = expirationDate;
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
  
}
