package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    BuyOffer offer;
    if (formData.id == 0) {
      System.out.println("Adding " + formData.student + " " + formData.textbook);
      long id = buyOffers.size() + 1;
      offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, id);
      buyOffers.put(id, offer);
      return offer;
    }
    else {
      System.out.println("Adding " + formData.student + " " + formData.textbook);
      offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, formData.id);
      buyOffers.put(offer.getId(), offer);
      return offer;      
    }
  }
  
  /**
   * Returns a list of BuyOffers.
   * @return A list of BuyOffers.
   */
  public static List<BuyOffer> getBuyOffers() {
    return new ArrayList<BuyOffer>(buyOffers.values());
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
   * Returns a list of BuyOffers by a student.
   * 
   * @param student The Student.
   * @return The list of BuyOffers from student.
   * @throws ParseException Thrown when date is not in valid format.
   */
  public static List<BuyOffer> getBuyOffersByStudent(String student) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = null;
    List<BuyOffer> offerForStudent = new ArrayList<BuyOffer>();
    List<BuyOffer> allBuyOffers = BuyOfferDB.getBuyOffers();
    for (BuyOffer currentOffer : allBuyOffers) {
      currentDate = new Date();
      Date expirationDate = dateFormat.parse(currentOffer.getExpirationDate());
      if (currentOffer.getStudentName().equals(student) && currentDate.before(expirationDate)) {
        offerForStudent.add(currentOffer);
      }
    }
    return offerForStudent;
  }
  
  /**
   * Deletes a BuyOffer of the passed in ID.
   * @param id The ID.
   */
  public static void deleteBuyOffer(long id) {
    buyOffers.remove(id);
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
