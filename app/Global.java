import models.StudentDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.StudentFormData;

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
    // Add Surfers.
    StudentDB.addStudent(new StudentFormData("Eduard", "Gamiao", "eduard@hawaii.edu", "http://s.gravatar.com"
        + "/avatar/7435fbb221d3302b55a396cab93b2149?s=80"));
  }  
  
}
