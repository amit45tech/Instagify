package com.blueberry.instagify;

public class MyListData {
    private String description;
    private String taglist;

    public MyListData(String description, String taglist) {
        this.description = description;
        this.taglist = taglist;

    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaglist() {
        return taglist;
    }

    public void setTaglist(String taglist) {
        this.taglist = taglist;
    }
}
