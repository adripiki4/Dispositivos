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

import java.util.List;

public class ShoppingListRepository {
    private final ShoppingListDAO mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
    }

    public LiveData<List<ShoppingListForList>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListForList>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingList> getShoppingList(String id) {
        return mShoppingListDao.getShoppingList(id);
    }

    public void insert(ShoppingListInsert shoppingList) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.partialInsert(shoppingList)
        );
    }

    public void markFavorite(ShoppingListFavorite shoppingLists) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.markFavorite(shoppingLists)
        );
    }
}

