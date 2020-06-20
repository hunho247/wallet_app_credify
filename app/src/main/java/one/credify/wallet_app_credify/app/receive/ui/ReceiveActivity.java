package one.credify.wallet_app_credify.app.receive.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.receive.ReceiveContract;
import one.credify.wallet_app_credify.app.receive.presenter.ReceivePresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.CoinHelper;
import one.credify.wallet_app_credify.core.utils.Constants;

public class ReceiveActivity extends BaseActivity implements ReceiveContract.ReceiveView{
    private ReceiveContract.TransactionReceivePresenter mTransactionReceive;

    @BindView(R.id.iv_qr_code)
    ImageView ivQrCode;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @OnClick(R.id.bt_share)
    public void btShareOnClick() {

    }

    @OnClick(R.id.bt_copy)
    public void btCopyOnClick() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        ButterKnife.bind(this);

        mTransactionReceive = new ReceivePresenter(this);

        receiveUIData();
        setupUI();
    }

    private void receiveUIData() {
        Intent intent = getIntent();
        Coin coin = (Coin) intent.getSerializableExtra(Constants.DETAIL_COIN_INTENT);

        mTransactionReceive.setCoinData(coin);
    }

    private void setupUI() {
        String coinName = CoinHelper.getCoinName(mTransactionReceive.getCoinData().getCoinUnit());
        setToolbarTitle("Receive " + coinName);
        hideBackButton();

        mTransactionReceive.generateQrCode();
    }

    @Override
    public void showGeneratedQr(Bitmap bitmap, String address) {
        ivQrCode.setImageBitmap(bitmap);
        tvAddress.setText(address);
    }

    @Override
    public void showShareDialog(String address) {

    }

    @Override
    public void showCopyToast(String address) {

    }

    @Override
    public void setPresenter(ReceiveContract.TransactionReceivePresenter presenter) {

    }
}
