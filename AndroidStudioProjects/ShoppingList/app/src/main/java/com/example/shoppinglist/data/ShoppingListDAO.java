package com.example.shoppinglist.data;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shoppinglist.data.ShoppingList;

import java.util.List;

@Dao
public interface ShoppingListDAO {
    @Query("SELECT * FROM shopping_list")
    LiveData<List<ShoppingList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertShoppingLists(List<ShoppingList> lists);

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    LiveData<ShoppingList> getShoppingList(String id);

    @Query("SELECT * FROM shopping_list WHERE category IN(:categories)")
    LiveData<List<ShoppingList>> getShoppingListsByCategories(List<String> categories);
}

