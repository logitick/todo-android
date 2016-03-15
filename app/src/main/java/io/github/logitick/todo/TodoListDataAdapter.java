package io.github.logitick.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TodoListDataAdapter extends RecyclerView.Adapter<TodoListDataAdapter.ViewHolder>{

    private String[] dataset;

    public TodoListDataAdapter(String[] dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setHeading(dataset[position]);
        holder.setDescription(dataset[position]);
    }

    @Override
    public int getItemCount() {
        if (dataset == null) {
            return 0;
        }
        return dataset.length;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView headingTextView;
        private TextView descriptionTextView;
        public ViewHolder(View v) {
            super(v);
            headingTextView = (TextView) v.findViewById(R.id.todo_list_item_heading);
            descriptionTextView = (TextView) v.findViewById(R.id.todo_list_item_description);
        }

        public void setHeading(String str) {
            this.headingTextView.setText(str);
        }

        public void setDescription(String str) {
            this.descriptionTextView.setText(str);
        }

    }
}
