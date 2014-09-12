package database;

/**
 * Created by Joost on 5-9-2014.
 */
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Grocery_copy {

    //variables for database
    @DatabaseField(generatedId=true)
    private int _id;

    @DatabaseField
    String groceryName;
    @DatabaseField
    int checked;


    //setters and getters
    public void setId(int id) {
        this._id = id;
    }

    public int getId() {
        return _id;
    }

    public void setGroceryName(String groceryName){
        this.groceryName = groceryName;
    }

    public String getGroceryName(){
        return groceryName;
    }

    public void setChecked(int checked){
        this.checked = checked;
    }

    public int getChecked(){
        return checked;
    }

    //constructor
    public void setGrocery(String groceryName, int checked){
        this.groceryName = groceryName;
        this.checked = checked;
    }


}
