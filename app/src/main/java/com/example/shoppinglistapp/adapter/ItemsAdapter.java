package com.example.shoppinglistapp.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.model.Items;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private Context context;
    private List<Items> list;

    private OnCallBack onCallBack;

    public ItemsAdapter(Context context, List<Items> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnCallBack(OnCallBack onCallBack) {
        this.onCallBack = onCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(list.get(position).getText());

        holder.btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onCallBack.onButtonDeleteClick(list.get(position));
            }
        });

        holder.btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onCallBack.onButtonEditClick(list.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageButton btnDelete, btnEdit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnEdit = itemView.findViewById(R.id.btn_edit);
        }
    }

    public interface OnCallBack{
        void onButtonDeleteClick(Items items);
        void onButtonEditClick(Items items);
    }
}
