import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Transient//@Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Temporal(TemporalType.DATE) @Column(name = "dob")
    private Date dob;

    @Embedded
    private Address address;

   // @ElementCollection
   // private List<String> subjectList = new ArrayList<>();

//    @OneToOne @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private Book book;

    @ManyToMany(mappedBy = "authorList") @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private  List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    //   public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

//    public List<String> getSubjectList() {
//        return subjectList;
//    }
//
//    public void setSubjectList(List<String> subjectList) {
//        this.subjectList = subjectList;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", address=" + address +
                ", bookList=" + bookList +
                '}';
    }
}
