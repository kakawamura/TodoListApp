package edu.kazushi.todolist.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kazushi on 3/5/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /** Tag name for log */
    private final String TAG = this.getClass().getSimpleName();
    /** Database Name */
    static final String DATABASE_NAME = "todo_listDB";
    /** Database Version*/
    static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create table in the database
        String createTableTodo = "CREATE TABLE " + Todo.TABLE_NAME + "("
            + Todo.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Todo.KEY_TEXT + " TEXT ,"
            + Todo.KEY_IS_CHECKED + " TEXT ,"
            + Todo.KEY_COLOR + " TEXT);";
        db.execSQL(createTableTodo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Todo.TABLE_NAME);
        onCreate(db);
    }

    public void open() {
        this.getWritableDatabase();
    }
}
