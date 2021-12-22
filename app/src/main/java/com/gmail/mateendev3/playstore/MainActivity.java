package com.gmail.mateendev3.playstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gmail.mateendev3.playstore.adapter.CategoryAdapter;
import com.gmail.mateendev3.playstore.model.Category;
import com.gmail.mateendev3.playstore.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //declaring members
    private List<Category> categoryList;
    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting rc view to category
        setRCViewToCategory();
    }

    private void setRCViewToCategory() {
        rvCategory = findViewById(R.id.rv_category);
        categoryAdapter = new CategoryAdapter(getCategoryList());
        //setting listener to CategoryItemTitle
        categoryAdapter.setOnCategoryTitleClickListener(position -> {
            Category category = categoryList.get(position);
            Toast.makeText(MainActivity.this, "Go To: " + category.getCategoryTitle(), Toast.LENGTH_SHORT).show();
        });

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getCategoryList() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Recommended for you", getCategoryItemList1()));
        categoryList.add(new Category("Suggested for you", getCategoryItemList2()));
        categoryList.add(new Category("Based on your recent activity", getCategoryItemList3()));
        categoryList.add(new Category("Editor's choice app", getCategoryItemList4()));
        return categoryList;
    }

    private List<CategoryItem> getCategoryItemList1() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.instagram, "Instagram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.twitter, "Twitter", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.telegram, "Telegram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.netflix, "Netflix", "300 MB"));
        return categoryItemList;
    }

    private List<CategoryItem> getCategoryItemList2() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.twitter, "Twitter", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.instagram, "Instagram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.telegram, "Telegram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.netflix, "Netflix", "300 MB"));
        return categoryItemList;
    }

    private List<CategoryItem> getCategoryItemList3() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(R.drawable.netflix, "Netflix", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.instagram, "Instagram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.twitter, "Twitter", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.telegram, "Telegram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        return categoryItemList;
    }

    private List<CategoryItem> getCategoryItemList4() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(R.drawable.instagram, "Instagram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.netflix, "Netflix", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.twitter, "Twitter", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.telegram, "Telegram", "300 MB"));
        categoryItemList.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        return categoryItemList;
    }
}