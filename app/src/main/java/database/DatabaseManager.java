package database;

/**
 * Created by Joost on 5-9-2014.
 */
import android.content.Context;

import java.sql.SQLException;
import java.util.List;

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

    //returns all listnames in the DB
    public List<ListName> getAllListNames() {
        List<ListName> listnames = null;
        try {
            listnames = getHelper().getListNameDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listnames;
    }

    //returns a listname (by presenting the ID)
    public ListName getListNameWithId(int listnameId) {
        ListName listname = null;
        try {
            listname = getHelper().getListNameDao().queryForId(listnameId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listname;
    }

    //add a listname
    public void addListName(ListName listname) {
        try {
            getHelper().getListNameDao().create(listname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update a listname
    public void updateListName(ListName listname) {
        try {
            getHelper().getListNameDao().update(listname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete a listname
    public void deleteListName(ListName listname) {
        try {
            getHelper().getListNameDao().delete(listname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete all listnames
    public void deleteAllListNames() {
        List<ListName> listnames = null;
        try {
            listnames = getHelper().getListNameDao().queryForAll();
            getHelper().getListNameDao().delete(listnames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete all checked listnames
    public void deleteCheckedListNames() {
        List<ListName> listnames = null;
        try {
            //select those rows in the column with name 'checked' has a value of '1'
            listnames = getHelper().getListNameDao().queryForEq("checked", 1);
            getHelper().getListNameDao().delete(listnames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

