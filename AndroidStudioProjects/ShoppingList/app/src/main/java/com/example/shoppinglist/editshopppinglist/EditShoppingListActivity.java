package com.example.shoppinglist.editshopppinglist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.shoppinglist.R;

public class EditShoppingListActivity extends AppCompatActivity {

    public static final String EXTRA_SHOPPING_LIST_ID = "com.develou.shoppinglist.shoppingListId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_shopping_list);


        // Obtener id de la lista de compras
        String id = getIntent().getStringExtra(EXTRA_SHOPPING_LIST_ID);


        setupActionBar();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}