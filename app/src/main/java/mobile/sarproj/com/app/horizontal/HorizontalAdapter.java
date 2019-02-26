package mobile.sarproj.com.app.horizontal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import mobile.sarproj.com.app.R;
import mobile.sarproj.com.layout.SwipeLayout;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ItemHolder> {
    private List<String> items;

    HorizontalAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case 0:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_0, viewGroup, false));
            case 1:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_1, viewGroup, false));
            case 2:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_2, viewGroup, false));
            case 3:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_3, viewGroup, false));
            case 4:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_4, viewGroup, false));
            case 5:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_5, viewGroup, false));
            default:
                return new ItemHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_layout_item_6, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        itemHolder.dragItem.setText(items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void remove(Context context, int position) {
        Toast.makeText(context, "removed item " + position, Toast.LENGTH_SHORT).show();
    }

    private void upload(Context context, int position) {
        Toast.makeText(context, "upload item " + position, Toast.LENGTH_SHORT).show();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView dragItem;
        ImageView leftView;
        ImageView rightView;
        SwipeLayout swipeLayout;

        ItemHolder(@NonNull final View itemView) {
            super(itemView);
            dragItem = itemView.findViewById(R.id.drag_item);
            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            leftView = itemView.findViewById(R.id.left_view);
            rightView = itemView.findViewById(R.id.right_view);

            rightView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != NO_POSITION) {
                        remove(itemView.getContext(), getAdapterPosition());
                    }
                }
            });

            leftView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() != NO_POSITION) {
                        upload(itemView.getContext(), getAdapterPosition());
                    }
                }
            });
        }
    }
}
