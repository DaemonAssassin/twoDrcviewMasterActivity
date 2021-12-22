package com.gmail.mateendev3.playstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.mateendev3.playstore.R;
import com.gmail.mateendev3.playstore.model.CategoryItem;

import org.w3c.dom.Text;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {

    //declaring members
    private final List<CategoryItem> categoryItemList;
    private OnCategoryItemClickListener onCategoryItemClickListener;

    //constructor
    public CategoryItemAdapter(List<CategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.rv_category_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        CategoryItem item = categoryItemList.get(position);
        holder.getIvCategoryItemIcon().setImageResource(item.getCategoryItemIconResId());
        holder.getTvCategoryItemName().setText(item.getCategoryItemName());
        holder.getTvCategoryItemSize().setText(item.getCategoryItemSize());

        //setting listener to category item
        setListenerToCategoryItem(item, holder);
    }
    private void setListenerToCategoryItem(CategoryItem item, CategoryItemViewHolder holder) {
        holder.getClCategoryItemRoot().setOnClickListener(v -> {
            if (onCategoryItemClickListener != null)
                onCategoryItemClickListener.onCategoryItemClick(holder.getAdapterPosition(), holder.getClCategoryItemRoot());
        });
    }

    @Override
    public int getItemCount() {
        if (categoryItemList != null && categoryItemList.size() > 0)
            return categoryItemList.size();
        return 0;
    }


    //inner static ViewHolder class
    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        //declaring members
        private final ImageView ivCategoryItemIcon;
        private final TextView tvCategoryItemName;
        private final TextView tvCategoryItemSize;
        private final ConstraintLayout clCategoryItemRoot;

        //constructor to instantiate instance
        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCategoryItemIcon = itemView.findViewById(R.id.iv_category_item_icon);
            tvCategoryItemName = itemView.findViewById(R.id.tv_category_item_name);
            tvCategoryItemSize = itemView.findViewById(R.id.tv_category_item_size);
            clCategoryItemRoot = itemView.findViewById(R.id.cl_category_item);
        }

        //getters
        public ImageView getIvCategoryItemIcon() {
            return ivCategoryItemIcon;
        }
        public TextView getTvCategoryItemName() {
            return tvCategoryItemName;
        }
        public TextView getTvCategoryItemSize() {
            return tvCategoryItemSize;
        }
        public ConstraintLayout getClCategoryItemRoot() {
            return clCategoryItemRoot;
        }
    }

    //public contracts/interfaces
    public interface OnCategoryItemClickListener {
        void onCategoryItemClick(int position, ConstraintLayout clCategoryItemRoot);
    }

    //setters

    public void setOnCategoryItemClickListener(OnCategoryItemClickListener onCategoryItemClickListener) {
        this.onCategoryItemClickListener = onCategoryItemClickListener;
    }
}
