package one.credify.wallet_app_credify.app.transfer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.app.transfer.presenter.TransferConfirmationPresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.Constants;

public class TransferConfirmationActivity extends BaseActivity implements TransferContract.TransferConfirmationView {
    private TransferContract.TransferConfirmationPresenter mTransferConfirmation;

    @BindView(R.id.tv_transfer_to)
    TextView tvTransferTo;
    @BindView(R.id.et_amount_input)
    EditText etAmountInput;
    @BindView(R.id.tv_coin_unit)
    TextView tvCoinUnit;

    @OnClick(R.id.bt_set_max)
    public void btSetMaxOnClick() {

    }

    @OnClick(R.id.bt_currency_change)
    public void btCurrencyChangeOnClick() {

    }

    @OnClick(R.id.bt_transfer)
    public void btTransferOnClick() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_confirmation);
        ButterKnife.bind(this);

        mTransferConfirmation = new TransferConfirmationPresenter(this);

        receiveUIData();
        setupUI();
    }

    private void receiveUIData() {
        Intent intent = getIntent();
        Coin coin = (Coin) intent.getSerializableExtra(Constants.TRANSFER_COIN_INTENT);
        mTransferConfirmation.setCoinData(coin);

        String qrData = (String)intent.getSerializableExtra(Constants.TRANSFER_QR_DATA);
        mTransferConfirmation.setQrData(qrData);
    }

    private void setupUI() {
        setToolbarTitle("Transfer " + mTransferConfirmation.getCoinData().getCoinName());
        hideBackButton();

        tvTransferTo.setText("To: " + mTransferConfirmation.getQrData());
    }

    @Override
    public void setPresenter(TransferContract.TransferQrScanPresenter presenter) {

    }
}
