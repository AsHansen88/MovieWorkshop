package com.example.movieworkshop.service;

import com.example.movieworkshop.model.Movie;
import com.example.movieworkshop.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MovieService {
  private MovieRepository movieRepository;
  private Random random;

  public MovieService() {
    movieRepository = new MovieRepository();
    movieRepository.generateMoviesList();
    random = new Random();
  }

  public Movie getFirst() {
    return movieRepository.getOne(0);
  }

  public Movie getRandom() {
    int rndIndex = random.nextInt(movieRepository.getSize());

    return movieRepository.getOne(rndIndex);
  }

  public List<Movie> getTenSortedByPopularity() {
    List<Movie> sortMovies = new ArrayList<>();

    // get random movies
    for (int i = 0; i < 10; i++) sortMovies.add(getRandom());

    // sort by popularity
    Collections.sort(sortMovies);

    return sortMovies;
  }

  public int howManyWonAnAward() {
    int awardWinners = 0;

    for (Movie movie : movieRepository.getMovies()) {
      if (movie.getHasAwards()) awardWinners++;
    }

    return awardWinners;
  }

  public List<Movie> filter(char chr, int amount) {
    List<Movie> returnMovies = new ArrayList<>();

    // for each movie
    for (Movie movie : movieRepository.getMovies()) {
      char[] movieTitle = movie.getTitle().toCharArray();
      int found = 0;

      // check title chars
      for (char c : movieTitle) {
        if (c == chr) found++;
      }

      // add if enough found
      if (found >= amount) returnMovies.add(movie);
    }

    return returnMovies;
  }

  public String longest(String g1, String g2) {
    int g1TotalTime = 0;
    int g2TotalTime = 0;

    int g1Number = 0;
    int g2Number = 0;

    double g1AVG = 0;
    double g2AVG = 0;


    // check all movies
    for (Movie movie : movieRepository.getMovies()) {
      // g1
      if (movie.getSubject().equals(g1)) {
        g1TotalTime += movie.getLength();
        g1Number++;
      }

      // g2
      if (movie.getSubject().equals(g2)) {
        g2TotalTime += movie.getLength();
        g2Number++;
      }
    }

    // avg
    g1AVG = (double) g1TotalTime / g1Number;
    g2AVG = (double) g2TotalTime / g2Number;

    return String.format("""
                        <pre>
                        g1=%s
                        g2=%s
                         
                        g1 - number=%-10d total=%-10d avg=%.2f
                        g2 - number=%-10d total=%-10d avg=%.2f
                        </pre>
                        """, g1, g2,
        g1Number, g1TotalTime, g1AVG,
        g2Number, g2TotalTime, g2AVG);
  }

}