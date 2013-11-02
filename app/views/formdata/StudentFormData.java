package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Student;
import models.StudentDB;

/**
 * Form data for a Student.
 */
public class StudentFormData {
  
  /** Student's first name. */
  public String firstName = "";
  
  /** Student's last name. */
  public String lastName = "";
  
  /** Student's email (must be unique). */
  public String email = "";
  
  /** Student's avatar URL. */
  public String avatarURL = "";
  
  /**
   * Blank constructor.
   */
  public StudentFormData() {
    // TODO Auto-generated constructor stub
  }

  /**
   * Constructor.
   * @param firstName Student's first name.
   * @param lastName Student's last name.
   * @param email Student's email.
   * @param avatarURL Student's URL to their avatar.
   */
  public StudentFormData(String firstName, String lastName, String email, String avatarURL) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.avatarURL = avatarURL;
  }
  
  /**
   * Constructor.
   * @param student A Student object.
   */
  public StudentFormData(Student student) {
    this.firstName = student.getFirstName();
    this.lastName = student.getLastName();
    this.email = student.getEmail();
    this.email = student.getAvatarURL();
  }

  /**
   * Validation method for the StudentDataForm.
   * @return A List of errors (if they exist), otherwise null.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (this.firstName == null || this.firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First Name is required."));
    }
    if (this.lastName == null || this.lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last Name is required."));
    } 
    if (this.email == null || this.email.length() == 0) {
      errors.add(new ValidationError("email", "Email is required."));
    }
    if (StudentDB.isEmailTaken(this.email)) {
      errors.add(new ValidationError("email", "The email \"" + this.email + "\" is already taken."));
    }
    if (!(StudentDB.isEmailValid(this.email))) {
      errors.add(new ValidationError("email", "The email must contain the \"@\" and \".\" characters."));     
    }
    if (this.avatarURL == null || this.avatarURL.length() == 0) {
      errors.add(new ValidationError("avatarURL", "Avatar URL is required."));
    }
    if (!(this.avatarURL.endsWith(".jpg") || this.avatarURL.endsWith(".png") || this.avatarURL.endsWith(".gif"))) {
      errors.add(new ValidationError("avatarURL", "Avatar URL is required."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
  

}
