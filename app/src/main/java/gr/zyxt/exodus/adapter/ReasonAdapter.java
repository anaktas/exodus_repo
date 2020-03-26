package gr.zyxt.exodus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.enumeration.ReasonEnum;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 * Created on 24, March, 2020
 */
public class ReasonAdapter extends RecyclerView.Adapter<ReasonAdapter.ReasonViewHolder> {
    private ArrayList<ReasonEnum> mReasons;
    private OnItemClickListener listener;

    public ReasonAdapter(ArrayList<ReasonEnum> reasons, OnItemClickListener listener) {
        mReasons = reasons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ReasonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_reason_list_item, parent, false);
        return new ReasonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReasonViewHolder holder, int position) {
        holder.reasonText.setText(mReasons.get(position).getDescription());
        holder.reasonText.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(mReasons.get(position), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mReasons.size();
    }

    public static class ReasonViewHolder extends RecyclerView.ViewHolder {
        public TextView reasonText;
        public ReasonViewHolder(View view) {
            super(view);
            reasonText = view.findViewById(R.id.list_item);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ReasonEnum reason, int position);
    }
}
