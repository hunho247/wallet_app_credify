package one.credify.wallet_app_credify.app;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import one.credify.wallet_app_credify.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView description;

    public NewsViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.post_title);
        description = (TextView) itemView.findViewById(R.id.post_description);
    }
}
