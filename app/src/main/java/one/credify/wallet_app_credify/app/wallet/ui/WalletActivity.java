package one.credify.wallet_app_credify.app.wallet.ui;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.wallet.WalletContract;
import one.credify.wallet_app_credify.app.wallet.adapter.WalletAdapter;
import one.credify.wallet_app_credify.app.wallet.presenter.WalletPresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.RecyclerItemClickListener;

public class WalletActivity extends BaseActivity implements WalletContract.WalletView {
    private WalletContract.TransactionWalletPresenter mTransactionWallet;

    @BindView(R.id.rv_wallet)
    RecyclerView rvWallet;

    private WalletAdapter mWalletAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        mTransactionWallet = new WalletPresenter(this);
        mWalletAdapter = new WalletAdapter();

        setupUi(savedInstanceState);
    }

    private void setupUi(Bundle savedInstanceState) {
        mTransactionWallet.fetchWallets();

        rvWallet.setAdapter(mWalletAdapter);
        rvWallet.setLayoutManager(new LinearLayoutManager(this));
        rvWallet.setHasFixedSize(true);
        rvWallet.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View childView, int position) {
                        mTransactionWallet.handleWalletClick(position);
                    }
                }));
    }

    @Override
    public void showWallets(List<Coin> coins) {
        mWalletAdapter.setData(coins);
    }

    @Override
    public void startHistoryActivity(Coin coin) {

    }

    @Override
    public void setPresenter(WalletContract.TransactionWalletPresenter presenter) {

    }
}
