package br.com.dio.util.model;

public class Space {
  private Integer expected;
  private Integer actual;
  private boolean fixed;

  public Space(int expected, boolean fixed) {
      this.expected = expected;
      this.fixed = fixed;
      if (fixed) {
          this.actual = expected;
      } else {
          this.actual = null;
      }
  }

  public Integer getExpected() {
      return expected;
  }

  public Integer getActual() {
      return actual;
  }

  public void setActual(Integer actual) {
      this.actual = actual;
  }

  public boolean isFixed() {
      return fixed;
  }

  public void clearSpace() {
      if (!fixed) {
          this.actual = null;
      }
  }
}
