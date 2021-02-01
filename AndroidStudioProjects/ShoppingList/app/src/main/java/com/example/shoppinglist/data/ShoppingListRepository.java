package com.example.shoppinglist.data;
//
//import android.content.Context;
//
//import androidx.lifecycle.LiveData;
//
//import java.util.List;
//
//public class ShoppingListRepository {
//    private final LiveData<List<ShoppingList>> mShoppingLists;
//    private final ShoppingListDAO mShoppingListDao;
//
//    public ShoppingListRepository(Context context) {
//        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
//        mShoppingListDao = db.shoppingListDao();
//        mShoppingLists = mShoppingListDao.getAll();
//    }
//
//    public LiveData<List<ShoppingList>> getAllShoppingLists() {
//        return mShoppingLists;
//    }
//
//    public void insert(ShoppingList shoppingList) {
//        ShoppingListDatabase.dbExecutor.execute(
//                () -> mShoppingListDao.insert(shoppingList)
//        );
//    }
//}

import android.content.Context;

import androidx.lifecycle.LiveData;


import com.example.shoppinglist.shoppinglist.ShoppingListForList;
import com.example.shoppinglist.shoppinglist.ShoppingListId;

import java.util.List;

public class ShoppingListRepository {
    private final ShoppingListDAO mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingList> getShoppingList(String id) {
        return mShoppingListDao.getShoppingList(id);
    }

    public void insert(ShoppingListInsert shoppingList, Info info) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insertWithInfo(shoppingList, info)
        );
    }

    public void markFavorite(String shoppingListId) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.markFavorite(shoppingListId)
        );
    }

    public void deleteShoppingList(ShoppingListId id) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.deleteShoppingList(id)
        );
    }

    public void deleteAll() {
        ShoppingListDatabase.dbExecutor.execute(
                mShoppingListDao::deleteAll
        );
    }
}


