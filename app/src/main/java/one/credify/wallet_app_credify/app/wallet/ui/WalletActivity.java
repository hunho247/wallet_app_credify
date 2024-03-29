package one.credify.wallet_app_credify.app.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.detail.ui.DetailActivity;
import one.credify.wallet_app_credify.app.wallet.WalletContract;
import one.credify.wallet_app_credify.app.wallet.adapter.WalletAdapter;
import one.credify.wallet_app_credify.app.wallet.presenter.WalletPresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.Constants;
import one.credify.wallet_app_credify.core.utils.RecyclerItemClickListener;

public class WalletActivity extends BaseActivity implements WalletContract.WalletView {
    private WalletContract.TransactionWalletPresenter mTransactionWallet;

    @BindView(R.id.rv_wallet)
    RecyclerView rvWallet;
    @BindView(R.id.pb_wallet_loading)
    ProgressBar pbWalletLoading;

    private WalletAdapter mWalletAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        mTransactionWallet = new WalletPresenter(this);
        mWalletAdapter = new WalletAdapter();

        setupUI();
    }

    private void setupUI() {
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

        hideBackButton();
        hideCloseButton();
    }

    @Override
    public void showWallets(List<Coin> coins) {
        mWalletAdapter.setData(coins);
        pbWalletLoading.setVisibility(View.GONE);
    }

    @Override
    public void startHistoryActivity(Coin coin) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constants.WALLET_COIN_INTENT, coin);
        startActivity(intent);
    }

    @Override
    public void showFailureDialog(String message) {
        showAlertDialog("Failure!",message);
        pbWalletLoading.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(WalletContract.TransactionWalletPresenter presenter) {

    }
}
