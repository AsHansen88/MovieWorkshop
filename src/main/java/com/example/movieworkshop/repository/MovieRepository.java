package com.example.movieworkshop.repository;

import com.example.movieworkshop.model.Movie;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class MovieRepository {
  private List<Movie> movies = new ArrayList<Movie>();

  public void generateMoviesList() {

    try {
      Scanner scan = new Scanner(new File("D:\\Datamatiker\\Intellij\\demo\\ERdetfrededag\\MovieWorkshop\\src\\main\\resources\\Movielist"));
      scan.useDelimiter(";");


       scan.nextLine();

      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        Scanner token = new Scanner(line).useDelimiter(";").useLocale(Locale.ENGLISH);

        while (token.hasNext()) {

          int year = Integer.parseInt(token.next());
          int length = Integer.parseInt(token.next());
          String title = token.next();
          String subject = token.next();
          int popularity = Integer.parseInt(token.next());
          Boolean hasAwards = token.next().equals("Yes");

          movies.add(new Movie(year, length, title, subject, popularity, hasAwards));
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Movie getOne(int index) {
    return movies.get(index);
  }

  public int getSize() {
    return movies.size();
  }

  public List<Movie> getMovies() {
    return movies;
  }


}