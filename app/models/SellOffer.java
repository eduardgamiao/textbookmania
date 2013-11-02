package models;

import java.util.Date;

/**
 * An Object representing a Student's want to sell a Textbook.
 * @author Alvin Wang
 *
 */
public class SellOffer {

  /** The Student. */
  private Student student;
  /** The Textbook. */
  private Textbook textbook;
  /** The selling price. */
  private Integer price;
  /** The expiration date. */
  private Date expirationDate;
  
  /**
   * Constructor for SellOffer.
   * @param student The Student that wants to sell.
   * @param textbook THe Textbook that is being sold.
   * @param price The selling price of Textbook.
   * @param expirationDate The expiration date of the offer.
   */
  public SellOffer(Student student, Textbook textbook, Integer price, Date expirationDate) {
    this.student = student;
    this.textbook = textbook;
    this.price = price;
    this.expirationDate = expirationDate;
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
