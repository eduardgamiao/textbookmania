package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.SellOfferFormData;

/**
 * An Object representing a Student's want to sell a Textbook.
 * @author Alvin Wang
 *
 */
public class SellOfferDB {

  private static List<SellOffer> sellOffers = new ArrayList<SellOffer>();
  
  /**
   * Add a SellOffer to the database.
   * @param formData SellOffer data from the form.
   * @return THe SellOffer
   */
  public static SellOffer addSellOffer(SellOfferFormData formData) {
    SellOffer offer = new SellOffer(formData.student, formData.textbook, formData.price, formData.expirationDate);
    sellOffers.add(offer);
    return offer;
  }
  
  /**
   * Check if a number is an Integer.
   * @param price Integer to check (comes in as a String).
   * @return True if the number is an Integer, false otherwise.
   */
  public static boolean isInteger(String price) {
    try {
      Integer.parseInt(price);
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }
}
