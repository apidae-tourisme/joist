package joist.migrations.columns;

public class DatetimeColumn extends AbstractColumn<DatetimeColumn> {

  public DatetimeColumn(String name) {
    super(name, "timestamp");
  }

}
