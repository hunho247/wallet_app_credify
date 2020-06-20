package one.credify.wallet_app_credify.app.transfer.presenter;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.core.model.Coin;

public class TransferConfirmationPresenter implements TransferContract.TransferConfirmationPresenter {
    private TransferContract.TransferConfirmationView mTransferConfirmationView;
    private Coin mCoin;
    private String mQrData;

    public TransferConfirmationPresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mTransferConfirmationView = (TransferContract.TransferConfirmationView) baseView;
    }

    @Override
    public void setCoinData(Coin coin) {
        mCoin = coin;
    }

    @Override
    public Coin getCoinData() {
        return mCoin;
    }

    @Override
    public void setQrData(String qrData) {
        mQrData = qrData;
    }

    @Override
    public String getQrData() {
        return mQrData;
    }
}
