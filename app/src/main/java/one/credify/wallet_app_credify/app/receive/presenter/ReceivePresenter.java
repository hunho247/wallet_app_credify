package one.credify.wallet_app_credify.app.receive.presenter;

import android.util.Log;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.receive.ReceiveContract;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.GenerateQr;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.usecase.base.UseCaseHandler;

public class ReceivePresenter implements ReceiveContract.TransactionReceivePresenter {
    private ReceiveContract.ReceiveView mReceiveView;
    private Coin mCoin;

    public ReceivePresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mReceiveView = (ReceiveContract.ReceiveView) baseView;
    }

    @Override
    public void generateQrCode() {
        String address = mCoin.getPublicKey();

        UseCaseHandler.getInstance().execute(new GenerateQr(),
                new GenerateQr.RequestValues(address),
                new UseCase.UseCaseCallback<GenerateQr.ResponseValue>() {
                    @Override
                    public void onSuccess(GenerateQr.ResponseValue response) {
                        mReceiveView.showGeneratedQr(response.getBitmap(), address);
                    }

                    @Override
                    public void onFailure(String message) {
                        Log.d(ReceivePresenter.class.getSimpleName(), "error generating Qr code");
                    }
                });
    }

    @Override
    public void handleShareButton() {

    }

    @Override
    public void handleCopyButton() {

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
