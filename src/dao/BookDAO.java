package dao;

import model.Book;

import java.io.*;
import java.util.*;

public class BookDAO {
    public static Map<String, Book> loadBooks(String path) {
        Map<String, Book> books = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                books.put(parts[0], new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            System.out.println("Error reading books.");
        }
        return books;
    }
}
