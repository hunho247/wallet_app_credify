package one.credify.wallet_app_credify.app.transfer.presenter;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.core.model.Coin;

public class TransferQrScanPresenter implements TransferContract.TransferQrScanPresenter {
    private TransferContract.TransferQrScanView mTransferQrScanView;
    private Coin mCoin;

    public TransferQrScanPresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mTransferQrScanView = (TransferContract.TransferQrScanView) baseView;
    }

    @Override
    public void setCoinData(Coin coin) {
        mCoin = coin;
    }

    @Override
    public Coin getCoinData() {
        return mCoin;
    }
}
