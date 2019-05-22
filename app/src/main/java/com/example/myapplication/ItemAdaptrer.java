package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.ItemlayoutBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdaptrer extends PagedListAdapter<ApimoviesResponse.Results,ItemAdaptrer.MyViewmodell> {


   Context context;

    public ItemAdaptrer(Context context) {
        super(diffcallback);
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewmodell onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemlayoutBinding itemlayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.itemlayout,parent,false);
        return new MyViewmodell(itemlayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewmodell holder, int position) {
        ApimoviesResponse.Results results = getItem(position);
        holder.itemlayoutBinding.setMoviedata(results);

    }

    public class MyViewmodell extends RecyclerView.ViewHolder {
        ItemlayoutBinding itemlayoutBinding;
        public MyViewmodell(  ItemlayoutBinding itemlayoutBinding) {
            super(itemlayoutBinding.getRoot());
            this.itemlayoutBinding = itemlayoutBinding;
        }
    }
    private static DiffUtil.ItemCallback<ApimoviesResponse.Results> diffcallback = new DiffUtil.ItemCallback<ApimoviesResponse.Results>() {
        @Override
        public boolean areItemsTheSame(@NonNull ApimoviesResponse.Results oldItem, @NonNull ApimoviesResponse.Results newItem) {
            return oldItem.adult ==newItem.adult;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ApimoviesResponse.Results oldItem, @NonNull ApimoviesResponse.Results newItem) {
            return oldItem.equals(newItem);
        }
    };
}
