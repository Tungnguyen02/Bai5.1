package com.example.bai51_xemtintuc;

public class News {

    private String title;
    private  String image;

    private String desc;

    private String link;

    public News()
    {

    }

    public News(String title, String image, String desc, String link) {
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", image=" + image +
                ", desc='" + desc + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
