package com.snd.library.resource;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.snd.library.dto.BookInfo;

@Path("/book")
public class SNDScienceLibrary extends SNDLibrary {
	
	public StreamingOutput customBookInfoMarhsaller(BookInfo bookInfo) {
		
		return new StreamingOutput() {
			
			@Override
			public void write(OutputStream outputStream) throws IOException, WebApplicationException {
				StringBuilder stringBuilder = null;
				stringBuilder = new StringBuilder();
				
				stringBuilder.append("<book-info><book-id>").append(bookInfo.getBookID()).append("</book-id><book-title>").append(bookInfo.getBookTitle()).append("</book-title>").append("<author>").append(bookInfo.getAuthor()).append("</author>").append("<publisher>").append(bookInfo.getPublisher()).append("</publisher>");
				outputStream.write(stringBuilder.toString().getBytes());
				outputStream.close();
			}
		};
	}
}
