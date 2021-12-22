package com.gmail.mateendev3.playstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.mateendev3.playstore.adapter.CategoryAdapter;
import com.gmail.mateendev3.playstore.model.Category;
import com.gmail.mateendev3.playstore.model.CategoryItem;

public class Output extends AppCompatActivity {
    TextView tvOutputName, tvOutputSize;
    ImageView ivOutputIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        tvOutputName = findViewById(R.id.tv_output_name);
        tvOutputSize = findViewById(R.id.tv_output_size);
        ivOutputIcon = findViewById(R.id.iv_output_icon);

        CategoryItem item = (CategoryItem) getIntent().getSerializableExtra("item");


        if (item != null) {
            tvOutputSize.setText(item.getCategoryItemSize());
            tvOutputName.setText(item.getCategoryItemName());
            ivOutputIcon.setImageResource(item.getCategoryItemIconResId());
        }
    }
}