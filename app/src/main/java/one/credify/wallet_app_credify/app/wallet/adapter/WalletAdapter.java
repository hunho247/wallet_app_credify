package one.credify.wallet_app_credify.app.wallet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.core.model.Coin;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.ViewHolder> {
    private List<Coin> mCoins;

    public WalletAdapter() {
        mCoins = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin_list,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Coin coin = mCoins.get(position);
        holder.mTvCoinSign.setText(coin.getCoinName().charAt(0) + "");
        holder.mTvCoinPrice.setText(coin.getCoinPrice());
        holder.mTvCoinAmount.setText(coin.getCoinAmount());
        holder.mTvCoinName.setText(coin.getCoinName());
    }

    @Override
    public int getItemCount() {
        if (mCoins != null) {
            return mCoins.size();
        } else {
            return 0;
        }
    }

    public void setData(List<Coin> coins) {
        this.mCoins = coins;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_coin_sign)
        TextView mTvCoinSign;
        @BindView(R.id.tv_coin_price)
        TextView mTvCoinPrice;
        @BindView(R.id.tv_coin_amount)
        TextView mTvCoinAmount;
        @BindView(R.id.tv_coin_name)
        TextView mTvCoinName;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}