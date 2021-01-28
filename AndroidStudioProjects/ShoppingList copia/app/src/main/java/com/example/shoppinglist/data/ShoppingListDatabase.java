package com.example.shoppinglist.data;
//
//import android.content.Context;
//
//import androidx.annotation.NonNull;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.sqlite.db.SupportSQLiteDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Database(entities = {ShoppingList.class}, version = 1, exportSchema = false)
//public abstract class ShoppingListDatabase extends RoomDatabase {
//
//    // Exposición de DAOs
//    public abstract ShoppingListDAO shoppingListDao();
//
//    private static final String DATABASE_NAME = "shopping-list-db";
//
//    private static ShoppingListDatabase INSTANCE;
//
//    private static final int THREADS = 4;
//
//    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);
//
//    public static ShoppingListDatabase getInstance(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (ShoppingListDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                            context.getApplicationContext(), ShoppingListDatabase.class,
//                            DATABASE_NAME)
//                            .addCallback(mRoomCallback)
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    // Prepoblar base de datos con callback
////    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
////        @Override
////        public void onCreate(@NonNull SupportSQLiteDatabase db) {
////            super.onCreate(db);
////
////            dbExecutor.execute(() -> {
////                ShoppingListDAO dao = INSTANCE.shoppingListDao();
////
////                ShoppingList list1 = new ShoppingList("1", "Lista de ejemplo");
////                ShoppingList list2 = new ShoppingList("2", "Banquete de Navidad");
////
////                dao.insert(list1);
////                dao.insert(list2);
////            });
////        }
////    };
//
//    // Prepoblar base de datos con callback
//    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            dbExecutor.execute(() -> {
//                ShoppingListDAO dao = INSTANCE.shoppingListDao();
//
//                List<ShoppingList> lists = new ArrayList<>();
//                for (int i = 0; i < 5; i++) {
//                    String id = UUID.randomUUID().toString();
//                    lists.add(new ShoppingList(id, "Lista " + (i+1)));
//                }
//
//                dao.insertShoppingLists(lists);
//            });
//        }
//
//    };
//
//}
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShoppingList.class}, version = 3, exportSchema = false)
public abstract class ShoppingListDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract ShoppingListDAO shoppingListDao();

    private static final String DATABASE_NAME = "shopping-list-db";

    private static ShoppingListDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ShoppingListDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShoppingListDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ShoppingListDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Prepoblar base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                ShoppingListDAO dao = INSTANCE.shoppingListDao();

                List<ShoppingListInsert> lists = new ArrayList<>();

                for (int i = 0; i < 5; i++) {

                    ShoppingListInsert data = new ShoppingListInsert(
                            String.valueOf((i+1)),
                            "Lista " + (i + 1)
                    );

                    lists.add(data);
                }

                dao.insertShoppingLists(lists);
            });
        }
    };

}