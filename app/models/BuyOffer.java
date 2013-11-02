package models;

import java.util.Date;

/**
 * A object representing a Student's want to buy a Textbook.
 */
public class BuyOffer {

  private Student student;
  private Textbook textbook;
  private Integer price;
  private Date expirationDate;
  
  /**
   * Constructor.
   * @param student The Student that wants to buy.
   * @param textbook The Textbook that is wanted to buy.
   * @param price The price of the text book.
   * @param expirationDate The expiration date of the offer.
   */
  public BuyOffer(Student student, Textbook textbook, Integer price, Date expirationDate) {
    this.setStudent(student);
    this.setTextbook(textbook);
    this.setPrice(price);
    this.setExpirationDate(expirationDate);
  }

  /**
   * @return the student
   */
  public Student getStudent() {
    return student;
  }

  /**
   * @param student the student to set
   */
  public void setStudent(Student student) {
    this.student = student;
  }

  /**
   * @return the textbook
   */
  public Textbook getTextbook() {
    return textbook;
  }

  /**
   * @param textbook the textbook to set
   */
  public void setTextbook(Textbook textbook) {
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
  public Date getExpirationDate() {
    return expirationDate;
  }

  /**
   * @param expirationDate the expirationDate to set
   */
  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }
  
  
  
  
}
