package models;

/** 
 * A textbook object that represents a textbook.
 * @author Alvin Wang
 *
 */
public class Textbook {
  private static final Integer ISBN10 = 10;
  private static final Integer ISBN13 = 13; 
  private static final Integer THREE = 3; // For CheckStyle.
  private static final Integer ELEVEN = 11;
  private static final Integer NINE = 9;
  
  /** The title of the textbook. */
  private String title;
  /** The author of the textbook. */
  private String author;
  /** The ISBN number. */
  private String isbn;
  /** The condition of the textbook. */
  private String condition;
  /** Textbook URL. */
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
    productCode = productCode.trim();
    String frontURLPart = "http://images.amazon.com/images/P/";
    String backURLPart = ".01._PE20_SCMZZZZZZZ_.jpg";
    if (productCode.length() == ISBN10) {
      return frontURLPart + productCode + backURLPart;
    }
    else if (productCode.length() == ISBN13) {
      productCode = convertToISBN10(productCode);
      return frontURLPart + productCode.substring(THREE, productCode.length()) + backURLPart;
    }
    else {
      return productCode;
    }
  }
  
  /**
   * Convert a ISBN13 to an ISBN10.
   * @param isbn13 The ISBN to be converted.
   * @return A ISBN10 from the ISBN13.
   */
  public static String convertToISBN10(String isbn13) {
    String isbn10 = isbn13.substring(THREE, NINE);
    int checksum = 0;
    int weight = ISBN10;

    for (char c : isbn10.toCharArray()) {
      checksum += (int) Character.getNumericValue(c) * weight;
      weight--;
    }

    checksum = ELEVEN - (checksum % ELEVEN);
    if (checksum == ISBN10) {
      isbn10 += "X";
    }
    else if (checksum == ELEVEN) {
      isbn10 += "0";
    }  
    else {
      isbn10 += checksum;
    }

    return isbn10;
  }
}
