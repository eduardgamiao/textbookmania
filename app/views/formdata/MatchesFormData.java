package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;
import models.Student;
import models.StudentDB;

/**
 * Form data for the Matches page.
 */
public class MatchesFormData {

  /** Email of the Student. */
  public String studentEmail = "";
  
  /**
   * Empty constructor.
   */
  public MatchesFormData() {
    
  }
  
  /**
   * Constructor for new Matches.
   * @param studentEmail Email of the Student.
   */
  public MatchesFormData(String studentEmail) {
    this.studentEmail = studentEmail;
  }
  
  /**
   * Constructor for existing.
   * @param student An existing Student.
   */
  public MatchesFormData(Student student) {
    this.studentEmail = student.getEmail();
  }
  
  /**
   * Validation method for the StudentDataForm.
   * @return A List of errors (if they exist), otherwise null.
   */
  public List<ValidationError> validate() {    
    List<ValidationError> errors = new ArrayList<ValidationError>();
    
    if (StudentDB.isEmailTaken(this.studentEmail)) {
      errors.add(new ValidationError("studentEmail", "The Student does not exist."));
    }
   
    return errors.isEmpty() ? null : errors;
  }
  
}
