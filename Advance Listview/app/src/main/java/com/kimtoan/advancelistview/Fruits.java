package com.kimtoan.advancelistview;

public class Fruits {

    private String Name;
    private String Description;

    public String getName() {
        return Name;
    }

    public Fruits(String name, String description, int image) {
        Name = name;
        Description = description;
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

   private int Image;
}
