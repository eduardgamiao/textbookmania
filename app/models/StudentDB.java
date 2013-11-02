package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.StudentFormData;

/**
 * A database of Students.
 */
public class StudentDB {

  private static Map<String, Student> students = new HashMap<String, Student>();
  
  /**
   * Add a Student to the database.
   * @param formData Data from the Student Form entry.
   * @return The Student that was added.
   */
  public static Student addStudent(StudentFormData formData) {
    Student student = new Student(formData.firstName, formData.lastName, formData.email, formData.avatarURL);
    students.put(student.getEmail(), student);
    return student;
  }
  
  /**
   * Return a List of Students.
   * @return A List of Students.
   */
  public static List<Student> getStudents() {
    return new ArrayList<Student>(students.values());
  }
  
  /**
   * Return a Student that matches the given email.
   * @param email The email of the Student to get.
   * @return The Student with the matching email.
   */
  public static Student getStudent(String email) {
    return students.get(email);
  }
  
  /**
   * Checks if an email exists in the database.
   * @param email The email to check.
   * @return True if the email is already used, false otherwise.
   */
  public static boolean isEmailTaken(String email) {
    return students.containsKey(email);
  }
  
  /**
   * Checks if an email is valid.
   * @param email The email to check.
   * @return True if the email is valid, false otherwise.
   */
  public static boolean isEmailValid(String email) {
    return email.contains("@") && email.contains(".");
  }
}
