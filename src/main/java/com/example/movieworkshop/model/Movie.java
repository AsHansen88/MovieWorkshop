package com.example.movieworkshop.model;

public class Movie implements Comparable<Movie> {
  private int year;
  private int length;
  private String title;
  private String subject;
  private int popularity;
  private Boolean hasAwards;

  public Movie(int year, int length, String title, String subject, int popularity, Boolean hasAwards) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.hasAwards = hasAwards;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public Boolean getHasAwards() {
    return hasAwards;
  }

  public void setHasAwards(Boolean hasAwards) {
    this.hasAwards = hasAwards;
  }

  @Override
  public int compareTo(Movie other) {
    return this.popularity - other.popularity;
  }
}