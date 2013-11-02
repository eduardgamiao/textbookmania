package models;

/**
 * A object representing a Student's want to buy a Textbook.
 */
public class BuyOffer {

  private String studentName;
  private String textbookName;
  private Integer price;
  private String expirationDate;
  
  /**
   * Constructor.
   * @param studentName The Student that wants to buy.
   * @param textbook The Textbook that is wanted to buy.
   * @param price The price of the text book.
   * @param expirationDate The expiration date of the offer.
   */
  public BuyOffer(String studentName, String textbook, Integer price, String expirationDate) {
    this.setStudentName(studentName);
    this.setTextbookName(textbook);
    this.setPrice(price);
    this.setExpirationDate(expirationDate);
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
}
