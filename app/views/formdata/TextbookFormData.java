package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Textbook;
import models.TextbookDB;

/**
 * Form data for a textbook.
 * 
 * @author Alvin Wang
 * 
 */
public class TextbookFormData {
  private static final Integer ISBN10 = 10;
  private static final Integer ISBN13 = 13;
  private static final Integer TEN = 10; // For CheckStyle.
  private static final Integer ZERO = 0; // For CheckStyle.
  private static final Integer THREE = 3; // For CheckStyle.
  private static final Integer ELEVEN = 11; // For CheckStyle.

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
   * 
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
   * 
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
   * 
   * @return A list of errors (if they exist), otherwise null.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();

    if (this.title == null || this.title.length() == 0) {
      errors.add(new ValidationError("title", "Title is required."));
    }

    if (TextbookDB.isTitleUnique(this.title.trim())) {
      errors.add(new ValidationError("title", "The Title \"" + this.title + "\" already exists."));
    }

    if (this.author == null || this.author.length() == 0) {
      errors.add(new ValidationError("author", "Author is required."));
    }

    if (this.isbn == null || this.isbn.length() == 0) {
      errors.add(new ValidationError("isbn", "ISBN is required."));
    }

    if (!isNumeric(this.isbn)) {
      errors.add(new ValidationError("isbn", "ISBN needs consists of numbers only."));
    }

    if (!((this.isbn.length() != ISBN10 && this.isbn.length() == ISBN13) || (this.isbn.length() != ISBN13 && this.isbn
        .length() == ISBN10))) {
      errors.add(new ValidationError("isbn", "ISBN requires a length of 10 or 13."));
    }
    
    if (!isISBNValid(this.isbn)) {
      errors.add(new ValidationError("isbn", "The ISBN \"" + this.isbn + "\" is not valid."));      
    }

    if (TextbookDB.doesIsbnExist(this.isbn) && !isEditing) {
      errors.add(new ValidationError("isbn", "ISBN '" + this.isbn + "' already exists."));
    }

    if (this.condition == null || this.condition.length() == 0) {
      errors.add(new ValidationError("condition", "Condition is required."));
    }

    return errors.isEmpty() ? null : errors;
  }

  /**
   * Check if a String consists of only numbers.
   * 
   * @param input The String to check.
   * @return True if the String is all numbers, false otherwise.
   */
  private boolean isNumeric(String input) {
    return this.isbn.matches("[0-9]+");
  }

  /**
   * Check if a ISBN is valid.
   * 
   * @param isbn The ISBN to check.
   * @return True if it is valid, false otherwise.
   */
  private static boolean isISBNValid(String isbn) {
    if (isbn.length() == ISBN10) {
      Integer a = 0;
      Integer b = 0;
      Integer strLength = isbn.length();
      for (int i = 0; i < strLength; i++) {
        a += Integer.valueOf(isbn.substring(i, i + 1));
        b += a;
      }
      return b % ELEVEN == ZERO;
    }
    else if (isbn.length() == ISBN13) {
      int check = 0;
      int strLength = ISBN13 - 1;
      for (int i = 0; i < strLength; i += 2) {
        check += Integer.valueOf(isbn.substring(i, i + 1));
      }
      for (int i = 1; i < strLength; i += 2) {
        check += Integer.valueOf(isbn.substring(i, i + 1)) * THREE;
      }
      check += Integer.valueOf(isbn.substring(strLength));
      return check % TEN == ZERO;
    }
    else {
      return false;
    }
  }
 }

