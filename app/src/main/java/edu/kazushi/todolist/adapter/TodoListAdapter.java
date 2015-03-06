package edu.kazushi.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import edu.kazushi.todolist.R;
import edu.kazushi.todolist.database.Todo;

/**
 * Created by kazushi on 2/28/15.
 */
public class TodoListAdapter extends ArrayAdapter<Todo> {

    /** ArrayList of TodoText */
    ArrayList<Todo> todoTextList;

    public TodoListAdapter(Context context, ArrayList<Todo> todoTextList) {
        super(context, 0, todoTextList);
        this.todoTextList = todoTextList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) { // if the view is null
            LayoutInflater li = LayoutInflater.from(this.getContext());
            view = li.inflate(R.layout.row_todo_list, null);
        }
        Todo td = todoTextList.get(position);

        CheckBox rowCheckBox = (CheckBox) view.findViewById(R.id.rowCheckBox);
        TextView rowTodoText = (TextView) view.findViewById(R.id.rowTodoText);

        rowCheckBox.setText(td.getText());
        rowCheckBox.setChecked(td.getIsChecked());

        return view;
    }

}
