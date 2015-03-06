package edu.kazushi.todolist.app;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.kazushi.todolist.R;
import edu.kazushi.todolist.adapter.TodoListAdapter;
import edu.kazushi.todolist.database.Todo;
import edu.kazushi.todolist.database.TodoRepo;
import edu.kazushi.todolist.fragment.AddTodoDialogFragment;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    /** tag */
    final public String TAG = this.getClass().getSimpleName();
    /** the main view */
    private RelativeLayout mainView;
    /** title textview */
    private TextView titleTextView;
    private Button addToListButton;
    /** todo list view */
    private ListView todoListView;

    private TodoListAdapter tdListAdapter;

    private ArrayList<Todo> tdlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set views
        mainView = (RelativeLayout) findViewById(R.id.mainView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        addToListButton = (Button) findViewById(R.id.addToListButton);
        todoListView = (ListView) findViewById(R.id.todoListView);

        //set listeners
        addToListButton.setOnClickListener(this);

        //set adapter
        tdlist = new ArrayList<Todo>();
        for(int i = 0; i< 10; i++) {
            Todo td = new Todo();
            td.setId(1);
            td.setText("lalal");
            td.setIsChecked(true);
            td.setColor("Black");
            tdlist.add(td);
        }
        tdListAdapter = new TodoListAdapter(this, tdlist);
        todoListView.setAdapter(tdListAdapter);

        //testing the database
        Log.d(TAG, "on create");
        TodoRepo repo = new TodoRepo(this);
        for (Todo todo : repo.getTodoList() ) {
            Log.d(TAG, todo.getText());
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.addToListButton:
                showDialog();
                break;
            default:
                break;
        }
    }

    /**
    private void addToList() {
        TodoData td = new TodoData(todoText, false);
        tdlist.add(td);
        tdListAdapter.notifyDataSetChanged();
        showDialog();

        Log.d(TAG, todoText + " has been added");
    }
     */

    /**
     * Show Add Todo Dialog Fragment
     */
    private void showDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment newFragment = AddTodoDialogFragment.newInstance(10);
        newFragment.show(ft,"dialog");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
