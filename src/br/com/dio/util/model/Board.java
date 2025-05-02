package br.com.dio.util.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static br.com.dio.util.model.GameStatusEnum.INCOMPLETE;
import static br.com.dio.util.model.GameStatusEnum.NON_STARTED;
import static br.com.dio.util.model.GameStatusEnum.COMPLETE;

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

  public GameStatusEnum getGameStatus() {
    if (spaces.stream().flatMap(Collection::stream)
        .noneMatch(space -> !space.isFixed() && Objects.nonNull(space.getActual()))) {
      return NON_STARTED;
    }
    return spaces.stream().flatMap(Collection::stream).anyMatch(space -> Objects.isNull(space.getActual())) ? INCOMPLETE
        : COMPLETE;

  }

  public boolean hasErrors() {
    return spaces.stream().flatMap(Collection::stream)
        .anyMatch(space -> Objects.nonNull(space.getActual()) && !space.getActual().equals(space.getExpected()));
  }

  public boolean changeValue(final int row, final int column, final int value) {
    var space = spaces.get(row).get(column);
    if (space.isFixed()) {
      return false;
    }

    space.setActual(value);
    return true;
  }

  public boolean clearValue(final int row, final int column) {
    var space = spaces.get(row).get(column);
    if (space.isFixed() || space.getActual() == null) {
      return false;
    }
    space.clearSpace();
    return true;
  }

  public void reset() {
    spaces.stream().forEach(col -> col.forEach(Space::clearSpace));

  }

  public boolean gameIsComplete() {
    return !hasErrors() && getGameStatus().equals(COMPLETE);
  }

}
