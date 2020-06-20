package one.credify.wallet_app_credify.app.transfer.presenter;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.transfer.TransferContract;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.ConnectCoinNetwork;
import one.credify.wallet_app_credify.core.usecase.FetchHistory;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.usecase.base.UseCaseHandler;

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
    public void transferCoin(String amount) {
        UseCaseHandler.getInstance().execute(new ConnectCoinNetwork(),
                new ConnectCoinNetwork.RequestValues(mCoin, mQrData, amount),
                new UseCase.UseCaseCallback<ConnectCoinNetwork.ResponseValue>() {
                    @Override
                    public void onSuccess(ConnectCoinNetwork.ResponseValue response) {
                    }

                    @Override
                    public void onFailure(String message) {
                        mTransferConfirmationView.showFailureDialog(message);
                    }
                });
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
