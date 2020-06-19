package one.credify.wallet_app_credify.app.wallet;

import java.util.List;

import one.credify.wallet_app_credify.app.base.BasePresenter;
import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.core.model.Coin;

public interface WalletContract {
    interface WalletView extends BaseView<TransactionWalletPresenter> {
        void showWallets(List<Coin> coins);
    }

    interface TransactionWalletPresenter extends BasePresenter {
        void fetchWallets();
    }
}
