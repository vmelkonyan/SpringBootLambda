package com.lilas.demo.repo;

import com.lilas.demo.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BookDao {
    public List<Book> buildOrders(){
        return Stream.of(
                new Book(1, "Core Java", 5000, 200),
                new Book(2, "Effective Java", 1000, 500),
                new Book(3, "Spring", 1400, 200),
                new Book(4, "Hibernate", 2300, 10),
                new Book(5, "Android", 3300, 20)
        ).collect(Collectors.toList());
    }
}
