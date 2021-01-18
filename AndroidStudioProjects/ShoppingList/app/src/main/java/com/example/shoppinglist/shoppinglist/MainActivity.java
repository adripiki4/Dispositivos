package com.example.shoppinglist.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppinglist.R;
import com.example.shoppinglist.addshoppinglist.AddShoppingListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ShoppingListViewModel mViewModel;
    private RecyclerView mList;
    private ShoppingListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(ShoppingListViewModel.class);

        setupList();

        setupFab();
    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new ShoppingListAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getShoppingLists().observe(this, mAdapter::setItems);
    }

    private void setupFab() {
        FloatingActionButton fav = findViewById(R.id.floating_action_button);

                fav.setOnClickListener(view -> addNewShoppingList());
    }

    private void addNewShoppingList() {
        startActivity(new Intent(MainActivity.this, AddShoppingListActivity.class));
    }
}