package com.gmail.mateendev3.playstore.model;

import java.io.Serializable;

public class CategoryItem implements Serializable {
    //declaring members
    private final int categoryItemIconResId;
    private final String categoryItemName;
    private final String categoryItemSize;

    //constructor to instantiate instance
    public CategoryItem(int categoryItemIconResId, String categoryItemName, String categoryItemSize) {
        this.categoryItemIconResId = categoryItemIconResId;
        this.categoryItemName = categoryItemName;
        this.categoryItemSize = categoryItemSize;
    }

    //getters

    public int getCategoryItemIconResId() {
        return categoryItemIconResId;
    }

    public String getCategoryItemName() {
        return categoryItemName;
    }

    public String getCategoryItemSize() {
        return categoryItemSize;
    }
}
