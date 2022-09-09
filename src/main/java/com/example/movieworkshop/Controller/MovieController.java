package com.example.movieworkshop.Controller;

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

  // øvelse 3.1
  @GetMapping("/")
  public String index() {
    return "See information about the movies";
  }

  // øvelse 3.2
  @GetMapping("/getFirst")
  public Movie getFirst() {
    return movieService.getFirst();
  }

  // øvelse 3.3
  @GetMapping("/getRandom")
  public Movie getRandom() {
    return movieService.getRandom();
  }

  // øvelse 3.4
  @GetMapping("/getTenSortedByPopularity")
  public List<Movie> getTenSortedByPopularity() {
    return movieService.getTenSortedByPopularity();
  }

  // øvelse 3.5
  @GetMapping("/howManyWonAnAward")
  public int howManyWonAnAward() {
    return movieService.howManyWonAnAward();
  }
  // øvelse 3.6
  @GetMapping("/filter")
  public List<Movie> filter(@RequestParam char chr, @RequestParam int amount) {

    return movieService.filter(chr, amount);
  }
  // øvelse 3.7
  @GetMapping("/longest")
  public String longest(@RequestParam String g1, @RequestParam String g2) {
    return movieService.longest(g1, g2);
  }


}