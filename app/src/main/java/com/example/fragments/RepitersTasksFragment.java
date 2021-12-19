package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RepitersTasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RepitersTasksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RepitersTasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RepitersTasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RepitersTasksFragment newInstance(String param1, String param2) {
        RepitersTasksFragment fragment = new RepitersTasksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_repiters_tasks, container, false);
        EditText new_repeat_task;
        Button add_repeat_task, delete_repeat_task;
        TextView repeat_tasks;

        new_repeat_task = v.findViewById(R.id.new_repeat_task);
        add_repeat_task = v.findViewById(R.id.add_repeat_task);
        repeat_tasks = v.findViewById(R.id.repeat_tasks);
        delete_repeat_task = v.findViewById(R.id.delete_repeat_task);

        add_repeat_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = new_repeat_task.getText().toString();
                String b = repeat_tasks.getText().toString();
                b+="\n"+a;
                repeat_tasks.setText(b);
            }
        });

        delete_repeat_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeat_tasks.setText("");
            }
        });

        return v;
    }
}