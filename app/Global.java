import models.StudentDB;
import models.TextbookDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.StudentFormData;
import views.formdata.TextbookFormData;

/**
 * Implements a Global object for the Play Framework.
 * @author eduardgamiao
 *
 */
public class Global extends GlobalSettings {

  /**
   * Initialization method for this Play Framework web application.
   * @param app A Play Framework application.
   */
  public void onStart(Application app) {
    // Add Students.
    StudentDB.addStudent(new StudentFormData("Eduard", "Gamiao", "eduard@hawaii.edu", "http://s.gravatar.com"
        + "/avatar/7435fbb221d3302b55a396cab93b2149?s=80"));
    
    StudentDB.addStudent(new StudentFormData("Alvin", "Wang", "alvinw@hawaii.edu", "https://en.gravatar.com/"
        + "userimage/54501069/d2cf47994deac7bc9288c1cc1a17c879.png"));
    
    // Add Textbooks.
    TextbookDB.addTextbook(new TextbookFormData("Introduction to Algorithms", "Thomas Cormen", 
                                                "0262033844", "Fair"));
    
    TextbookDB.addTextbook(new TextbookFormData("Digital Logic Design: A Rigorous Approach", "Guy Even and Moti "
                                                + "Medina", "1107027535", "Poor"));
  }  
  
}
