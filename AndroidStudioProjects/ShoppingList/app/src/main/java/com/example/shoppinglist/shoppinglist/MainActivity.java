package com.example.shoppinglist.shoppinglist;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.example.shoppinglist.R;
//import com.example.shoppinglist.addshoppinglist.AddShoppingListActivity;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//public class MainActivity extends AppCompatActivity {
//
//    private ShoppingListViewModel mViewModel;
//    private RecyclerView mList;
//    private ShoppingListAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ViewModelProvider.AndroidViewModelFactory factory =
//                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
//
//        mViewModel = new ViewModelProvider(this, factory)
//                .get(ShoppingListViewModel.class);
//
//        setupList();
//
//        setupFab();
//    }
//
//    private void setupList() {
//        mList = findViewById(R.id.list);
//        mAdapter = new ShoppingListAdapter();
//        mList.setAdapter(mAdapter);
//        mViewModel.getShoppingLists().observe(this, mAdapter::setItems);
//    }
//
//    private void setupFab() {
//        FloatingActionButton fav = findViewById(R.id.floating_action_button);
//
//                fav.setOnClickListener(view -> addNewShoppingList());
//    }
//
//    private void addNewShoppingList() {
//        startActivity(new Intent(MainActivity.this, AddShoppingListActivity.class));
//    }
//}
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglist.R;
import com.example.shoppinglist.addshoppinglist.AddShoppingListActivity;
import com.example.shoppinglist.editshopppinglist.EditShoppingListActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ShoppingListViewModel mViewModel;
    private RecyclerView mList;
    private ShoppingListAdapter mAdapter;
    private List<CheckBox> mFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(ShoppingListViewModel.class);

        setupFilters();

        setupList();

        setupFab();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (R.id.delete_all == itemId) {
            mViewModel.deleteAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupFilters() {
        mFilters = new ArrayList<>();
        mFilters.add(findViewById(R.id.filter_1));
        mFilters.add(findViewById(R.id.filter_2));
        mFilters.add(findViewById(R.id.filter_3));

        // Definir escucha de filtros
        CompoundButton.OnCheckedChangeListener listener = (compoundButton, checked) -> {
            String category = compoundButton.getText().toString();
            if (checked) {
                mViewModel.addFilter(category);
            } else {
                mViewModel.removeFilter(category);
            }
        };

        // Setear escucha
        for (CheckBox filter : mFilters) {
            filter.setOnCheckedChangeListener(listener);
        }
    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new ShoppingListAdapter();
        mList.setAdapter(mAdapter);

        // Asignar escucha de ítems
        mAdapter.setItemListener(new ShoppingListAdapter.ItemListener() {
            @Override
            public void onClick(ShoppingListForList shoppingList) {
                editShoppingList(shoppingList);
            }

            @Override
            public void onFavoriteIconClicked(ShoppingListForList shoppingList) {
                mViewModel.markFavorite(shoppingList);
            }

            @Override
            public void onDeleteIconClicked(ShoppingListForList shoppingList) {
                mViewModel.deleteShoppingList(shoppingList);

            }
        });

        // Observar cambios de listas de compras
        mViewModel.getShoppingLists().observe(this, mAdapter::setItems);
    }

    private void editShoppingList(ShoppingListForList shoppingList) {
        Intent intent = new Intent(MainActivity.this,
                EditShoppingListActivity.class);
        intent.putExtra(EditShoppingListActivity.EXTRA_SHOPPING_LIST_ID,
                shoppingList.id);
        startActivity(intent);
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button)
                .setOnClickListener(view -> addNewShoppingList());
    }

    private void addNewShoppingList() {
        startActivity(new Intent(this, AddShoppingListActivity.class));
    }
}