package org.nuhadif.emunogu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



public class Bab1Adapter  extends RecyclerView.Adapter<Bab1Adapter.VHBab1>{
    String[] materi;
    String[] image;
    String[] point;

    public Bab1Adapter(String[] materi, String[] image, String[] point) {
        this.materi = materi;
        this.image = image;
        this.point = point;
    }

    @Override
    public VHBab1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_materi, parent, false);
        return new VHBab1(itemView);
    }

    @Override
    public void onBindViewHolder(VHBab1 holder, int position) {
        holder.tvPoint.setText(point[position]);
        try {
            holder.tvMateri.setText(materi[position]);
        }catch (Exception e){
            holder.tvMateri.setVisibility(View.GONE);
        }
        try {
            Picasso.get().load(image[position]).into(holder.ivScan);

        }catch (Exception e){
            holder.ivScan.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return point.length;
    }

    class VHBab1 extends RecyclerView.ViewHolder{
        ImageView ivScan;
        TextView tvMateri;
        TextView tvPoint;

        public VHBab1(View itemView) {
            super(itemView);
            ivScan = itemView.findViewById(R.id.iv_scan);
            tvMateri = itemView.findViewById(R.id.tv_materi);
            tvPoint = itemView.findViewById(R.id.tv_point);
        }
    }
}
