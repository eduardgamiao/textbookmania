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
    return convertISBN13To10(productCode);
  }
  
  /**
   * Convert an ISBN13 to ISBN10.
   * @param isbn13 The ISBN to be converted.
   * @return A ISBN10 representation of the ISBN13.
   */
  public static String convertISBN13To10(String isbn13) {
    if (new ISBNValidator().isValidISBN13(isbn13)) {
      // Multiply the first 12 digits of the ISBN by 1 or 3 based on position.
      Integer sum = 0;
      Integer multiplier = 1;
      char [] digitArray = isbn13.toCharArray();
      for (char c : digitArray) {
        if (multiplier == 1) {
          sum += Character.getNumericValue(c) * multiplier;
          multiplier = THREE;        
        }
        else if (multiplier == THREE) {
          System.out.println(c + " * " + multiplier);
          sum += Character.getNumericValue(c) * multiplier;
          multiplier = 1;
        }
      }
      
      String sumString = "" + sum;
      
      return (sum % TEN == 0) ? isbn13.substring(3, isbn13.length() - 1).concat("0") 
             : isbn13.substring(3, isbn13.length() - 1).concat("" + sumString.charAt(sumString.length()));
    }
    else {
      return isbn13;
    }
  }
  
}
