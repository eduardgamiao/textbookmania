package models;

import org.apache.commons.validator.routines.ISBNValidator;

/** 
 * A textbook object that represents a textbook.
 * @author Alvin Wang, Eduard Gamiao
 *
 */
public class Textbook {  
  private static final Integer THREE = 3; // For CheckStyle.
  private static final Integer TEN = 10; // For CheckStyle.
  private String title;
  private String author;
  private String isbn;
  private String condition;
  private String textbookURL;
  
  /**
   * Constructor for a textbook.
   * @param title The textbook title.
   * @param author The textbook author.
   * @param isbn The textbook isbn.
   * @param condition The textbook condition.
   */
  public Textbook(String title, String author, String isbn, String condition) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.condition = condition;
    this.textbookURL = createURL(this.isbn);
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the isbn
   */
  public String getIsbn() {
    return isbn;
  }

  /**
   * @param isbn the isbn to set
   */
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  /**
   * @return the condition
   */
  public String getCondition() {
    return condition;
  }

  /**
   * @param condition the condition to set
   */
  public void setCondition(String condition) {
    this.condition = condition;
  }

  /**
   * @return the textbookURL
   */
  public String getTextbookURL() {
    return textbookURL;
  }

  /**
   * @param textbookURL the textbookURL to set
   */
  public void setTextbookURL(String textbookURL) {
    this.textbookURL = textbookURL;
  }
  
  /**
   * Generate a URL that links to the book image.
   * @param productCode The ISBN of the book.
   * @return A URL of the image for the book.
   */
  public static String createURL(String productCode) {
    if (productCode.length() == 13) {
      System.out.println(productCode);
      System.out.println(new ISBNValidator().convertToISBN13(productCode.substring(3, productCode.length())));
    }
    return "http://images.amazon.com/images/P/" + productCode + ".01._PE20_SCMZZZZZZZ_.jpg";
  }
  
  /**
   * Convert an ISBN13 to ISBN10.
   * @param isbn13 The ISBN to be converted.
   * @return A ISBN10 representation of the ISBN13.
   */
  public static String convertISBN13To10(String isbn13) {
    return "";
  }
  
}
