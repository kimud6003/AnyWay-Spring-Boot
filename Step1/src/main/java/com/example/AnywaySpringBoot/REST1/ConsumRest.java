package com.example.AnywaySpringBoot.REST1;

import com.example.cosumingrest.Value;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsumRest {
  private String type;
  private Value value;

  public ConsumRest() {}

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "ConsumeRest{" + "type='" + type + '\'' + ", value=" + value + '}';
  }
}
