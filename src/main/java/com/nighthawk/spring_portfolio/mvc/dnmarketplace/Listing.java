package com.nighthawk.spring_portfolio.mvc.dnmarketplace;

public class Listing {

    private long id;
    private String content;

    public Listing(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }
}
