package one.credify.wallet_app_credify.app.wallet.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.MainActivity;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.wallet.WalletContract;
import one.credify.wallet_app_credify.app.wallet.adapter.WalletAdapter;
import one.credify.wallet_app_credify.app.wallet.presenter.WalletPresenter;
import one.credify.wallet_app_credify.core.model.Coin;

public class WalletActivity extends BaseActivity implements WalletContract.WalletView {
    private final String TAG = MainActivity.class.getSimpleName();
    private WalletContract.TransactionWalletPresenter mTransactionWallet;

    @BindView(R.id.recycler_id)
    RecyclerView recyclerView;

    WalletAdapter mWalletAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        mTransactionWallet = new WalletPresenter(this);
        mWalletAdapter = new WalletAdapter();

        recyclerView.setAdapter(mWalletAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mTransactionWallet.fetchWallets();
    }

    @Override
    public void showWallets(List<Coin> coins) {
//        NewAdapter adapter = new NewAdapter(getApplicationContext(), wallets);
//        recyclerView.setAdapter(adapter);
        mWalletAdapter.setData(coins);
    }

    @Override
    public void setPresenter(WalletContract.TransactionWalletPresenter presenter) {

    }
}
