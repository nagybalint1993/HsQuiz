package hu.bme.bgyn.hsquiz.ui.results;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.model.Result;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder>{
    private Context context;
    private List<Result> resultsList;

    public ResultsAdapter(Context context, List<Result> resultsList) {
        this.context = context;
        this.resultsList = resultsList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.result_card, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = resultsList.get(position);
        holder.nameTextView.setText(result.getUser());
        holder.pointsTextView.setText("Points: " + result.getPoint().toString());
        holder.rankTextView.setText(String.valueOf(position+1) +".  ");
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rankTextView;
        public TextView nameTextView;
        public TextView pointsTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            rankTextView = (TextView) itemView.findViewById(R.id.rankTextView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            pointsTextView = (TextView) itemView.findViewById(R.id.pointsTextView);
        }
    }
}
