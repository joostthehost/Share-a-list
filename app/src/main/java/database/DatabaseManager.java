package database;

/**
 * Created by Joost on 5-9-2014.
 */
import java.sql.SQLException;
import java.util.List;

import android.content.Context;

public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }


    //first methods implemented below
    //extend this class with other methods when needed

    //returns all groceries in the DB
    public List<Grocery> getAllGroceries() {
        List<Grocery> groceries = null;
        try {
            groceries = getHelper().getGroceryDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groceries;
    }

    //returns a grocery (by presenting the ID)
    public Grocery getGroceryWithId(int groceryId) {
        Grocery grocery = null;
        try {
            grocery = getHelper().getGroceryDao().queryForId(groceryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grocery;
    }

    //add a grocery
    public void addGrocery(Grocery grocery) {
        try {
            getHelper().getGroceryDao().create(grocery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update a grocery
    public void updateGrocery(Grocery grocery) {
        try {
            getHelper().getGroceryDao().update(grocery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete a grocery
    public void deleteGrocery(Grocery grocery) {
        try {
            getHelper().getGroceryDao().delete(grocery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete all groceries
    public void deleteAllGroceries() {
        List<Grocery> groceries = null;
        try {
            groceries = getHelper().getGroceryDao().queryForAll();
            getHelper().getGroceryDao().delete(groceries);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete all checked groceries
    public void deleteCheckedGroceries() {
        List<Grocery> groceries = null;
        try {
            //select those rows in the column with name 'checked' has a value of '1'
            groceries = getHelper().getGroceryDao().queryForEq("checked", 1);
            getHelper().getGroceryDao().delete(groceries);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

