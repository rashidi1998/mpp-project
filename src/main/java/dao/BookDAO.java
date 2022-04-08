package dao;

import java.util.List;

public record BookDAO(String title, String isbn, int maxCheckoutLength,
        int numCopies, List<AuthorDAO> authors){}
