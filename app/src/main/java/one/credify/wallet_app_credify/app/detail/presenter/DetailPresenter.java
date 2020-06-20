package one.credify.wallet_app_credify.app.detail.presenter;

import one.credify.wallet_app_credify.app.base.BaseView;
import one.credify.wallet_app_credify.app.detail.DetailContract;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.FetchHistory;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.usecase.base.UseCaseHandler;

public class DetailPresenter implements DetailContract.TransactionDetailPresenter {
    private DetailContract.DetailView mDetailView;
    private Coin mCoin;

    public DetailPresenter(BaseView baseView) {
        attachView(baseView);
    }

    @Override
    public void attachView(BaseView baseView) {
        mDetailView = (DetailContract.DetailView) baseView;
    }

    @Override
    public void fetchHistories() {
        UseCaseHandler.getInstance().execute(new FetchHistory(),
                new FetchHistory.RequestValues(12345, 99999),
                new UseCase.UseCaseCallback<FetchHistory.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchHistory.ResponseValue response) {
                        mDetailView.showHistories(response.getHistories());
                    }

                    @Override
                    public void onFailure(String message) {
                        mDetailView.showFailureDialog(message);
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
}
