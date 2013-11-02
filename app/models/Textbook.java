package models;

/** 
 * A textbook object that represents a textbook.
 * @author Alvin Wang
 *
 */
public class Textbook {

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
   * @param textbookURL The image URL for textbook.
   */
  public Textbook(String title, String author, String isbn, String condition, String textbookURL) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.condition = condition;
    this.textbookURL = textbookURL;
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
}
