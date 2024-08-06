package org.example.models;

public class Order {

    private String columnName;

    private boolean ascending;





    public Order(
           /* final int jRID,
            final String jobRoleName,
            final Locations jobRoleLocation,
            final String jobRoleCapability,
            final String jRBand,
            final Date jRClosingDate,*/
            final String columnName,
            final boolean ascending,
            final boolean descending ) {
       // super(jRID, jobRoleName, jobRoleLocation, jobRoleCapability,
              //  jRBand, jRClosingDate);
            this.columnName = columnName;
            this.ascending = ascending;

        }




    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }


}
