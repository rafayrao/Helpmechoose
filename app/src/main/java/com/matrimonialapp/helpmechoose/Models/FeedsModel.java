package com.matrimonialapp.helpmechoose.Models;

public class FeedsModel {
    int profileimg,uploadedimg;
    String likes;

    public FeedsModel(int profileimg, int uploadedimg, String likes) {
        this.profileimg = profileimg;
        this.uploadedimg = uploadedimg;
        this.likes = likes;
    }

    public int getProfileimg() {
        return profileimg;
    }

    public void setProfileimg(int profileimg) {
        this.profileimg = profileimg;
    }

    public int getUploadedimg() {
        return uploadedimg;
    }

    public void setUploadedimg(int uploadedimg) {
        this.uploadedimg = uploadedimg;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
