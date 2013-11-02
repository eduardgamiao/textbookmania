package models;

/**
 * A Student object that represents a student.
 */
public class Student {
  private String firstName;
  private String lastName;
  private String email;
  private String avatarURL;
  
  /**
   * Constructor.
   * @param firstName Student's first name.
   * @param lastName Student's last name.
   * @param email Student's email (must be unique).
   * @param avatarURL URL to students avatar.
   */
  public Student(String firstName, String lastName, String email, String avatarURL) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setEmail(email);
    this.setAvatarURL(avatarURL);
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the avatarURL
   */
  public String getAvatarURL() {
    return avatarURL;
  }

  /**
   * @param avatarURL the avatarURL to set
   */
  public void setAvatarURL(String avatarURL) {
    this.avatarURL = avatarURL;
  }

}
