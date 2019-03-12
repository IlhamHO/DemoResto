package be.ehb.demoresto.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import be.ehb.demoresto.R;
import be.ehb.demoresto.model.Resto;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.RestoRowViewHolder> {


    class  RestoRowViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName, tvAddress;

        public RestoRowViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_row_name);
            tvAddress = itemView.findViewById(R.id.tv_row_address);
        }
    }

    private ArrayList<Resto> items;

    public RestoAdapter(ArrayList<Resto> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RestoRowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rowView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resto_row,viewGroup,false);
        RestoRowViewHolder holder = new RestoRowViewHolder(rowView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestoRowViewHolder restoRowViewHolder, int i) {
        Resto currentResto = items.get(i);

        restoRowViewHolder.tvName.setText(currentResto.getNaam());
        restoRowViewHolder.tvAddress.setText(currentResto.getAdres());

    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void setItems(ArrayList<Resto> restos) {
        items.addAll(restos);
    }

}
