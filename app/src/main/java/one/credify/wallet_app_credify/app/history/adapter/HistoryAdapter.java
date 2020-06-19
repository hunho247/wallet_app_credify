package one.credify.wallet_app_credify.app.history.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.core.model.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<History> mHistories;

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_list,
                parent, false);
        return new HistoryAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.ViewHolder holder, final int position) {
        final History history = mHistories.get(position);
        holder.mTvAddress.setText(history.getAddress());
        holder.mTvDateTime.setText(history.getDateTime());
        holder.mTvCoinAmount.setText(history.getCoinAmount());

        if (history.getStatus() == History.Status.TRANSFER) {
            holder.mIvSendReceiveIcon.setRotation(0);
            holder.mTvCoinAmount.setTextColor(Color.parseColor("#DB4A39"));
        }
        else {
            holder.mIvSendReceiveIcon.setRotation(180);
            holder.mTvCoinAmount.setTextColor(Color.parseColor("#22861B"));
        }
    }

    @Override
    public int getItemCount() {
        if (mHistories != null) {
            return mHistories.size();
        } else {
            return 0;
        }
    }

    public void setData(List<History> histories) {
        this.mHistories = histories;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_address)
        TextView mTvAddress;
        @BindView(R.id.tv_date_time)
        TextView mTvDateTime;
        @BindView(R.id.tv_coin_amount)
        TextView mTvCoinAmount;
        @BindView(R.id.iv_send_receive_icon)
        ImageView mIvSendReceiveIcon;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
