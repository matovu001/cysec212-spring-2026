package com.example.todorecyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewTasks;
    TaskAdapter mTaskAdapter;
    List<Task> mTaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mRecyclerViewTasks = findViewById(R.id.recyclerview_tasks);
        mRecyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));

        generateTasks();
        mTaskAdapter = new TaskAdapter(mTaskList);
        mRecyclerViewTasks.setAdapter(mTaskAdapter);
    }

    private void generateTasks()
    {
        mTaskList = new ArrayList<>();
        mTaskList.add(new Task("Buy groceries", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class", "Come for the Thursday 12pm class", true));
        mTaskList.add(new Task("Buy groceries 2", "Buy milk, eggs, bread", true));
        mTaskList.add(new Task("Complete Exam 2", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 2", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 3", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 3", "Finish up the CYSEC 212 Exam", true));
        mTaskList.add(new Task("Attend Class 3", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 4 ", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 5 ", "Finish up the CYSEC 212 Exam", true));
        mTaskList.add(new Task("Attend Class 6", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 8", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 10", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 10", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 8", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 10", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 10", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 8", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 10", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 10", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 8", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 10", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 10", "Come for the Thursday 12pm class", false));
        mTaskList.add(new Task("Buy groceries 900", "Buy milk, eggs, bread", false));
        mTaskList.add(new Task("Complete Exam 100", "Finish up the CYSEC 212 Exam", false));
        mTaskList.add(new Task("Attend Class 100", "Come for the Thursday 12pm class", false));

    }
}