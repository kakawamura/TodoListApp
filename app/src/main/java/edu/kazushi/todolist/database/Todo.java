package edu.kazushi.todolist.database;

/**
 * This class has the properties for Todo table
 *
 * Created by kazushi on 3/5/15.
 */
public class Todo {

    /** Labels Table Name */
    public static final String TABLE_NAME = "todo";

    /** Labels Table Columns name */
    public static final String KEY_ID = "id";
    public static final String KEY_TEXT = "text";
    public static final String KEY_IS_CHECKED = "is_checked";
    public static final String KEY_COLOR = "COLOR";

    /** property of todo data */
    private int id;
    private String text;
    private boolean isChecked;
    private String color;

    /**
     * Constructor
     */
    public Todo() {
        setDefaultValues();
    }

    /**
     * set Default Values to the private variables
     */
    public void setDefaultValues() {
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
