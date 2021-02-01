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
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.shoppinglist.shoppinglist.ShoppingListForList;
import com.example.shoppinglist.shoppinglist.ShoppingListId;

import java.util.List;

@Dao
public abstract class ShoppingListDAO {
    @Transaction
    @Query("SELECT id, name, is_favorite FROM shopping_list")
    abstract LiveData<List<ShoppingListAndInfo>> getAll();

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    abstract LiveData<ShoppingList> getShoppingList(String id);

    @Transaction
    @Query("SELECT id, name, is_favorite FROM shopping_list WHERE category IN(:categories)")
    abstract LiveData<List<ShoppingListAndInfo>> getShoppingListsByCategories(List<String> categories);

    @Transaction
    public void insertWithInfo(ShoppingListInsert shoppingList, Info info) {
        insertShoppingList(shoppingList);
        insertInfo(info);
    }

    @Transaction
    public void insertAllWithInfos(List<ShoppingListInsert> shoppingLists, List<Info> infos) {
        insertAll(shoppingLists);
        insertAllInfos(infos);
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertShoppingList(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertShoppingList(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertAll(List<ShoppingListInsert> lists);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertInfo(Info info);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertAllInfos(List<Info> infos);

    @Transaction
    public void markFavorite(String id) {
        updateShoppingListFavorite(id);
        updateInfoLastUpdated(id);
    }

    @Query("UPDATE shopping_list SET is_favorite= NOT is_favorite WHERE id = :id")
    protected abstract void updateShoppingListFavorite(String id);

    @Query("UPDATE info SET last_updated = CURRENT_TIMESTAMP WHERE shopping_list_id=:shoppingListId")
    protected abstract void updateInfoLastUpdated(String shoppingListId);

    @Delete(entity = ShoppingList.class)
    abstract void deleteShoppingList(ShoppingListId id);

    @Query("DELETE FROM shopping_list")
    abstract void deleteAll();
}
