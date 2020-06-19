package one.credify.wallet_app_credify.core.usecase;

import java.util.List;

import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.repository.Repository;
import one.credify.wallet_app_credify.core.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchWallet extends UseCase<FetchWallet.RequestValues,
        FetchWallet.ResponseValue> {

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        Repository.getServiceClass().getCoins().enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
                if (response.isSuccessful()) {
                    List<Coin> postList = response.body();
                    getUseCaseCallback().onSuccess(new ResponseValue(postList));
                }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                //showErrorMessage();
                getUseCaseCallback().onFailure(Constants.ERROR_FETCHING_COINS);
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private final long clientId;

        public RequestValues(long clientId) {
            this.clientId = clientId;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {

        private final List<Coin> coins;

        public ResponseValue(List<Coin> coins) {
            this.coins = coins;
        }

        public List<Coin> getCoins() {
            return coins;
        }
    }
}
