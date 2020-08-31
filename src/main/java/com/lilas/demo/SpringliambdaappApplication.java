package com.lilas.demo;

import com.lilas.demo.domain.Book;
import com.lilas.demo.repo.BookDao;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringliambdaappApplication {


    private final BookDao bookDao;

    @Bean
    public Supplier<List<Book>> orders() {
        return () -> bookDao.buildOrders();
    }

    @Bean
    public Function<String, List<Book>> findOrderByName() {
        return (input) -> bookDao.buildOrders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
    }

    @Bean
    public Function<String, List<Book>> delete() {
        return (input) -> bookDao.buildOrders().stream().filter(order -> !order.getName().equals(input)).collect(Collectors.toList());
    }


    public static void main(String[] args) {

        SpringApplication.run(SpringliambdaappApplication.class, args);
    }

}
