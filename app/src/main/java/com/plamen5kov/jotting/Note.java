package com.plamen5kov.jotting;

import android.content.Intent;

import java.io.Serializable;

public class Note implements Serializable {

    private Long id;
    private Integer index;
    private String title;
    private String content;

    public Note() {}
    public Note(String title) {
        this.title = title;
    }
    public Note(String title, String content) {
        this.title = title; this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
