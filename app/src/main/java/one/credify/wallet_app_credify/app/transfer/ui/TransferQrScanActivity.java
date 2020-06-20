package one.credify.wallet_app_credify.app.transfer.ui;

import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.app.transfer.presenter.TransferQrScanPresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.CoinHelper;
import one.credify.wallet_app_credify.core.utils.Constants;

public class TransferQrScanActivity extends BaseActivity implements TransferContract.TransferQrScanView, ZXingScannerView.ResultHandler {
    private TransferContract.TransferQrScanPresenter mTransferQrScan;

    @BindView(R.id.qr_scan_view)
    ZXingScannerView qrScanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_qr_scan);
        ButterKnife.bind(this);

        mTransferQrScan = new TransferQrScanPresenter(this);

        receiveUIData();
        setupUI();
        // test
        handleResultTest("ho thai hung");
    }

    private void receiveUIData() {
        Intent intent = getIntent();
        Coin coin = (Coin) intent.getSerializableExtra(Constants.DETAIL_COIN_INTENT);

        mTransferQrScan.setCoinData(coin);
    }

    private void setupUI() {
        String coinName = CoinHelper.getCoinName(mTransferQrScan.getCoinData().getCoinUnit());
        setToolbarTitle("Transfer " + coinName);
        hideBackButton();

        qrScanView.setAutoFocus(true);
    }

    @Override
    public void onPause() {
        super.onPause();
        qrScanView.stopCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        qrScanView.setResultHandler(this);
        qrScanView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        handleResultTest(result.getText());
    }

    public void handleResultTest(String str) {
        String qrData = str;

        Intent intent = new Intent(this, TransferConfirmationActivity.class);
        intent.putExtra(Constants.TRANSFER_QR_DATA, qrData);
        intent.putExtra(Constants.TRANSFER_COIN_INTENT, mTransferQrScan.getCoinData());
        startActivity(intent);
        finish();
    }

    @Override
    public void setPresenter(TransferContract.TransferQrScanPresenter presenter) {

    }
}