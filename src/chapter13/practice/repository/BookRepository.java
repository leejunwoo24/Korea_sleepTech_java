package chapter13.practice.repository;

import java.util.ArrayList;
import java.util.List;

import chapter13.practice.model.Book;

public class BookRepository {
	private List<Book> books = new ArrayList<>();
	
	// 도서 저장
	public Book save(Book book) {
		// 중복된 id값일 경우 도서 저장 x
		if(findById(book.getId()) != null) {
			// 존재하는 id의 책을 전달한 경우
			System.out.println(book.getId() + "의 책이 이미 존재합니다. 다시 입력해주세요.");
			return null;
		}
		books.add(book);
		return book;
	}
	
	public void deleteById(int id) {
		
	}
	
	
	// 도서 조회 (단건)
	public Book findById(int id) {
		for(Book book: books) {
			if(book.getId() == id) {
				return book;
			}
		}
		
		return null; // 해당하는 id의 책이 없을 경우
	}
}