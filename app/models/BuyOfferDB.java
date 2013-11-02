package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.BuyOfferFormData;

/**
 * A database of BuyOffers.
 */
public class BuyOfferDB {
  
  private static List<BuyOffer> buyOffers = new ArrayList<BuyOffer>();
  
  /**
   * Add a BuyOffer to the database.
   * @param formData BuyOffer data from the form.
   * @return The BuyOffer.
   */
  public static BuyOffer addBuyOffer(BuyOfferFormData formData) {
    BuyOffer offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate);
    buyOffers.add(offer);
    return offer;
  }
  
  /**
   * Returns a list of BuyOffers.
   * @return A list of BuyOffers.
   */
  public static List<BuyOffer> getBuyOffers() {
    return buyOffers;
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
