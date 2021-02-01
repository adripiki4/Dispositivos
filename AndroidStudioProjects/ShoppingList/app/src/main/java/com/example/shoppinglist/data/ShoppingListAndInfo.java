package com.example.shoppinglist.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppinglist.shoppinglist.ShoppingListForList;


public class ShoppingListAndInfo {
    @Embedded
    public ShoppingListForList shoppingList;

    @Relation(
            parentColumn = "id",
            entityColumn = "shopping_list_id"
    )
    public Info info;
}