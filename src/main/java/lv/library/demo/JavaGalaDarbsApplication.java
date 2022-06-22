package lv.library.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.library.demo.model.Book;
import lv.library.demo.model.BookClass;
import lv.library.demo.model.BookCondition;
import lv.library.demo.model.BookRarity;
import lv.library.demo.model.BookRating;
import lv.library.demo.model.Employee;
import lv.library.demo.model.LibraryDepartment;
import lv.library.demo.model.Reader;
import lv.library.demo.repo.IBookRepo;
import lv.library.demo.repo.IEmployeeRepo;
import lv.library.demo.repo.ILibraryRepo;
import lv.library.demo.repo.IReaderRepo;

@SpringBootApplication
public class JavaGalaDarbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGalaDarbsApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDataForTesting(IBookRepo bookrepo, IEmployeeRepo employeerepo, ILibraryRepo libraryrepo, IReaderRepo readerepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Reader reader1 = new Reader("Ivars", "Lasitaajs");
				Reader reader2 = new Reader("Baigais", "Luberts");
				Reader reader3 = new Reader("Janis", "Polikovs");
				Reader reader4 = new Reader("Zirnis", "Garais");
				Reader reader5 = new Reader("Pupins", "Skudra");
				
				readerepo.save(reader1);
				readerepo.save(reader2);
				readerepo.save(reader3);
				readerepo.save(reader4);
				readerepo.save(reader5);
				
				LibraryDepartment librarydepartment = new LibraryDepartment("Library", "8:00 - 17:00");
				libraryrepo.save(librarydepartment);
				LibraryDepartment librarydepartment2 = new LibraryDepartment("Library (Night)", "17:00 - 00:00");
				libraryrepo.save(librarydepartment2);
				
				Employee employ1 = new Employee("Toms Mariss","Pilverts");
				librarydepartment.addEmployee(employ1);
				Employee employ2 = new Employee("Alekss", "Zernovs");
				librarydepartment.addEmployee(employ2);
				Employee employ3 = new Employee("Janis", "Polikovs");
				librarydepartment.addEmployee(employ3);
				Employee employ4 = new Employee("Kristers", "Kunstbergs");
				librarydepartment.addEmployee(employ4);
				employeerepo.save(employ1);
				employeerepo.save(employ2);
				employeerepo.save(employ4);
				employeerepo.save(employ3);
				Reader reader6 = new Reader("Gibijs", "Gibijs");
				readerepo.save(reader6);
				Book book1 = new Book("1954", "J.R.R","Tolkien","The Lord of the Rings", BookRating.Five_Star, BookRarity.Common, BookCondition.Perfect, BookClass.Adventure,"https://images-na.ssl-images-amazon.com/images/I/51kfFS5-fnL._SX332_BO1,204,203,200_.jpg","The Lord of the Rings is the saga of a group of sometimes reluctant heroes who set forth to save their world from consummate evil. Its many worlds and creatures were drawn from Tolkien's extensive knowledge of philology and folklore.");
				librarydepartment.addBook(book1);
				librarydepartment.giveBook(book1, reader6);
				bookrepo.save(book1);
				
				Book book2 = new Book("1953", "Ray","Bradbury","Fahrenheit 451", BookRating.Fourth_Star, BookRarity.Uncommon, BookCondition.Good, BookClass.Fantasy,"https://en.wikipedia.org/wiki/Fahrenheit_451#/media/File:Fahrenheit_451_1st_ed_cover.jpg","Fahrenheit 451 is a 1953 dystopian novel by American writer Ray Bradbury. Often regarded as one of his best works, the novel presents a future American society where books are outlawed and \"firemen\" burn any that are found.");
				librarydepartment.addBook(book2);
				librarydepartment.giveBook(book2, reader6);
				bookrepo.save(book2);
				
				Book book3 = new Book("1949", "George","Orwell","Nineteen Eighty-Four", BookRating.Fourth_Star, BookRarity.Common, BookCondition.Lightly_Damaged, BookClass.SciFi,"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/1984first.jpg/220px-1984first.jpg","Nineteen Eighty-Four is a dystopian social science fiction novel and cautionary tale written by English writer George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime.");
				librarydepartment2.addBook(book3);
				bookrepo.save(book3);
				
				readerepo.save(reader6);
				for(Book c : reader6.getCurrentBooks()) {
					System.out.println(c.getTitle());
				}
				
				librarydepartment.takeBook(book1);
				bookrepo.save(book1);
				
				for(Book c : reader6.getCurrentBooks()) {
					System.out.println(c.getTitle());
				}
			}
		};
	}
}
