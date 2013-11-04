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
   * @throws ParseException Thrown when date is an invalid format.
   */
  public static List<SellOffer> getSellOffersByBook(String book) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = null;
    List<SellOffer> offer = new ArrayList<SellOffer>();
    List<SellOffer> allOffers = new ArrayList<>(sellOffers.values());
    for (SellOffer currentOffer : allOffers) {
      currentDate = new Date();
      Date expirationDate = dateFormat.parse(currentOffer.getExpirationDate());
      if (currentOffer.getTextbook().equals(book)  && currentDate.before(expirationDate)) {
        offer.add(currentOffer);
      }
    }
    return offer;
  }
  
  /**
   * Returns a list of SellOffers by a student.
   * 
   * @param student The Student.
   * @return The list of SellOffers from student.
   * @throws ParseException Thrown when date is an invalid format.
   */
  public static List<SellOffer> getSellOffersByStudent(String student) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date currentDate = null;
    List<SellOffer> offerForStudent = new ArrayList<SellOffer>();
    List<SellOffer> allSellOffers = SellOfferDB.getSellOffers();
    for (SellOffer currentOffer : allSellOffers) {
      currentDate = new Date();
      Date expirationDate = dateFormat.parse(currentOffer.getExpirationDate());
      if (currentOffer.getStudent().equals(student)  && currentDate.before(expirationDate)) {
        offerForStudent.add(currentOffer);
      }
    }
    return offerForStudent;
  }
  
  /**
   * Returns a list of SellOffers that matches the Student's BuyOffers.
   * @param student The Student.
   * @return The list of SellOffers that match a Student's BuyOffers.
   * @throws ParseException Thrown when date is not a valid format.
   */
  public static List<SellOffer> getMatchedSellOffers(String student) throws ParseException {
    List<BuyOffer> studentBuyOffers = BuyOfferDB.getBuyOffersByStudent(student);
    List<SellOffer> matchedSellOffers = new ArrayList<SellOffer>();
    for (BuyOffer buyOffer : studentBuyOffers) {
      matchedSellOffers.addAll(SellOfferDB.getSellOffersByBook(buyOffer.getTextbookName()));
    }
    Collections.sort(matchedSellOffers, new SellPriceComparator());
    return matchedSellOffers;
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

/**
 * Class to sort ArrayList<BuyOffer> by price.
 * @author eduardgamiao
 *
 */
class SellPriceComparator implements Comparator<SellOffer> {

  @Override
  public int compare(SellOffer o1, SellOffer o2) {
    if (o1.getPrice() < o2.getPrice()) {
      return -1;
    }
    else if (o1.getPrice() > o2.getPrice()) {
      return 1;
    }
    else {
      return 0;
    }
  } 
}