package com.api.book.bootrestbook.Controllers.Services;

import java.util.List;

import com.api.book.bootrestbook.Controllers.model.Book;
import com.api.book.bootrestbook.dao.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    //private static List<Book> list = new ArrayList<>();
    //static {
      //  list.add(new Book(12, "hello", "good"));
        //list.add(new Book(13, "hello1", "good for me"));
        //list.add(new Book(14, "hello2", "good help"));
   // }

    // getAll Book
    public List<Book> getAllBooks() {
        //database connectivity
        List<Book> list=(List<Book>)this.bookRepo.findAll();
        return list;
    }

    // get Single Book
    public Book getBookById(int id) {
        Book book = null;
        // Book id match using lambda functon
       try{ book=this.bookRepo.findById(id);
           //book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return book;
    }

    public Book addBook(Book b) {
       Book result=bookRepo.save(b);
        return result;
    }

    public void deleteBook(int bid) {
      bookRepo.deleteById(bid);
        // Book id match using lambda functon
        //list = list.stream().filter(book -> {
          //  if (book.getId() != bid) {
            //    return true;
            //} else {
              //  return false; } }).collect(Collectors.toList());
        // list=list.stream().filter(book
        // ->book.getId()!=bid).collect(Collectors.toList());
    }

    // update the book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepo.save(book);//save are update
      //  list = list.stream().map(b -> {
        //    if (b.getId() == bookId) {     b.setTitle(book.getTitle())  b.setAuthor(book.getAuthor());}
           // return b;  }).collect(Collectors.toList());
         }
}
