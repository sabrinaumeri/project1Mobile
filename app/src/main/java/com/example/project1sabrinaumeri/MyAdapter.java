package com.example.project1sabrinaumeri;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;





public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    String[] value;
    Context context;

    public MyAdapter(Context context, String[] value){
        this.context = context;
        this.value = value;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View v){

            super(v);

        }
    }



    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
