import models.BuyOfferDB;
import models.SellOfferDB;
import models.StudentDB;
import models.TextbookDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.BuyOfferFormData;
import views.formdata.SellOfferFormData;
import views.formdata.StudentFormData;
import views.formdata.TextbookFormData;

/**
 * Implements a Global object for the Play Framework.
 * 
 * @author eduardgamiao
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Initialization method for this Play Framework web application.
   * 
   * @param app A Play Framework application.
   */
  public void onStart(Application app) {
    // Add Students.
    StudentDB.addStudent(new StudentFormData("Eduard", "Gamiao", "eduard@hawaii.edu", "http://s.gravatar.com"
        + "/avatar/7435fbb221d3302b55a396cab93b2149?s=80"));

    StudentDB.addStudent(new StudentFormData("Alvin", "Wang", "alvinw@hawaii.edu", "https://en.gravatar.com/"
        + "userimage/54501069/d2cf47994deac7bc9288c1cc1a17c879.png"));

    // Add Textbooks.
    TextbookDB.addTextbook(new TextbookFormData("Java Concepts: Compatible with Java 5, 6 and 7", "Cay S. Hortsmann",
        "0470509473", "Excellent"));

    TextbookDB.addTextbook(new TextbookFormData("Discrete Mathematics and Its Applications", "Kenneth Rosen",
        "0073383090", "Good"));
    
    TextbookDB.addTextbook(new TextbookFormData("Data Structures: Abstraction and Design Using Java", 
        "Elliot Koffman, Paul A. T. Wolfgang", "0470128704", "Fair"));
    
    TextbookDB.addTextbook(new TextbookFormData("C Programming Language", "Brian Kernighan, Dennis Ritchie",
        "0131103628", "Poor"));
    
    TextbookDB.addTextbook(new TextbookFormData("C++ Primer Plus", "Stephen Prata",
        "0321776402", "Excellent"));
    
    TextbookDB.addTextbook(new TextbookFormData("Programming Language Pragmatics", "Michael L. Scott",
        "0123745144", "Good"));

    TextbookDB.addTextbook(new TextbookFormData("Land of Lisp: Learn to Program in Lisp, One Game at a Time!", 
        "Conrad Barski", "1593272812", "Fair"));
    
    TextbookDB.addTextbook(new TextbookFormData("Database Systems: The Complete Book", 
        "Hector-Garcia Molina, Jeffery D. Ullman, Jennifer Widom", "0131873253", "Poor"));

    TextbookDB.addTextbook(new TextbookFormData("Operating System Concepts", 
        "Abraham Silberschatz, Peter B. Galvin, Greg Gagne", "1118063333", "Excellent"));
    
    TextbookDB.addTextbook(new TextbookFormData("Ethics for the Information Age", 
        "Mike Quinn", "0132855534", "Good"));
    
    TextbookDB.addTextbook(new TextbookFormData("Emotional Design: Why We Love (or Hate) Everyday Things", 
        "Don Norman", "0465051367", "Fair"));
    
    TextbookDB.addTextbook(new TextbookFormData("Presenting to Win: The Art of Telling Your Story, Updated and Expanded"
        + " Edition", "Jerry Weissman", "0137144172", "Excellent"));
    
    TextbookDB.addTextbook(new TextbookFormData("The Design of Everyday Things", 
        "Don Norman", "0465067107", "Poor"));
    
    TextbookDB.addTextbook(new TextbookFormData("Artifical Intelligence for Games", 
        "Ian Millington", "0123747317", "Good"));
    
    TextbookDB.addTextbook(new TextbookFormData("Introduction to Algorithms", "Thomas Cormen", "0262033844", "Fair"));

    TextbookDB.addTextbook(new TextbookFormData("Digital Logic Design: A Rigorous Approach", "Guy Even and Moti "
        + "Medina", "1107027535", "Poor"));
    
    TextbookDB.addTextbook(new TextbookFormData("Operating System Concepts [Loose Leaf]", 
        "Abraham Silberschatz, Peter B. Galvin, Greg Gagne", "1118129385", "Excellent"));
    
    // Add Buy Offers.
    String student = "Alvin Wang (alvinw@hawaii.edu)";
    String textbook = "Operating System Concepts [Loose Leaf]";
    Integer price = 50;
    String date = "2014/12/31 23:59:59";
    long id = 1;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    student = "Alvin Wang (alvinw@hawaii.edu)";
    textbook = "Artifical Intelligence for Games";
    price = 72;
    date = "2015/01/11 12:00:00";
    id++;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "Programming Language Pragmatics";
    price = 54;
    date = "2014/12/20 22:05:00";
    id++;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    student = "Alvin Wang (alvinw@hawaii.edu)";
    textbook = "Introduction to Algorithms";
    price = 100;
    date = "2015/05/15 23:00:00";
    id++;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "Data Structures: Abstraction and Design Using Java";
    price = 30;
    date = "2014/11/18 23:59:59";
    id++;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "The Design of Everyday Things";
    price = 43;
    date = "2013/11/01 23:59:59";
    id++;
    BuyOfferDB.addBuyOffer(new BuyOfferFormData(student, textbook, price, date, id));
    
    // Add Sell Offers.
    student = "Alvin Wang (alvinw@hawaii.edu)";
    textbook = "Emotional Design: Why We Love (or Hate) Everyday Things";
    price = 20;
    date = "2015/01/01 23:59:59";
    id = 1;
    SellOfferDB.addSellOffer(new SellOfferFormData(student, textbook, price, date, id));
    
    student = "Alvin Wang (alvinw@hawaii.edu)";
    textbook = "Data Structures: Abstraction and Design Using Java";
    price = 77;
    date = "2015/01/01 23:59:59";
    id++;
    SellOfferDB.addSellOffer(new SellOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "Database Systems: The Complete Book";
    price = 44;
    date = "2015/12/01 23:59:59";
    id++;
    SellOfferDB.addSellOffer(new SellOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "Operating System Concepts [Loose Leaf]";
    price = 60;
    date = "2015/01/01 23:59:59";
    id++;
    SellOfferDB.addSellOffer(new SellOfferFormData(student, textbook, price, date, id));
    
    student = "Eduard Gamiao (eduard@hawaii.edu)";
    textbook = "Land of Lisp: Learn to Program in Lisp, One Game at a Time!";
    price = 58;
    date = "2013/11/01 23:59:59";
    id++;
    SellOfferDB.addSellOffer(new SellOfferFormData(student, textbook, price, date, id));
  }

}
