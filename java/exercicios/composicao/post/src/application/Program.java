package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Scanner sc = new Scanner(System.in);

        LocalDateTime moment = LocalDateTime.parse("21/06/2018 13:05:44", dtf1);
        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome!");


        Post post1 = new Post(moment,
                              "Traveling to New Zealand",
                              "I'm going to visit this wonderful country!",
                               12);

        post1.addComments(c1);
        post1.addComments(c2);

        moment = LocalDateTime.parse("28/07/2018 23:14:19", dtf1);
        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you!");


        Post post2 = new Post(moment,
                "Good night guys",
                "See you tomorrow",
                5);

        post2.addComments(c3);
        post2.addComments(c4);


        System.out.println(post1);
        System.out.println(post2);

        sc.close();
    }
}
