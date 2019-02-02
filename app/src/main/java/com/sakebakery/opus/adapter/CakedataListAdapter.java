package com.sakebakery.opus.adapter;

import android.app.Activity;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;

import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

//public class CakedataListAdapter extends RecyclerView.Adapter<CakedataListAdapter.ViewHolder> {

//    private LayoutInflater mInflater;
//    private Activity activity;
//    private ArrayList<Cakeobj> cakeObjs;
//
//    public CakedataListAdapter(Activity activity, ArrayList<Cakeobj> cakeObjs) {
//        this.mInflater = LayoutInflater.from(activity);
//        this.activity = activity;
//        this.cakeObjs = cakeObjs;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = mInflater.inflate(R.layout.displaycake, viewGroup, false);
//        return new CakedataListAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
//
//        viewHolder.cake_flavor.setText(cakeObjs.get(position).getCake_flavor());
//        viewHolder.icing_flavor.setText(cakeObjs.get(position).getIcing_flavor());
//        viewHolder.top_decorations.setText(cakeObjs.get(position).getTop_deco());
//        viewHolder.side_decorations.setText(cakeObjs.get(position).getSide_deco());
//        viewHolder.description.setText(cakeObjs.get(position).getDescription());
//        viewHolder.price.setText(cakeObjs.get(position).getCake_price());
//
//        try {
//            Picasso.with(activity).load(cakeObjs.get(position).getCake_thumbnail()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.image);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return cakeObjs.size();
//    }
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView cake_flavor;
//        public TextView icing_flavor;
//        public TextView top_decorations;
//        public TextView side_decorations;
//        public TextView description;
//        public TextView price;
//        public ImageView image;
//
//
//        public ViewHolder(View view) {
//            super(view);
//            this.cake_flavor = view.findViewById(R.id.textView13);
//            this.icing_flavor = view.findViewById(R.id.textView14);
//            this.top_decorations = view.findViewById(R.id.textView15);
//            this.side_decorations = view.findViewById(R.id.textView16);
//            this.description=view.findViewById(R.id.textView17);
//            this.price=view.findViewById(R.id.textView8);
//            this.image=view.findViewById(R.id.imageView);
//        }
//    }
//}
