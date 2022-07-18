package com.example.AnywaySpringBoot.REST1;

public class BuildRest {
  private final long id;
  private final String content;

  public BuildRest(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
