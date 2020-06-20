package one.credify.wallet_app_credify.app.detail;

import java.util.List;

import one.credify.wallet_app_credify.app.base.BasePresenter;
import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.model.History;

public interface DetailContract {
    interface DetailView extends BaseView<DetailContract.TransactionDetailPresenter> {
        void showHistories(List<History> histories);
    }

    interface TransactionDetailPresenter extends BasePresenter {
        void fetchHistories();

        void setCoinData(Coin coin);

        Coin getCoinData();
    }
}
