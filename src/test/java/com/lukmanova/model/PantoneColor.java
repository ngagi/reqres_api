package com.lukmanova.model;

import java.util.Objects;

public class PantoneColor {

    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    public PantoneColor() {
    }

    public PantoneColor(int id, String name, int year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PantoneColor that = (PantoneColor) o;
        return id == that.id && year == that.year && Objects.equals(name, that.name)
            && Objects.equals(color, that.color) && Objects.equals(pantone_value, that.pantone_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, color, pantone_value);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    @Override
    public String toString() {
        return "PantoneColor{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", year=" + year +
            ", color='" + color + '\'' +
            ", pantone_value='" + pantone_value + '\'' +
            '}';
    }
}
