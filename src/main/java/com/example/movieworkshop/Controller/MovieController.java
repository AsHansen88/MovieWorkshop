package com.example.movieworkshop.controller;

import com.example.movieworkshop.model.Movie;
import com.example.movieworkshop.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
  private MovieService movieService;

  public MovieController() {
    movieService = new MovieService();
  }

  // ex 3.1
  @GetMapping("/")
  public String index() {
    return "See information about the movies";
  }

  // ex 3.2
  @GetMapping("/getFirst")
  public Movie getFirst() {
    return movieService.getFirst();
  }

  // EX 3.3
  @GetMapping("/getRandom")
  public Movie getRandom() {
    return movieService.getRandom();
  }

  // ex 3.4
  @GetMapping("/getTenSortedByPopularity")
  public List<Movie> getTenSortedByPopularity() {
    return movieService.getTenSortedByPopularity();
  }

  // ex 3.5
  @GetMapping("/howManyWonAnAward")
  public int howManyWonAnAward() {
    return movieService.howManyWonAnAward();
  }

  @GetMapping("/filter")
  public List<Movie> filter(@RequestParam char chr, @RequestParam int amount) {

    return movieService.filter(chr, amount);
  }

  @GetMapping("/longest")
  public String longest(@RequestParam String g1, @RequestParam String g2) {
    return movieService.longest(g1, g2);
  }


}