package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Textbook;
import models.TextbookDB;

/**
 * Form data for a textbook.
 * @author Alvin Wang
 *
 */
public class TextbookFormData {

  /** The textbook's title. */
  public String title = "";
  /** The textbook's author. */
  public String author = "";
  /** The textbook's ISBN. */
  public String isbn = "";
  /** The textbook's condition. */
  public String condition = "";
  /** Textbook image URL. */
  public String textbookURL = "";
  /** If Textbook page is editing. */
  public boolean isEditing = false;
  
  /**
   * Empty constructor.
   */
  public TextbookFormData() {
    
  }
  
  /**
   * Constructor that creates a TextbookFormData from an existing textbook.
   * @param textbook An existing textbook.
   */
  public TextbookFormData(Textbook textbook) {
    this.title = textbook.getTitle();
    this.author = textbook.getAuthor();
    this.isbn = textbook.getIsbn();
    this.condition = textbook.getCondition();
    this.textbookURL = textbook.getTextbookURL();
    this.isEditing = true;
  }
  
  /**
   * Constructor for a TextbookFormData. Used for initialization.
   * @param title The textbook title.
   * @param author The textbook author.
   * @param isbn The textbook ISBN.
   * @param condition The textbook condition.
   * @param textbookURL Image URL for textbook.
   */
  public TextbookFormData(String title, String author, String isbn, String condition, String textbookURL) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.condition = condition;
    this.textbookURL = textbookURL;
  }
  
  /**
   * Validation method for TextbookFormData.
   * @return A list of errors (if they exist), otherwise null.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (this.title == null || this.title.length() == 0) {
      errors.add(new ValidationError("title", "Title is required."));
    }
    
    if (this.author == null || this.author.length() == 0) {
      errors.add(new ValidationError("author", "Author is required."));
    }
    
    if (this.isbn == null || this.isbn.length() == 0) {
      errors.add(new ValidationError("isbn", "ISBN is required."));
    }
    
    if (TextbookDB.doesIsbnExist(this.isbn) && !isEditing) {
      errors.add(new ValidationError("isbn", "ISBN '" + this.isbn + "' already exists."));
    }
    
    if (this.condition == null || this.condition.length() == 0) {
      errors.add(new ValidationError("condition", "Condition is required."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
}
