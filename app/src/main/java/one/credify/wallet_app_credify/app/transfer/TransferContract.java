package one.credify.wallet_app_credify.app.transfer;

import android.graphics.Bitmap;

import one.credify.wallet_app_credify.app.base.BasePresenter;
import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.core.model.Coin;

public interface TransferContract {
    interface TransferQrScanView extends BaseView<TransferContract.TransferQrScanPresenter> {

    }

    interface TransferQrScanPresenter extends BasePresenter {
        void setCoinData(Coin coin);

        Coin getCoinData();
    }
}
