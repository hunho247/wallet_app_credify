package one.credify.wallet_app_credify.app.receive;

import android.graphics.Bitmap;

import one.credify.wallet_app_credify.app.base.BasePresenter;
import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.core.model.Coin;

public interface ReceiveContract {
    interface ReceiveView extends BaseView<ReceiveContract.TransactionReceivePresenter> {
        void showGeneratedQr(Bitmap bitmap, String address);

        void showShareDialog(String address);

        void showCopyToast(String address);
    }

    interface TransactionReceivePresenter extends BasePresenter {
        void generateQrCode();

        void handleShareButton();

        void handleCopyButton();

        void setCoinData(Coin coin);

        Coin getCoinData();
    }
}
