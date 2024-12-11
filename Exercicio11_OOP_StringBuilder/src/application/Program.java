package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmrt = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");

       LocalDateTime date1 = LocalDateTime.parse("09-12-2024T14:25:00", fmrt);

        Post p1 = new Post(date1,
                "Traveling to New Zeland!",
                "Going to visit this amazing country!",
                570);

        Comment c1 = new Comment("Have a nice trip bro!");
        Comment c2 = new Comment("Wow that's awesome m8!");

        p1.addComment(c1);
        p1.addComment(c2);

        LocalDateTime date2 = LocalDateTime.parse("10-12-2024T15:30:00", fmrt);
        Post p2 = new Post(date2,
                "GN8 guys!!!",
                "Seeya tomorrow.",
                34);

        Comment c3 = new Comment("GN8 Bro!");
        Comment c4 = new Comment("Ggs gn gn.");

        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);

    }

}
