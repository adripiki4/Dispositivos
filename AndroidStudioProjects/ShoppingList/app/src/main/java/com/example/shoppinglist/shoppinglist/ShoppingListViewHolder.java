package com.example.shoppinglist.shoppinglist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;
import com.example.shoppinglist.data.ShoppingList;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
    private final TextView mNameText;
    private final CheckBox mFavoriteButton;
    private final ImageView mDeleteButton;

    public ShoppingListViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);
        mFavoriteButton = itemView.findViewById(R.id.favorite_button);
        mDeleteButton = itemView.findViewById(R.id.delete_button);

    }


    public void bind(ShoppingList item) {
        mNameText.setText(item.getName());
    }

    public static ShoppingListViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingListViewHolder(v);
    }
}
