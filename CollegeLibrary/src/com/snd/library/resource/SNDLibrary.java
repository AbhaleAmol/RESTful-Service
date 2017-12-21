package com.snd.library.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import com.snd.library.dto.BookInfo;

public abstract class SNDLibrary {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getBookInfo(@QueryParam("book-id") String bookID) {
		
		BookInfo bookInfo = null;
		bookInfo = new BookInfo();
		// fetch the book details from database and populate the data into the bookInfo object
		
		bookInfo.setBookID(bookID);
		bookInfo.setBookTitle("Organic Chemistry By Shinde N. K. & Kunde");
		bookInfo.setAuthor("Shinde N. K. & Kunde");
		bookInfo.setPublisher("TATA McGrow Hills Publications");
		
		
		return customBookInfoMarhsaller(bookInfo);
	}
	
	abstract StreamingOutput customBookInfoMarhsaller(BookInfo bookInfo);
}
