package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.TextbookFormData;

/**
 * A database of textbooks.
 * @author Alvin Wang
 *
 */
public class TextbookDB {
  
  private static Map<String, Textbook> textbooks = new HashMap<String, Textbook>();
  
  /**
   * Add a textbook to the database.
   * @param formData Data from the Textbook form data.
   * @return The textbook added.
   */
  public static Textbook addTextbook(TextbookFormData formData) {
    Textbook textbook = new Textbook(formData.title, formData.author, formData.isbn, formData.condition, 
        formData.textbookURL);
    textbooks.put(textbook.getIsbn(), textbook);
    return textbook;
  }
  
  /**
   * Returns a List of textbooks.
   * @return A list of textbooks.
   */
  public static List<Textbook> getTextbooks() {
    return new ArrayList<Textbook>(textbooks.values());
  }
  
  /**
   * Returns a textbook that matches the given ISBN.
   * @param isbn The textbook's ISBN.
   * @return Textbook with matching ISBN.
   */
  public static Textbook getTextbook(String isbn) {
    return textbooks.get(isbn);
  }
  
  /**
   * Checks if a ISBN exists in the database.
   * @param isbn The ISBN to check.
   * @return True if ISBN already exists, false otherwise.
   */
  public static boolean doesIsbnExist(String isbn) {
    return textbooks.containsKey(isbn);
  }
  
  public static Map<String, Boolean> getTextbookNames() {
    Map<String, Boolean> bookMap = new HashMap<String, Boolean>();
    List<Textbook> textbooks = getTextbooks();
    for (Textbook textbook : textbooks) {
      bookMap.put(textbook.getTitle() + " (" + textbook.getIsbn() + ")", false);
    }
    return bookMap;
  }
  
  public static Map<String, Boolean> getTextbookNames(String isbn) {
    Map<String, Boolean> bookMap = getTextbookNames();
    if(textbooks.containsKey(isbn)) {
      bookMap.put(isbn, true);
    }
    return bookMap;
  }
}
