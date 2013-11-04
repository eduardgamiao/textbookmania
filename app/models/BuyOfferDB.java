package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
   * 
   * @param formData BuyOffer data from the form.
   * @return The BuyOffer.
   */
  public static BuyOffer addBuyOffer(BuyOfferFormData formData) {
    BuyOffer offer;
    if (formData.id == 0) {
      long id = buyOffers.size() + 1;
      offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, id);
      buyOffers.put(id, offer);
      return offer;
    }
    else {
      offer = new BuyOffer(formData.student, formData.textbook, formData.price, formData.expirationDate, formData.id);
      buyOffers.put(offer.getId(), offer);
      return offer;
    }
  }

  /**
   * Returns a list of BuyOffers.
   * 
   * @return A list of BuyOffers.
   */
  public static List<BuyOffer> getBuyOffers() {
    return new ArrayList<BuyOffer>(buyOffers.values());
  }

  /**
   * Returns a BuyOffer associated with the passed in ID.
   * 
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
   * Returns a list of BuyOffers that match a book.
   * 
   * @param book Book to be matched.
   * @return A list of BuyOffers.
   * @throws ParseException Thrown when date is an invalid format.
   */
  public static List<BuyOffer> getBuyOffersByBook(String book) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = null;
    List<BuyOffer> offer = new ArrayList<BuyOffer>();
    List<BuyOffer> allOffers = new ArrayList<>(buyOffers.values());
    for (BuyOffer currentOffer : allOffers) {
      currentDate = new Date();
      Date expirationDate = dateFormat.parse(currentOffer.getExpirationDate());
      if (currentOffer.getTextbookName().equals(book) && currentDate.before(expirationDate)) {
        offer.add(currentOffer);
      }
    }
    return offer;
  }

  /**
   * Returns a list of BuyOffers that matches the Student's BuyOffers.
   * 
   * @param student The Student.
   * @return The list of BuyOffers that match a Student's BuyOffers.
   * @throws ParseException Thrown when date is not a valid format.
   */
  public static List<BuyOffer> getMatchedBuyOffers(String student) throws ParseException {
    List<SellOffer> studentSellOffers = SellOfferDB.getSellOffersByStudent(student);
    List<BuyOffer> matchedBuyOffers = new ArrayList<BuyOffer>();
    for (SellOffer sellOffer : studentSellOffers) {
      matchedBuyOffers.addAll(BuyOfferDB.getBuyOffersByBook(sellOffer.getTextbook()));
    }
    Collections.sort(matchedBuyOffers, new BuyPriceComparator());
    return matchedBuyOffers;
  }

  /**
   * Deletes a BuyOffer of the passed in ID.
   * 
   * @param id The ID.
   */
  public static void deleteBuyOffer(long id) {
    buyOffers.remove(id);
  }

  /**
   * Check if a number is an Integer.
   * 
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

  /**
   * Return the email address of the Student.
   * @param buyOffer The BuyOffer to extract from.
   * @return The email of the Student.
   */
  public static String extractEmail(BuyOffer buyOffer) {
    if (buyOffer.getStudentName().contains("@") && buyOffer.getStudentName().contains(".")) {
      String[] split = buyOffer.getStudentName().split(" ");
      if (split.length > 0) {
        String email = split[split.length - 1];
        return email.substring(1, email.length() - 1);
      }
    }
    return "";
  }
}

/**
 * Class to sort ArrayList<BuyOffer> by price.
 * 
 * @author eduardgamiao
 * 
 */
class BuyPriceComparator implements Comparator<BuyOffer> {

  @Override
  public int compare(BuyOffer bo1, BuyOffer bo2) {
    if (bo1.getPrice() < bo2.getPrice()) {
      return -1;
    }
    else if (bo1.getPrice() > bo2.getPrice()) {
      return 1;
    }
    else {
      return 0;
    }
  }
}
