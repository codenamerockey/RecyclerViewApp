package Adapter.Model;



import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.codenamerockeyrecyclerviewapp.recyclerviewapp.DetailsActivity;
import com.codenamerockeyrecyclerviewapp.recyclerviewapp.R;

import java.text.FieldPosition;
import java.util.List;

import Model.ListItem;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;

    public myAdapter(Context context, List listItem) {
        this.context = context;
        this.listItems = listItem;

    }

    @NonNull
    @Override
    public myAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.ViewHolder viewHolder, int i) {
        ListItem item = listItems.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.description.setText(item.getDescription());
        viewHolder.rating.setText(item.getRating());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public TextView rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name =  itemView.findViewById(R.id.title);
            description =  itemView.findViewById(R.id.description);
            rating =  itemView.findViewById(R.id.rating);

        }

        @Override
        public void onClick(View v) {
            // Get the position of the row clicked or tapped
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("rating", item.getRating());

            context.startActivity(intent);


            //Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();


        }
    }
}
