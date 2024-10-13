package Laba3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Visitor> visitors = ParseFile("P:\\JavaLabs\\Lab3\\src\\main\\java\\Laba3\\books.json");
        if (visitors != null) {
            System.out.println("Задание 1:");
            System.out.println(VisitorsString(visitors));
            System.out.println("Visitors Count:" + CountVisitors(visitors));
            System.out.println("\nЗадание 2:");
            for (Book i: bookSet(visitors)) {
                System.out.println(i.getTitle()+"\t"+i.getAuthor()+"\t"+i.getYear());
            }
            System.out.println("Unique Books: "+bookSet(visitors).size());
        }
    }

    public static List<Visitor> ParseFile(String path) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(path)) {
            Type visitorListType = new TypeToken<List<Visitor>>() {
            }.getType();
            return gson.fromJson(reader, visitorListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int CountVisitors(List<Visitor> visitors) {
        return visitors.size();
    }

    public static String VisitorsString(List<Visitor> visitors) {
        String visitorsString = "Name\tSurname\tphone\tisSubscribed\n";
        for (Visitor i : visitors) {
            visitorsString += i.getFirstName() + '\t' + i.getLastName() + '\t' + i.getPhoneNumber() + '\t' + i.isSubscribed() + '\n';
        }
        return visitorsString;
    }

    public static HashSet<Book> bookSet(List<Visitor> visitors)
    {
        HashSet<Book> favBooks = new HashSet<>();
        for (Visitor i: visitors)
        {
            favBooks.addAll(i.getFavoriteBooks());
        }
        return favBooks;
    }

}
