package com.example.shoppinglist.data;
//import androidx.lifecycle.LiveData;
//import androidx.room.Dao;
//import androidx.room.Insert;
//import androidx.room.OnConflictStrategy;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.example.shoppinglist.data.ShoppingList;
//
//import java.util.List;
//
//@Dao
//public interface ShoppingListDAO {
//    @Query("SELECT * FROM shopping_list")
//    LiveData<List<ShoppingList>> getAll();
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insert(ShoppingList shoppingList);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertShoppingLists(List<ShoppingList> lists);
//
//    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
//    LiveData<ShoppingList> getShoppingList(String id);
//
//    @Query("SELECT * FROM shopping_list WHERE category IN(:categories)")
//    LiveData<List<ShoppingList>> getShoppingListsByCategories(List<String> categories);
//
//    @Update
//    void updateShoppingList(ShoppingList shoppingList);
//
//    @Update
//    void updateShoppingLists(List<ShoppingList> shoppingLists);
//
//    @Update(entity = ShoppingList.class)
//    void markFavorite(ShoppingListFavorite shoppingList);
//}
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.shoppinglist.shoppinglist.ShoppingListForList;

import java.util.List;

@Dao
public interface ShoppingListDAO {
    @Query("SELECT id, name, is_favorite FROM shopping_list")
    LiveData<List<ShoppingListForList>> getAll();

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    LiveData<ShoppingList> getShoppingList(String id);

    @Query("SELECT id, name, is_favorite FROM shopping_list WHERE category IN(:categories)")
    LiveData<List<ShoppingListForList>> getShoppingListsByCategories(List<String> categories);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void partialInsert(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void insertShoppingLists(List<ShoppingListInsert> lists);

    @Update(entity = ShoppingList.class)
    void markFavorite(ShoppingListFavorite shoppingList);
}
