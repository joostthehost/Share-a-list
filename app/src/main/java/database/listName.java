package database;

/**
 * Created by Joost on 12-9-2014.
 */
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ListName {

    //variables for database
    @DatabaseField(generatedId=true)
    private int _id;

    @DatabaseField
    String listName;
    @DatabaseField
    String details;

    //setters and getters
    public void setId(int id) {
        this._id = id;
    }

    public int getId() {
        return _id;
    }

    public void setListName(String listName){
        this.listName = listName;
    }

    public String getListName(){
        return listName;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public String getDetails(){
        return details;
    }

    //constructor
    public void setListName(String listName, String details){
        this.listName = listName;
        this.details = details;
    }

}
