package com.matrimonialapp.helpmechoose.Models;

public class notifications  {
    int image;
    String description;

    public notifications(int image, String description) {
        this.image = image;
        this.description = description;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
