package one.credify.wallet_app_credify.app.wallet.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.MainActivity;
import one.credify.wallet_app_credify.app.NewAdapter;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.wallet.WalletContract;
import one.credify.wallet_app_credify.app.wallet.presenter.WalletPresenter;
import one.credify.wallet_app_credify.core.model.Wallet;

public class WalletActivity extends BaseActivity implements WalletContract.WalletView {
    private final String TAG = MainActivity.class.getSimpleName();
    private WalletContract.TransactionWalletPresenter mTransactionWallet;

    @BindView(R.id.recycler_id)
    RecyclerView recyclerView;
    @BindView(R.id.pb_wallet)
    ProgressBar pbWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        ButterKnife.bind(this);

        mTransactionWallet = new WalletPresenter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mTransactionWallet.fetchWallets();

        setToolbarTitle("test");
    }

    @Override
    public void showWallets(List<Wallet> wallets) {
        NewAdapter adapter = new NewAdapter(getApplicationContext(), wallets);
        recyclerView.setAdapter(adapter);
        showProgressDialog("hihi");
    }

    @Override
    public void setPresenter(WalletContract.TransactionWalletPresenter presenter) {

    }
}
