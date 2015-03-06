package edu.kazushi.todolist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by kazushi on 3/5/15.
 */
public class TodoRepo {
    /** Database Helper */
    private DatabaseHelper dbHelper;

    public TodoRepo(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    /**
     * insert todo properties to the todo tables
     * @param todo
     */
    public void insert(Todo todo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        //values.put(Todo.KEY_ID, null);
        values.put(Todo.KEY_TEXT, todo.getText());
        values.put(Todo.KEY_IS_CHECKED, todo.getIsChecked());
        values.put(Todo.KEY_COLOR, todo.getColor());

        db.insert(Todo.TABLE_NAME, null, values);

        dbHelper.close();
    }

    /**
     * select all of the todo list
     * @return ArrayList<Todo>
     */
    public ArrayList<Todo> getTodoList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Todo> todoList = new ArrayList<Todo>();
        Cursor c = db.query(Todo.TABLE_NAME, null, null, null, null, null, null);

        if (c.moveToFirst()) {
            do {
                Todo todo = new Todo();
                //set the properties of the row
                todo.setId(c.getInt(c.getColumnIndex(Todo.KEY_ID)));
                todo.setText(c.getString(c.getColumnIndex(Todo.KEY_TEXT)));
                todo.setIsChecked(Boolean.valueOf(c.getString(c.getColumnIndex(Todo.KEY_IS_CHECKED))));
                todo.setColor(c.getString(c.getColumnIndex(Todo.KEY_COLOR)));
                // add it to the todo array list
                todoList.add(todo);
            } while (c.moveToNext());
        }

        db.close();
        return todoList;
    }
}
