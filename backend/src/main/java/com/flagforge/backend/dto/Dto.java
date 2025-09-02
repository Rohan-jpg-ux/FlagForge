package com.flagforge.backend.dto;
public class Dto {
  public record EvalResponse(String flagKey, boolean value) {}
}