package one.credify.wallet_app_credify.app.history;

import java.util.List;

import one.credify.wallet_app_credify.app.base.BasePresenter;
import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.core.model.History;

public interface HistoryContract {
    interface HistoryView extends BaseView<HistoryContract.TransactionHistoryPresenter> {
        void showHistories(List<History> histories);
    }

    interface TransactionHistoryPresenter extends BasePresenter {
        void fetchHistories();
    }
}
