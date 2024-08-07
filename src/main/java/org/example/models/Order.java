package org.example.models;public class Order {
    private String columnName;
    private boolean ascending;

    public Order(final boolean ascending, final String columnName) {
        this.ascending = ascending;
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(final boolean ascending) {
        this.ascending = ascending;
    }
}
