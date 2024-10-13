package Laba3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(VisitorsString(ParseFile("P:\\JavaLabs\\Lab3\\src\\main\\java\\Laba3\\books.json")));
        System.out.println("Visitors Count:"+CountVisitors(ParseFile("P:\\JavaLabs\\Lab3\\src\\main\\java\\Laba3\\books.json")));

    }
    public static List<Visitor> ParseFile( String path)
    {
        Gson gson=new Gson();
        try(FileReader reader = new FileReader(path)){
            Type visitorListType = new TypeToken<List<Visitor>>() {}.getType();
            return gson.fromJson(reader, visitorListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int CountVisitors(List<Visitor> visitors)
    {
        return visitors.size();
    }

    public static String VisitorsString(List<Visitor> visitors)
    {
        String visitorsString = "Name\tSurname\tphone\tisSubscribed\n";
        for (Visitor i:visitors)
        {
            visitorsString += i.getFirstName()+'\t'+i.getLastName()+'\t'+i.getPhoneNumber()+'\t'+i.isSubscribed()+'\n';
        }
        return visitorsString;
    }
}
