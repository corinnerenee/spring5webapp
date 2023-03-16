package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    //dependency injection set up instances of book/author repositories
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args)throws Exception{

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "98798729");

        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        //save into repo
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author corinne = new Author("Corinne", "Bond");
        Book bbd = new Book("BB Diaries", "1292901");

        bbd.getAuthors().add(corinne);
        corinne.getBooks().add(bbd);

        authorRepository.save(corinne);
        bookRepository.save(bbd);
        
        System.out.println("Boostrap loading..");
        System.out.println("Number of Books: " + bookRepository.count());
    }
    
}
