package views.formdata;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the condition of a textbook.
 * @author Alvin Wang
 *
 */
public class TextbookCondtion {

  /**
   * Provides a list of conditions for use in form display.
   * @return A list of conditions.
   */
  public static List<String> getCondition() {
    String[] condition = {"Excellent", "Good", "Fair", "Poot"};
    return Arrays.asList(condition);
  }
}
