package dataaccess;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;



import javax.xml.crypto.Data;

import auth.AuthenticationManager;
import business.Address;
import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.LibraryMember;
import business.Role;
import dataaccess.DataAccessFacade.StorageType;


public class DataAccessFacade implements DataAccess {

	private static DataAccessFacade instance = new DataAccessFacade();
	
	enum StorageType {
		BOOKS, MEMBERS, USERS, CHECKOUTS;
	}

	// public static final String OUTPUT_DIR = "./storage";
	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "/src/main/java/dataaccess/storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	private DataAccessFacade() {}

	public static DataAccessFacade getInstance() {
		return instance;
	}

	//implement: other save operations
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		saveToStorage(StorageType.MEMBERS, mems);	
	}

	public List<LibraryMember> getLibraryMemberList() {
		if(readMemberMap() == null) {
			return new ArrayList<LibraryMember>();
		}
		return new ArrayList<LibraryMember>(readMemberMap().values());
	}

	public LibraryMember getMember(String memberId) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		LibraryMember libraryMember = mems.get(memberId);
		return libraryMember;
	}
	
	public boolean memberExists(String memberId) {
		return getMember(memberId) != null;
	}

	public void saveNewBook(Book book) {
		 HashMap<String, Book> books = readBooksMap();
		 books.put(book.getIsbn(), book);
		 saveToStorage(StorageType.BOOKS, books);
	}

	public void saveBookCopy(BookCopy bookCopy) {

	}

	public void saveCheckoutRecords(CheckoutRecord checkoutRecord){
		List<CheckoutRecord> checkouts = getCheckoutRecordList();
		if(checkouts == null)
			checkouts = new ArrayList<>();
		Integer recordIdx = findCheckoutRecordByMemberId(checkouts, checkoutRecord.getLibraryMember().getMemberId());
		if(recordIdx == null){
			checkouts.add(checkoutRecord);
		}else{
			checkouts.set(recordIdx, checkoutRecord);
		}
		saveToStorage(StorageType.CHECKOUTS, checkouts);
	}

	private Integer findCheckoutRecordByMemberId(List<CheckoutRecord> list, String memberId){
		int idx = 0;
		for(int i = 0; i < list.size(); i++, idx++){
			if(list.get(i).getLibraryMember().getMemberId().equals(memberId))
				return idx;
		}
		return null;
	}

	public CheckoutRecord getCheckoutRecord(String memberId){
		List<CheckoutRecord> checkouts = getCheckoutRecordList();
		if(checkouts == null)
			checkouts = new ArrayList<>();
		Integer recordIdx = findCheckoutRecordByMemberId(checkouts, memberId);
		if(recordIdx == null)
			return null;
		return checkouts.get(recordIdx);
	}

	@SuppressWarnings("unchecked")
	public List<CheckoutRecord> getCheckoutRecordList(){
		return (List<CheckoutRecord>) readFromStorage(StorageType.CHECKOUTS);
	}

	public List<Book> getBookList() {
		if(readBooksMap() == null) {
			return new ArrayList<Book>();
		}
		return new ArrayList<Book>(readBooksMap().values());
	}

	public Book getBook(String isbn) {
		HashMap<String, Book> books = readBooksMap();
		Book book = books.get(isbn);
		return book;
	}

	public BookCopy getBookCopy(String isbn, String copyNum) {
		Book book = getBook(isbn);
		return book.getBookCopy(copyNum);
	}
	
	public boolean bookExists(String isbn) {
		return getBook(isbn) != null;
	}

	@SuppressWarnings("unchecked")
	public  HashMap<String,Book> readBooksMap() {
		//Returns a Map with name/value pairs being
		//   isbn -> Book
		return (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		//Returns a Map with name/value pairs being
		//   memberId -> LibraryMember
		return (HashMap<String, LibraryMember>) readFromStorage(
				StorageType.MEMBERS);
	}

	/////load methods - these place test data into the storage area
	///// - used just once at startup  
	
		
	static void loadBookMap(List<Book> bookList) {
		HashMap<String, Book> books = new HashMap<String, Book>();

		bookList.forEach(book -> books.put(book.getIsbn(), book));
		saveToStorage(StorageType.BOOKS, books);
	}
 
	static void loadMemberMap(List<LibraryMember> memberList) {
		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();

		memberList.forEach(member -> members.put(member.getMemberId(), member));
		saveToStorage(StorageType.MEMBERS, members);
	}

	static void loadCheckoutMap(List<CheckoutRecord> records) {
		saveToStorage(StorageType.CHECKOUTS, records);
	}



	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			if (!Files.exists(path)) {
				File file = new File(path.toString());
				file.getParentFile().mkdirs();
				file.createNewFile();
			}

			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}
	
	
}
