package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SellOfferFormData;

/**
 * An Object representing a Student's want to sell a Textbook.
 * @author Alvin Wang
 *
 */
public class SellOfferDB {

  private static Map<Long, SellOffer> sellOffers = new HashMap<>();
  
  /**
   * Add a SellOffer to the database.
   * @param formData SellOffer data from the form.
   * @return THe SellOffer
   */
  public static SellOffer addSellOffer(SellOfferFormData formData) {
    SellOffer offer;
    if (formData.id == 0) {
      //System.out.println("There!");
      long id = sellOffers.size() + 1;
      offer = new SellOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, id);
      sellOffers.put(id, offer);
      return offer;
    }
    else {
      //System.out.println("Here!");
      offer = new SellOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, formData.id);
      sellOffers.put(offer.getId(), offer);
      return offer;      
    }
  }
  
  /**
   * Returns a list of SellOffers.
   * @return A list of SellOffers.
   */
  public static List<SellOffer> getSellOffers() {
    return new ArrayList<>(sellOffers.values());
  }

  /**
   * Returns a list of SellOffers that match a book.
   * @param book Book to be matched.
   * @return A list of SellOffers.
   */
  public static List<SellOffer> getSellOffers(String book) {
    List<SellOffer> offer = new ArrayList<SellOffer>();
    List<SellOffer> allOffers = new ArrayList<>(sellOffers.values());
    for (SellOffer currentOffer : allOffers) {
      if (currentOffer.getTextbook().equals(book)) {
        offer.add(currentOffer);
      }
    }
    return offer;
  }
  
  /**
   * Returns a SellOffer associated with the passed in ID.
   * @param id The ID.
   * @return The retrieved SellOffer.
   */
  public static SellOffer getSellOffer(long id) {
    SellOffer offer = sellOffers.get(id);
    if (offer == null) {
      throw new RuntimeException("Passed a bad id: " + id);
    }
    return offer;
  }
  
  /**
   * Deletes a SellOffer of the passed in ID.
   * @param id The ID.
   */
  public static void deleteSellOffer(long id) {
    sellOffers.remove(id);
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
