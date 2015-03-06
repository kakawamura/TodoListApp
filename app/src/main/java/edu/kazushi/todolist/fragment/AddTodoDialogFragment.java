package edu.kazushi.todolist.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import edu.kazushi.todolist.R;
import edu.kazushi.todolist.database.Todo;
import edu.kazushi.todolist.database.TodoRepo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddTodoDialogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddTodoDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTodoDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    /** TAG name for log */
    private final String TAG = getClass().getSimpleName();

    private static final String ARG_PARAM_RESOURCE_ID = "resource_id";

    EditText todoEditText;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param resourceId
     * @return A new instance of fragment AddTodoDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddTodoDialogFragment newInstance(int resourceId) {
        AddTodoDialogFragment fragment = new AddTodoDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_RESOURCE_ID, resourceId);
        fragment.setArguments(args);
        return fragment;
    }

    public AddTodoDialogFragment() {
        // Required empty public constructor
    }




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //int title = getArguments().getInt("title");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.fragment_add_todo_dialog, null);
        return new AlertDialog.Builder(getActivity())
            .setView(v)
            .setPositiveButton(getString(R.string.add_button), this)
            .setNegativeButton(getString(R.string.cancel_button), this)
            .create();
        //todoEditText = (EditText) v.findViewById(R.id.todoEdiText);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(DialogInterface dialog, int whichButton) {
        switch(whichButton) {
            case DialogInterface.BUTTON_POSITIVE:
                insertTodo();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                break;
            default:
                break;
        }
    }

    private void insertTodo() {
        TodoRepo repo = new TodoRepo(getActivity());
        Todo todo = new Todo();

        todo.setText("test");
        todo.setIsChecked(false);
        todo.setColor("black");

        repo.insert(todo);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
