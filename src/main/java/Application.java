import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Q2:  Performing CURD operations

        Author author1 = new Author();
        author1.setFirstName("Vaibhav");
        author1.setLastName("Seth");
        author1.setAge(22);
        session.save(author1);  // CREATE Operation

        Author author2 = new Author();
        author2.setFirstName("Shivam");
        author2.setLastName("Chauhan");
        author2.setAge(22);
        session.save(author2); // CREATE Operation





        Author author = session.get(Author.class,2);
        System.out.println("Before Updation "+author);        // READ Operation


        author.setFirstName("Amit");
        session.update(author);                               // UPDATE Operation



        System.out.println("After Updation "+author);         // READ Operation

        session.delete(author);                               // DELETE Operation


        author = session.get(Author.class,2);
        System.out.println("After Deletion "+author);        // READ after Delete

        //----------------------------------------------------------------------------//

        // Q3: Performing Updation
        author = session.get(Author.class,1);
        author.setDob(new Date());
        session.update(author);

        author = session.get(Author.class,1);
        System.out.println(author);

        //----------------------------------------------------------------------------//

        // Q4: Adding 4 objects when "hbm2ddl" = 'update'


        Author author3 = new Author();
        author3.setFirstName("Amit");
        author3.setLastName("Verma");
        author3.setAge(22);
        author3.setDob(new Date());
        session.save(author3);  // CREATE Operation

        Author author4 = new Author();
        author4.setFirstName("Akash");
        author4.setLastName("Gupta");
        author4.setAge(21);
        author4.setDob(new Date());
        session.save(author4);


        Author author5 = new Author();
        author5.setFirstName("Ayush");
        author5.setLastName("Verma");
        author5.setAge(20);
        author5.setDob(new Date());
        session.save(author5);  // CREATE Operation

        Author author6 = new Author();
        author6.setFirstName("Chirag");
        author6.setLastName("Nagori");
        author6.setAge(19);
        author6.setDob(new Date());
        session.save(author6); // CREATE Operation

        //----------------------------------------------------------------------------//
        //Q5: Change "hbm2ddl" = 'create-drop' in hibernate.cfg.xml


        //----------------------------------------------------------------------------//
        //Q6: Change "hbm2ddl" = 'create' in hibernate.cfg.xml and rename column


        //----------------------------------------------------------------------------//
        //Q7: Add @Transient to lastName


        //----------------------------------------------------------------------------//
        //Q8: Add @Temporal to dob

        //----------------------------------------------------------------------------//
        //Q9: Change ID to Identity and Table

        //----------------------------------------------------------------------------//
        //Q10: Create class Address

        //----------------------------------------------------------------------------//
        //Q11: Add Address as @Embedded

        Author author7 = new Author();
        Address address = new Address();
        author7.setFirstName("New");
        author7.setLastName("User");
        author7.setAge(19);
        author7.setDob(new Date());
        address.setLocation("India");
        address.setState("UP");
        address.setStreetNumber("22B");
        author7.setAddress(address);
        session.save(author7); // CREATE Operation

        //----------------------------------------------------------------------------//
        //Q12-13: Add Collection of Subject

//        List<String> tempList = new ArrayList<>();
//        tempList.add("Maths");
//        tempList.add("Computer Science");
//
//        author = session.get(Author.class,1);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database
//
//        author = session.get(Author.class,3);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database
//
//        author = session.get(Author.class,4);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database
//
//        author = session.get(Author.class,5);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database
//
//        author = session.get(Author.class,6);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database
//
//        author = session.get(Author.class,7);
//        author.setSubjectList(tempList);
//        session.update(author);   // Check Author_subjectList table in database

        //----------------------------------------------------------------------------//
        //Q14: Create a Book Class


        //----------------------------------------------------------------------------//
        //Q15: Implement OneToOne Relation
//        Book book = new Book();
//        book.setBookName("Maths");
//
//
//
//
//        author = session.get(Author.class,1);
//        author.setBook(book);
//        session.update(author);   // Check Book table in database
//
//
//        Book book1 = new Book();
//        book1.setBookName("Computer Science");
//        author = session.get(Author.class,3);
//        author.setBook(book1);
//        session.update(author);   // Check Book table in database

        //----------------------------------------------------------------------------//
        //Q16: Implement OneToMany Relation
//
//        List<Book> bookList1 = new ArrayList<>();
//        List<Book> bookList2 = new ArrayList<>();
//
//        Book book1 = new Book();
//        book1.setBookName("Maths");
//
//        Book book2 = new Book();
//        book2.setBookName("Computer Science");
//
//        Book book3 = new Book();
//        book3.setBookName("English");
//
//        Book book4 = new Book();
//        book4.setBookName("Hindi");
//
//        bookList1.add(book1);
//        bookList1.add(book2);
//        bookList2.add(book3);
//        bookList2.add(book4);
//
//        author = session.get(Author.class,1);
//        author.setBookList(bookList1);
//        book1.setAuthor(author);
//        book2.setAuthor(author);
//
//        Author authorTemp = session.get(Author.class,3);
//        authorTemp.setBookList(bookList2);
//        book3.setAuthor(authorTemp);
//        book4.setAuthor(authorTemp);

        //----------------------------------------------------------------------------//
        //Q17: Implement ManyToMany Relation

        List<Book> bookList1 = new ArrayList<>();
        List<Book> bookList2 = new ArrayList<>();

        List<Author> authorList1 = new ArrayList<>();
        List<Author> authorList2 = new ArrayList<>();

        Book book1 = new Book();
        book1.setBookName("Maths");

        Book book2 = new Book();
        book2.setBookName("Computer Science");

        Book book3 = new Book();
        book3.setBookName("English");

        Book book4 = new Book();
        book4.setBookName("Hindi");

        bookList1.add(book1);
        bookList1.add(book2);
        bookList2.add(book3);
        bookList2.add(book4);

        author = session.get(Author.class,1);
        author.setBookList(bookList1);


        Author authorTemp = session.get(Author.class,3);
        authorTemp.setBookList(bookList2);

        authorList1.add(author);
        authorList1.add(author3);
        authorList2.add(author4);
        authorList2.add(author6);

        book1.setAuthorList(authorList1);
        book2.setAuthorList(authorList2);
        book3.setAuthorList(authorList1);
        book4.setAuthorList(authorList2);



        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
