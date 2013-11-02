package controllers;

import java.util.List;
import java.util.Map;
import models.BuyOfferDB;
import models.SellOfferDB;
import models.StudentDB;
import models.TextbookDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.BuyOfferFormData;
import views.formdata.SellOfferFormData;
import views.formdata.StudentFormData;
import views.formdata.TextbookCondtion;
import views.formdata.TextbookFormData;
import views.html.Index;
import views.html.ManageBuyOffer;
import views.html.ManageSellOffer;
import views.html.ManageStudent;
import views.html.ManageTextbook;
import views.html.Students;
import views.html.Textbooks;
import views.html.BuyOffers;
import views.html.SellOffers;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns the show students page.
   * @return The show students page.
   */
  public static Result showStudents() {
    return ok(Students.render(StudentDB.getStudents()));
  }
  
  /**
   * Returns the show textbooks page.
   * @return The show textbooks page.
   */
  public static Result showTextbooks() {
    return ok(Textbooks.render(TextbookDB.getTextbooks()));
  }
  
  /**
   * Returns the showBuyOffers page.
   * @return The showBuyOffers page.
   */
  public static Result showBuyOffers() {
    return ok(BuyOffers.render(BuyOfferDB.getBuyOffers()));
  }
  
  /**
   * Returns the showSellOffers page.
   * @return The showSellOffers page.
   */
  public static Result showSellOffers() {
    return ok(SellOffers.render(SellOfferDB.getSellOffers()));
  }
  
  
  /**
   * The Student data form page.
   * @return The Student data form page.
   */
  public static Result newStudent() {
    StudentFormData data = new StudentFormData();
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("Add New Surfer", formData));
  }
  
  /**
   * The Textbook data form page.
   * @return The Textbook data form page.
   */
  public static Result newTextbook() {
    TextbookFormData data = new TextbookFormData();
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    List<String> conditions = TextbookCondtion.getCondition();
    return ok(ManageTextbook.render("Add New Textbook", formData, conditions));
  }
  
  /**
   * Render form for creating a new BuyOffer.
   * @return The BuyOffer data page.
   */
  public static Result newBuyOffer() {
    BuyOfferFormData data = new BuyOfferFormData();
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).fill(data);
    Map<String, Boolean> studentMap = StudentDB.getStudentNames();
    return ok(ManageBuyOffer.render("Add New Buy-Offer", formData, studentMap));
  }
  
  /**
   * Renders page after submitting form data.
   * @return The BuyOffer page.
   */
  public static Result postBuyOffer() {
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> studentMap = StudentDB.getStudentNames();
      return badRequest(ManageBuyOffer.render("Manage Buy-Offer", formData, studentMap));
    }
    else {
      BuyOfferFormData form = formData.get();
      BuyOfferDB.addBuyOffer(form);
      Map<String, Boolean> studentMap = StudentDB.getStudentNames(form.student.getEmail());
      return ok(ManageBuyOffer.render("Manage Student", formData, studentMap));
    } 
  }
  
  /**
   * Render form for creating a new SellOffer.
   * @return The SellOffer data page.
   */
  public static Result newSellOffer() {
    SellOfferFormData data = new SellOfferFormData();
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).fill(data);
    Map<String, Boolean> studentMap = StudentDB.getStudentNames();
    return ok(ManageSellOffer.render("Add New Sell-Offer", formData, studentMap));
  }
  
  /**
   * Renders page after submitting form data.
   * @return The SellOffer page.
   */
  public static Result postSellOffer() {
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> studentMap = StudentDB.getStudentNames();
      return badRequest(ManageSellOffer.render("Manage Sell-Offer", formData, studentMap));
    }
    else {
      SellOfferFormData form = formData.get();
      SellOfferDB.addSellOffer(form);
      Map<String, Boolean> studentMap = StudentDB.getStudentNames(form.student.getEmail());
      return ok(ManageSellOffer.render("Manage Sell-Offer", formData, studentMap));
    } 
  }
  /**
   * Renders page after submitting form data.
   * @return The Student page.
   */
  public static Result postStudent() {
    Form<StudentFormData> formData = Form.form(StudentFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      return badRequest(ManageStudent.render("Manage Student", formData));
    }
    else {
      StudentFormData form = formData.get();
      StudentDB.addStudent(form);
      return ok(ManageStudent.render("Manage Student", formData));
    } 
  }
  
  /**
   * Renders page after submitting form data.
   * @return The Textbook page.
   */
  public static Result postTextbook() {
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).bindFromRequest();
    List<String> conditions = TextbookCondtion.getCondition();
    if (formData.hasErrors()) {
      return badRequest(ManageTextbook.render("Manage Textbook", formData, conditions));
    }
    else {
      TextbookFormData form = formData.get();
      TextbookDB.addTextbook(form);
      return ok(ManageTextbook.render("Manage Textbook", formData, conditions));
    } 
  }
   
}
