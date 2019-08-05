package io.github.epelde.katakume.potter;

public enum Book {

    BOOK1("BOOK1"),
    BOOK2("BOOK2"),
    BOOK3("BOOK3"),
    BOOK4("BOOK4"),
    BOOK5("BOOK5");

    private String id;

    Book(String id) {
        this.id = id;
    }

    String getId() {
        return this.id;
    }
}