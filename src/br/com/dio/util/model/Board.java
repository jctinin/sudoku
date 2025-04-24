package br.com.dio.util.model;

import java.util.List;

public class Board {

  private final List<List<Space>> spaces;

  public Board(final List<List<Space>> spaces) {
    this.spaces = spaces;
  }

  public List<List<Space>> getSpaces() {
    return spaces;
  }

  public Space getSpace(final int row, final int column) {
    return spaces.get(row).get(column);
  }

}
