package one.credify.wallet_app_credify.app.history.presenter;

import android.util.Log;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.history.HistoryContract;
import one.credify.wallet_app_credify.core.usecase.FetchHistory;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.usecase.base.UseCaseHandler;

public class HistoryPresenter implements HistoryContract.TransactionHistoryPresenter {
    private HistoryContract.HistoryView mHistoryView;

    public HistoryPresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mHistoryView = (HistoryContract.HistoryView) baseView;
    }

    @Override
    public void fetchHistories() {
        UseCaseHandler.getInstance().execute(new FetchHistory(),
                new FetchHistory.RequestValues(12345, 99999),
                new UseCase.UseCaseCallback<FetchHistory.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchHistory.ResponseValue response) {
                        mHistoryView.showHistories(response.getHistorys());
                    }

                    @Override
                    public void onFailure(String message) {
                        Log.d(HistoryPresenter.class.getSimpleName(), "error fetching from API");
                    }
                });
    }
}
