package com.margretcraft.naturepicture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<ThreePicture> threePictures;
    private LayoutInflater inflater;

    public ItemAdapter(ArrayList<ThreePicture> threePictures, Context context) {
        this.threePictures = threePictures;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @NotNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.picture_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemAdapter.ViewHolder holder, int position) {
        ThreePicture threePicture = threePictures.get(position);
        holder.imageView1.setImageBitmap(threePicture.getBm1());
        holder.imageView2.setImageBitmap(threePicture.getBm2());
        holder.imageView3.setImageBitmap(threePicture.getBm3());
    }

    @Override
    public int getItemCount() {
        return threePictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView1;
        final ImageView imageView2;
        final ImageView imageView3;


        ViewHolder(View view) {
            super(view);
            imageView1 = (ImageView) view.findViewById(R.id.imageView1);
            imageView2 = (ImageView) view.findViewById(R.id.imageView2);
            imageView3 = (ImageView) view.findViewById(R.id.imageView3);

        }
}

}
