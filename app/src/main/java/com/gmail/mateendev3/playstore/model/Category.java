package com.gmail.mateendev3.playstore.model;

import java.util.List;

public class Category {
    //declaring members
    private final String categoryTitle;
    private final List<CategoryItem> categoryItemList;

    //constructor to instantiate instance
    public Category(String categoryTitle, List<CategoryItem> categoryItemList) {
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    //getters

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public List<CategoryItem> getCategoryItemList() {
        return categoryItemList;
    }
}
