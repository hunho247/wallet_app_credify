package one.credify.wallet_app_credify.app.transfer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.app.transfer.presenter.TransferQrScanPresenter;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.utils.CoinHelper;
import one.credify.wallet_app_credify.core.utils.Constants;

public class TransferQrScanActivity extends BaseActivity implements TransferContract.TransferQrScanView {
    private TransferContract.TransferQrScanPresenter mTransferQrScan;
    private CodeScanner mCodeScanner;
    private CodeScannerView qrScanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_qr_scan);
        ButterKnife.bind(this);

        qrScanView = findViewById(R.id.qr_scan_view);
        mCodeScanner = new CodeScanner(this, qrScanView);
        mTransferQrScan = new TransferQrScanPresenter(this);

        receiveUIData();
        setupUI();
        // test
        //switchToConfirmationScreen("6dfere7fdg5d7fg8fdg98xxx");
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

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                switchToConfirmationScreen(result.getText());
            }
        });
        qrScanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCodeScanner.releaseResources();
    }

    private void switchToConfirmationScreen(String qrData) {
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