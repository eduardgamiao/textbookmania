package controllers;

import java.util.Map;
import models.StudentDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.StudentFormData;
import views.html.Index;
import views.html.ManageStudent;

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
   * The Student data form page.
   * @return The Student data form page.
   */
  public static Result newStudent() {
    StudentFormData data = new StudentFormData();
    Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(data);
    return ok(ManageStudent.render("Add New Surfer", formData));
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
  
}
