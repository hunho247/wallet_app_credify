package one.credify.wallet_app_credify.app.detail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.detail.DetailContract;
import one.credify.wallet_app_credify.app.detail.adapter.DetailAdapter;
import one.credify.wallet_app_credify.app.detail.presenter.DetailPresenter;
import one.credify.wallet_app_credify.app.receive.ui.ReceiveActivity;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.model.History;
import one.credify.wallet_app_credify.core.utils.Constants;

public class DetailActivity extends BaseActivity implements DetailContract.DetailView {
    private DetailContract.TransactionDetailPresenter mTransactionDetail;
    private DetailAdapter mDetailAdapter;

    @BindView(R.id.rv_history)
    RecyclerView rvHistory;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    @OnClick(R.id.bt_receive)
    public void btReceiveOnClick() {
        Coin coin = mTransactionDetail.getCoinData();

        Intent intent = new Intent(this, ReceiveActivity.class);
        intent.putExtra(Constants.DETAIL_COIN_INTENT, coin);
        startActivity(intent);
    }

    @OnClick(R.id.bt_transfer)
    public void btTransferOnClick() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        mTransactionDetail = new DetailPresenter(this);
        mDetailAdapter = new DetailAdapter();

        receiveUIData();
        setupUI();
    }

    private void receiveUIData() {
        Intent intent = getIntent();
        Coin coin = (Coin) intent.getSerializableExtra(Constants.WALLET_COIN_INTENT);

        mTransactionDetail.setCoinData(coin);
    }

    private void setupUI() {
        setToolbarTitle(mTransactionDetail.getCoinData().getCoinName());
        rvHistory.setAdapter(mDetailAdapter);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setHasFixedSize(true);

        mTransactionDetail.fetchHistories();

        hideCloseButton();
    }

    @Override
    public void showHistories(List<History> histories) {
        mDetailAdapter.setData(histories);
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(DetailContract.TransactionDetailPresenter presenter) {

    }
}
