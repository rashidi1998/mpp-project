package dataaccess;

import businessmodels.*;

import java.util.*;

public class GenerateData {

    public static void main(String[] args){
		List<LibraryMember> members = new ArrayList<LibraryMember>() {
			{
				add(new LibraryMember("Admin", "Admin", "12345", "admin1", "12345", Role.ADMIN,
					new Address("4th", "iowa", "fairfiled", "52557"))
				);
				add(new LibraryMember("Member1", "Member1", "12345", "member1", "12345", Role.LIBRARIAN,
					new Address("4th", "iowa", "fairfiled", "52557"))
				);
			}
		};
//
//		var authors = List.of(new Author("123", "123", "123", "123", new Address("123", "123", "asd", "asd")));
//
//		List<Book> books = new ArrayList<Book>() {
//			{
//				add(new Book.Builder("12345", "FPP", authors).build() );
//				add(new Book.Builder("23456", "MPP", authors).build() );
//			}
//		};

//		Book book = new Book.Builder("123123123123", "asdasdasd", List.of(new Author("aweq", "asdasd", "asd", "asd", new Address("asd", "asd", "asd", "asdasd")))).numCopies(10).build();
//		CheckoutRecord checkoutTest = new CheckoutRecord.Builder(members.get(0), book).build();
		List<CheckoutRecord> records = new ArrayList<>();
		List<Book> books = new ArrayList<>();
//		List<LibraryMember> members = new ArrayList<>();
//		records.add(checkoutTest);

		DataAccessorFacade.loadBookMap(books);
		DataAccessorFacade.loadMemberMap(members);
		DataAccessorFacade.loadCheckoutMap(records);
	}
}
