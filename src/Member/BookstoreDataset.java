package Member;

import java.util.HashMap;
import java.util.TreeMap;

public class BookstoreDataset {

	public static TreeMap<String, BookstoreDTO> BookstoreList = new TreeMap<>();
	public BookstoreDataset() {
		
	}
	public static void setBookstoreList() {
//		BookstoreList.put("책이름    ", new BookstoreDTO(1, "책이름     ", "책저자", "출판사", 5000, 10));
		BookstoreList.put("코딩테스트다", new BookstoreDTO(1, "코딩테스트다", "나동빈", "한빛미디어\t", 5000));
		BookstoreList.put("혼자하는 자바", new BookstoreDTO(2, "혼자하는 자바", "신용권", "한빛미디어\t", 7000));
		BookstoreList.put("생활코딩 책", new BookstoreDTO(3, "생활코딩 책 ", "이고잉", "위키북스\t    ", 8000));
		BookstoreList.put("do it!자바!", new BookstoreDTO(4, "do it!자바!", "정동균", "퍼블리싱\t    ", 5900));
		BookstoreList.put("자바의정석기초", new BookstoreDTO(5, "자바의정석기초", "남궁성", "도우출판\t   ", 7500));
		//BookstoreList.put("남궁성", new BookstoreDTO())
	}

}