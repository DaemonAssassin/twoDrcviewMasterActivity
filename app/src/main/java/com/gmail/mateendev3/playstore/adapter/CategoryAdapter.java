package com.gmail.mateendev3.playstore.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.mateendev3.playstore.Output;
import com.gmail.mateendev3.playstore.R;
import com.gmail.mateendev3.playstore.model.Category;
import com.gmail.mateendev3.playstore.model.CategoryItem;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    //declaring members
    private final List<Category> categoryList;
    private OnCategoryTitleClickListener onCategoryTitleClickListener;

    //constructor to instantiate instance
    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.rv_category_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.getTvCategoryTitle().setText(category.getCategoryTitle());
        //setting listener to CategoryItemTitle
        holder.getTvCategoryTitle().setOnClickListener(v ->  {
            if (onCategoryTitleClickListener != null)
                onCategoryTitleClickListener.onCategoryItemClick(holder.getAdapterPosition());
        });
        //setting RC View to CategoryItem
        setRVToCategoryItem(holder, category);
    }

    private void setRVToCategoryItem(CategoryViewHolder holder, Category category) {
        CategoryItemAdapter adapter = new CategoryItemAdapter(category.getCategoryItemList());
        //setting listener to category item
        adapter.setOnCategoryItemClickListener((position, clCategoryItemRoot) -> {
            CategoryItem item = category.getCategoryItemList().get(position);
            Intent intent = new Intent(holder.getRvCategoryItem().getContext(), Output.class);
            intent.putExtra("item", item);
            holder.getRvCategoryItem().getContext().startActivity(intent);

        });

        holder.getRvCategoryItem().setLayoutManager(new LinearLayoutManager(holder.getRvCategoryItem().getContext(), RecyclerView.HORIZONTAL, false));
        holder.getRvCategoryItem().setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if (categoryList != null && categoryList.size() > 0)
            return categoryList.size();
        return 0;
    }

    //inner static ViewHolder class
    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {
        //declaring members
        private final TextView tvCategoryTitle;
        private final RecyclerView rvCategoryItem;

        //constructor to instantiate instance
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryTitle = itemView.findViewById(R.id.tv_category_title);
            rvCategoryItem = itemView.findViewById(R.id.rv_category_item);
        }

        //getters
        public TextView getTvCategoryTitle() {
            return tvCategoryTitle;
        }

        public RecyclerView getRvCategoryItem() {
            return rvCategoryItem;
        }
    }

    //public contracts/interfaces
    public interface OnCategoryTitleClickListener {
        void onCategoryItemClick(int position);
    }

    public void setOnCategoryTitleClickListener(OnCategoryTitleClickListener l) {
        this.onCategoryTitleClickListener = l;
    }
}
