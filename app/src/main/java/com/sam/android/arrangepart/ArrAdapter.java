package com.sam.android.arrangepart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArrAdapter extends RecyclerView.Adapter<ArrAdapter.ViewHolder> {

    private List<String> currentList;
    private List<String> oppositeList;
    ArrAdapter adapter;

    private ArrAdapter oppositeAdapter;
    public ArrAdapter(List<String> currentList,List<String> oppositeList) {
        this.currentList = currentList;
        this.oppositeList = oppositeList;
        this.adapter =this;
    }
    public void setOppositeAdapter(ArrAdapter oppositeAdapter) {
        this.oppositeAdapter = oppositeAdapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        String word = currentList.get(position);
        holder.word.setText(word);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oppositeList.add(currentList.get(position));
                currentList.remove(position);
                adapter.notifyDataSetChanged();
                oppositeAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView word;
        public ViewHolder (@NonNull View itemView){
            super(itemView);
            word = itemView.findViewById(R.id.text);
        }
    }
}
