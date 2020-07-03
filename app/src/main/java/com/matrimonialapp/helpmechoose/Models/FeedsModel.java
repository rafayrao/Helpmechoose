package com.matrimonialapp.helpmechoose.Models;

public class FeedsModel {
    int profileimg,uploadedimg, img1,img2,img3,img4;
    String likes,captions,comment;
    int bid;

    public FeedsModel(int profileimg, int uploadedimg, int img1, int img2, int img3, int img4, String likes, String captions, String comment, int bid) {
        this.profileimg = profileimg;
        this.uploadedimg = uploadedimg;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.likes = likes;
        this.captions = captions;
        this.comment = comment;
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }

    public int getImg4() {
        return img4;
    }

    public void setImg4(int img4) {
        this.img4 = img4;
    }

    public String getCaptions() {
        return captions;
    }

    public void setCaptions(String captions) {
        this.captions = captions;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
