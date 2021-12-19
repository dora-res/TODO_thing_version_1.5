package com.example.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    Button to_current_task, to_finished_task, to_repiters_task;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragment1, fragment2, fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        fragment1 = fm.findFragmentById(R.id.fragment_container);
        if(fragment1 == null){
            fragment1 = new CurrentTaskFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment1)
                    .commit();
        }

        to_current_task = findViewById(R.id.to_current_task);
        to_finished_task = findViewById(R.id.to_finished_task);
        to_repiters_task = findViewById(R.id.to_repiters_task);

        to_finished_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment2 == null){
                    fragment2 = new FinishTaskFragment();
                }
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment2);
                ft.commit();
            }
        });

        to_current_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment1 == null){
                    fragment1 = new CurrentTaskFragment();
                }
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment1);
                ft.commit();
            }
        });

        to_repiters_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment3 == null){
                    fragment3 = new RepitersTasksFragment();
                }
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, fragment3);
                ft.commit();
            }
        });

    }
}
//TODO написать возврат к первому фрагменту DONE
//TODO добавить 3тий фрагмент для повторяющихся задач DONE
//TODO придумать способ хранения введенных пользователем задач
//TODO 3.6.2 на сайте порешать