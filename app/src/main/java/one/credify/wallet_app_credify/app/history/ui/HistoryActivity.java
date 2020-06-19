package one.credify.wallet_app_credify.app.history.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.history.HistoryContract;
import one.credify.wallet_app_credify.app.history.adapter.HistoryAdapter;
import one.credify.wallet_app_credify.app.history.presenter.HistoryPresenter;
import one.credify.wallet_app_credify.core.model.History;

public class HistoryActivity extends BaseActivity implements HistoryContract.HistoryView {
    private HistoryContract.TransactionHistoryPresenter mTransactionHistory;

    @BindView(R.id.rv_history)
    RecyclerView rvHistory;

    private HistoryAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        mTransactionHistory = new HistoryPresenter(this);
        mHistoryAdapter = new HistoryAdapter();

        rvHistory.setAdapter(mHistoryAdapter);

        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setHasFixedSize(true);

        mTransactionHistory.fetchHistories();
        setToolbarTitle("Bitcoin");
    }
    
    @Override
    public void showHistories(List<History> histories) {
        mHistoryAdapter.setData(histories);
    }

    @Override
    public void setPresenter(HistoryContract.TransactionHistoryPresenter presenter) {

    }
}
