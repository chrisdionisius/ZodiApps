package com.example.zodiapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListZodiacAdapter extends RecyclerView.Adapter<ListZodiacAdapter.ListViewHolder>{

    private ArrayList<Zodiac> listZodiac;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListZodiacAdapter(ArrayList<Zodiac> listZodiac) {
        this.listZodiac = listZodiac;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_zodiac, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Zodiac zodiac = listZodiac.get(position);
        Glide.with(holder.itemView.getContext())
                .load(zodiac.getPicture())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPicture);
        holder.tvName.setText(zodiac.getName());
        holder.tvDate.setText(zodiac.getDate());
        holder.tvDetail.setText(zodiac.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listZodiac.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listZodiac.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPicture;
        TextView tvName, tvDetail, tvDate;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPicture = itemView.findViewById(R.id.img_item_picture);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDate= itemView.findViewById(R.id.tv_item_date);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
    public interface OnItemClickCallback {
        void onItemClicked(Zodiac data);
    }
}
