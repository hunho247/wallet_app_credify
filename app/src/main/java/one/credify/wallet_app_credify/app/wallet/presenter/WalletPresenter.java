package one.credify.wallet_app_credify.app.wallet.presenter;

import android.util.Log;

import java.util.List;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.wallet.WalletContract;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.FetchWallet;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.usecase.base.UseCaseHandler;

public class WalletPresenter implements WalletContract.TransactionWalletPresenter {
    private WalletContract.WalletView mWalletView;
    private List<Coin> mCoins;

    public WalletPresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mWalletView = (WalletContract.WalletView) baseView;
    }

    @Override
    public void fetchWallets() {
        UseCaseHandler.getInstance().execute(new FetchWallet(),
                new FetchWallet.RequestValues(12345, 99999),
                new UseCase.UseCaseCallback<FetchWallet.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchWallet.ResponseValue response) {
                        mCoins = response.getCoins();
                        mWalletView.showWallets(mCoins);
                    }

                    @Override
                    public void onFailure(String message) {
                        Log.d(WalletPresenter.class.getSimpleName(), "error fetching from API");
                    }
                });
    }

    @Override
    public void handleWalletClick(int index) {
        if (mCoins != null) {
            mWalletView.startHistoryActivity(mCoins.get(index));
        }
    }
}
