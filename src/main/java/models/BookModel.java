package models;

import java.util.List;

public record BookModel(String title, String isbn, int maxCheckoutLength,
                        int numCopies, List<AuthorModel> authors){}
