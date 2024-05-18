package com.kenaidev.calculatorapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kenaidev.calculatorapp.R;
import com.kenaidev.calculatorapp.db.Calculation;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Calculation> calculationList;
    public Adapter(List<Calculation> calculationList) {
        this.calculationList = calculationList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_layout, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Calculation calculation = calculationList.get(position);

        holder.tvId.setText(String.valueOf(calculation.id));
        holder.tvFirstValue.setText(String.valueOf(calculation.valueA));
        holder.tvSecondValue.setText(String.valueOf(calculation.valueA));
        holder.tvOperation.setText(String.valueOf(calculation.operation));
        holder.tvDateHour.setText(String.valueOf(calculation.dateHour));
        holder.tvResult.setText(String.valueOf(calculation.result));
    }

    @Override
    public int getItemCount() {
        return calculationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvFirstValue;
        TextView tvSecondValue;
        TextView tvOperation;
        TextView tvDateHour;
        TextView tvResult;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.txt_id_result);
            tvFirstValue = itemView.findViewById(R.id.txt_value_first_result);
            tvSecondValue = itemView.findViewById(R.id.txt_second_value);
            tvOperation = itemView.findViewById(R.id.txt_operation);
            tvDateHour = itemView.findViewById(R.id.txt_date);
            tvResult = itemView.findViewById(R.id.txt_result_calculation);
        }
    }

}
