package bj.highfiveuniversity.book.mapper;

import bj.highfiveuniversity.book.dto.BookDTO;
import bj.highfiveuniversity.book.models.Book;

public class BookMapper {
    public static BookDTO toDto(Book livre) {

        return new BookDTO(livre.getId(), livre.getTitle(), livre.getIsbn());
    }

}
