package com.lilas.demo;


import com.lilas.demo.domain.Book;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.List;

public class BookOrderHandler extends SpringBootRequestHandler<String, List<Book>> {
}
