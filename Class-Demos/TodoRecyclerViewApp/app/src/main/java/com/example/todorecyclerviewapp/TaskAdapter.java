package com.example.todorecyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder>
{
    private List<Task> mTaskList;

    public TaskAdapter(List<Task> taskList)
    {
        this.mTaskList = taskList;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder
    {
        TextView mTextViewTitle;
        TextView mTextViewDescription;
        TextView mTextViewStatus;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.textview_title);
            mTextViewDescription = itemView.findViewById(R.id.textview_description);
            mTextViewStatus = itemView.findViewById(R.id.textview_status);
        }
    }

    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {

        Task currentTask = mTaskList.get(position);

        holder.mTextViewTitle.setText(currentTask.getTitle());
        holder.mTextViewDescription.setText(currentTask.getDescription());

        if (currentTask.isCompleted()) {
            holder.mTextViewStatus.setText("Completed");
        } else {
            holder.mTextViewStatus.setText("Incomplete");
        }
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
