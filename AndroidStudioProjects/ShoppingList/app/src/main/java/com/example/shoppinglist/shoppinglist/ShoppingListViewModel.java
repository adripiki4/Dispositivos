package com.example.shoppinglist.shoppinglist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppinglist.data.ShoppingList;
import com.example.shoppinglist.data.ShoppingListRepository;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewModel extends AndroidViewModel {

    private final ShoppingListRepository mRepository;

    private final LiveData<List<ShoppingList>> mShoppingLists;
    // Filtros observados
    private final MutableLiveData<List<String>> mCategories
            = new MutableLiveData<>(new ArrayList<>());


    // Filtros
    private final List<String> mFilters = new ArrayList<>();

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);
        mShoppingLists = mRepository.getAllShoppingLists();
    }

    public LiveData<List<ShoppingList>> getShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingList shoppingList) {
        mRepository.insert(shoppingList);
    }

    public void addFilter(String category) {
        mFilters.add(category);
        mCategories.setValue(mFilters);
    }

    public void removeFilter(String category) {
        mFilters.remove(category);
        mCategories.setValue(mFilters);
    }

}
