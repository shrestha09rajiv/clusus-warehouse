package com.clusus.warehouse;

import java.util.Objects;

public class ValidatorResponseMessage {
    private int rowNumber;
    private String field;
    private String message;

    public ValidatorResponseMessage() {
    }

    public ValidatorResponseMessage(int rowNumber, String field, String message) {
        this.rowNumber = rowNumber;
        this.field = field;
        this.message = message;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidatorResponseMessage that = (ValidatorResponseMessage) o;
        return rowNumber == that.rowNumber && Objects.equals(field, that.field) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowNumber, field, message);
    }
}
