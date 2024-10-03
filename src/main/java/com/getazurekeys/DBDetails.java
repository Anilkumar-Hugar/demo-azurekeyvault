package com.getazurekeys;

import java.util.Objects;

public class DBDetails {

    String dbUrl;
    String dbUserName;
    String dbPassword;

    public DBDetails(String dbUrl, String dbUserName, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBDetails dbDetails = (DBDetails) o;
        return Objects.equals(dbUrl, dbDetails.dbUrl) && Objects.equals(dbUserName, dbDetails.dbUserName) && Objects.equals(dbPassword, dbDetails.dbPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dbUrl, dbUserName, dbPassword);
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUserName() {
        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

}
