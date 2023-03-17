package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //dependency injection set up instances of book/author repositories
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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

        Publisher renee = new Publisher("Renee", "5742 S King Dr",  "Chicago", "IL", "60637");
        Publisher ty = new Publisher ("Ty", "988 S Kedzie", "Chicago", "IL", "60209");

        
        publisherRepository.save(renee);
        publisherRepository.save(ty);

        System.out.println("Boostrap loading..");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
    
}
