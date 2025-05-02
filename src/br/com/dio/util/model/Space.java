package br.com.dio.util.model;

public class Space {

  private Integer actual;
  private final int expected;
  private final boolean fixed;

  public Space(int expected, final boolean fixed) {
    this.expected = expected;
    this.fixed = fixed;
    this.actual = fixed ? expected : null;
  }

  public Integer getActual() {
    return actual;
  }

  public void setActual(final Integer actual) {
    if (fixed)
      return;
    this.actual = actual;
  }

  public int getExpected() {
    return expected;
  }

  public void clearSpace() {
    if (fixed)
      return;
    this.actual = null;
  }

  public boolean isFixed() {
    return fixed;
  }

}
