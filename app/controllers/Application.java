package controllers;

import java.util.List;
import java.util.Map;
import models.BuyOffer;
import models.BuyOfferDB;
import models.SellOffer;
import models.SellOfferDB;
import models.StudentDB;
import models.TextbookDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.BuyOfferFormData;
import views.formdata.MatchesFormData;
import views.formdata.SellOfferFormData;
import views.formdata.StudentFormData;
import views.formdata.TextbookCondtion;
import views.formdata.TextbookFormData;
import views.html.Index;
import views.html.ManageBuyOffer;
import views.html.ManageSellOffer;
import views.html.ManageStudent;
import views.html.ManageTextbook;
import views.html.ManageMatches;
import views.html.Matches;
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
    return ok(ManageStudent.render("Add New Surfer", formData, false));
  }
  
  /**
   * The Textbook data form page.
   * @return The Textbook data form page.
   */
  public static Result newTextbook() {
    TextbookFormData data = new TextbookFormData();
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    List<String> conditions = TextbookCondtion.getCondition();
    return ok(ManageTextbook.render("Add New Textbook", formData, conditions, false));
  }
  
  /**
   * Render form for creating a new BuyOffer.
   * @return The BuyOffer data page.
   */
  public static Result newBuyOffer() {
    BuyOfferFormData data = new BuyOfferFormData();
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).fill(data);
    Map<String, Boolean> studentMap = StudentDB.getStudentNames();
    Map<String, Boolean> bookMap = TextbookDB.getTextbookNames();
    return ok(ManageBuyOffer.render("Add New Buy-Offer", formData, studentMap, bookMap));
  }
  
  /**
   * Renders page after submitting form data.
   * @return The BuyOffer page.
   */
  public static Result postBuyOffer() {
    Form<BuyOfferFormData> formData = Form.form(BuyOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> studentMap = StudentDB.getStudentNames();
      Map<String, Boolean> bookMap = TextbookDB.getTextbookNames();
      return badRequest(ManageBuyOffer.render("Manage Buy-Offer", formData, studentMap, bookMap));
    }
    else {
      BuyOfferFormData form = formData.get();
      BuyOfferDB.addBuyOffer(form);
      //Map<String, Boolean> studentMap = StudentDB.getStudentNames(form.student);
      //Map<String, Boolean> bookMap = TextbookDB.getTextbookNames(form.textbook);
      return ok(BuyOffers.render(BuyOfferDB.getBuyOffers()));
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
    Map<String, Boolean> bookMap = TextbookDB.getTextbookNames();
    return ok(ManageSellOffer.render("Add New Sell-Offer", formData, studentMap, bookMap));
  }
  
  /**
   * Renders page after submitting form data.
   * @return The SellOffer page.
   */
  public static Result postSellOffer() {
    Form<SellOfferFormData> formData = Form.form(SellOfferFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> studentMap = StudentDB.getStudentNames();
      Map<String, Boolean> bookMap = TextbookDB.getTextbookNames();
      return badRequest(ManageSellOffer.render("Manage Sell-Offer", formData, studentMap, bookMap));
    }
    else {
      SellOfferFormData form = formData.get();
      SellOfferDB.addSellOffer(form);
     // Map<String, Boolean> studentMap = StudentDB.getStudentNames(form.student);
     // Map<String, Boolean> bookMap = TextbookDB.getTextbookNames();
      return ok(SellOffers.render(SellOfferDB.getSellOffers()));
    } 
  }
  /**
   * Renders page after submitting form data.
   * @return The Student page.
   */
  public static Result postStudent() {
    Form<StudentFormData> formData = Form.form(StudentFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      return badRequest(ManageStudent.render("Manage Student", formData, false));
    }
    else {
      StudentFormData form = formData.get();
      StudentDB.addStudent(form);
      return ok(Students.render(StudentDB.getStudents()));
    } 
  }
  
  /**
   * Renders page for editing a Student.
   * @param email Email of the Student to edit.
   * @return The Student form.
   */
  public static Result manageStudent(String email) {
    if (StudentDB.isEmailTaken(email)) {
      StudentFormData data = new StudentFormData(StudentDB.getStudent(email));
      Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
      return ok(ManageStudent.render("Manage Student", formData, true));
    }
    else {
      return badRequest(Index.render("nope.avi"));
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
      return badRequest(ManageTextbook.render("Manage Textbook", formData, conditions, false));
    }
    else {
      TextbookFormData form = formData.get();
      TextbookDB.addTextbook(form);
      return ok(Textbooks.render(TextbookDB.getTextbooks()));
    } 
  }
  
  /**
   * Renders page for editing a Textbook.
   * @param isbn ISBN of textbook to edit.
   * @return The Textbook form.
   */
  public static Result manageTextbook(String isbn) {
    TextbookFormData data = new TextbookFormData(TextbookDB.getTextbook(isbn));
    Form<TextbookFormData> formData = Form.form(TextbookFormData.class).fill(data);
    List<String> conditions = TextbookCondtion.getCondition();
    return ok(ManageTextbook.render("Manage Textbook", formData, conditions, true));
  }
  
  
  /**
   * Renders the Matches form.
   * @return The Matches form.
   */
  public static Result matches() {
    MatchesFormData data = new MatchesFormData();
    Form<MatchesFormData> formData = Form.form(MatchesFormData.class).fill(data);
    Map<String, Boolean> studentMap = StudentDB.getStudentNames();
    return ok(ManageMatches.render(formData, studentMap));
  }
  
  /**
   * Renders the Matches page.
   * @return The Matches page.
   */
  public static Result postMatches() {
    Form<MatchesFormData> formData = Form.form(MatchesFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      Map<String, Boolean> studentMap = StudentDB.getStudentNames();
      return badRequest(ManageMatches.render(formData, studentMap));
    }
    else {
      MatchesFormData data = formData.get();
      List<BuyOffer> buyOffers = BuyOfferDB.getBuyOffers();
      List<SellOffer> sellOffers = SellOfferDB.getSellOffers();
      String email = data.studentEmail.substring(data.studentEmail.indexOf('(') + 1, data.studentEmail.indexOf(')'));     
      return ok(Matches.render(data.studentEmail, email, buyOffers, sellOffers));
    }
  }
}
