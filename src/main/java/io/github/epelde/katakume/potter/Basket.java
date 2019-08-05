package io.github.epelde.katakume.potter;

import java.util.*;
import java.util.stream.Collectors;

public class Basket {

    private static final double TWO_DIFFERENT_BOOK_SET_DISCOUNT = 0.95;

    private static final double THREE_DIFFERENT_BOOK_SET_DISCOUNT = 0.90;

    private static final double FOUR_DIFFERENT_BOOK_SET_DISCOUNT = 0.80;

    private static final double FIVE_DIFFERENT_BOOK_SET_DISCOUNT = 0.75;

    private List<Book> bookList;

    public Basket(Book[] books) {
        this.bookList = Arrays.asList(books);
    }

    public double price() {
        double total = 0;

        List<List<Book>> booksGroupedById = this.bookList.stream()
                .collect(Collectors.groupingBy(Book::getId))
                .values()
                .stream()
                .sorted(Comparator.comparingInt(group -> group.size()))
                .collect(Collectors.toList());

        Collections.reverse(booksGroupedById);

        if (!booksGroupedById.isEmpty()) {
            List<Set<Book>> listOfBookSets = new ArrayList<>();
            booksGroupedById.get(0).forEach(group -> listOfBookSets.add(new HashSet<>()));

            for (int i = 0; i < booksGroupedById.size(); i++) {
                for (int j = 0; j < booksGroupedById.get(i).size(); j++) {
                    listOfBookSets.get(j).add(booksGroupedById.get(i).get(j));
                }
            }

            for (int i = 0; i < listOfBookSets.size(); i++) {
                if (listOfBookSets.get(i).size() == 2) {
                    total += listOfBookSets.get(i).size() * 8 * TWO_DIFFERENT_BOOK_SET_DISCOUNT;
                } else if (listOfBookSets.get(i).size() == 3) {
                    total += listOfBookSets.get(i).size() * 8 * THREE_DIFFERENT_BOOK_SET_DISCOUNT;
                } else if (listOfBookSets.get(i).size() == 4) {
                    total += listOfBookSets.get(i).size() * 8 * FOUR_DIFFERENT_BOOK_SET_DISCOUNT;
                } else if (listOfBookSets.get(i).size() == 5) {
                    total += listOfBookSets.get(i).size() * 8 * FIVE_DIFFERENT_BOOK_SET_DISCOUNT;
                } else {
                    total += listOfBookSets.get(i).size() * 8;
                }
            }
        }

        return total;
    }
}
