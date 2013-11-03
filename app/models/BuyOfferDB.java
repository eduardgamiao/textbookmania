package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.BuyOfferFormData;

/**
 * A database of BuyOffers.
 */
public class BuyOfferDB {
  
  private static Map<Long, BuyOffer> buyOffers = new HashMap<>();
  
  /**
   * Add a BuyOffer to the database.
   * @param formData BuyOffer data from the form.
   * @return The BuyOffer.
   */
  public static BuyOffer addBuyOffer(BuyOfferFormData formData) {
    long idVal = (formData.id == 0) ? buyOffers.size() + 1 : formData.id;
    BuyOffer offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, idVal);
    buyOffers.put(idVal, offer);
    return offer;
  }
  
  /**
   * Returns a list of BuyOffers.
   * @return A list of BuyOffers.
   */
  public static List<BuyOffer> getBuyOffers() {
    return new ArrayList<>(buyOffers.values());
  }
  
  /**
   * Returns a BuyOffer associated with the passed in ID.
   * @param id The ID.
   * @return The retrieved BuyOffer.
   */
  public static BuyOffer getBuyOffer(long id) {
    BuyOffer offer = buyOffers.get(id);
    if (offer == null) {
      throw new RuntimeException("Passed a bad id: " + id);
    }
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
