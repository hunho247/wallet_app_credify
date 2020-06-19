package one.credify.wallet_app_credify.core.usecase;

import java.util.List;

import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.model.Wallet;
import one.credify.wallet_app_credify.core.repository.Repository;
import one.credify.wallet_app_credify.core.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchWallet extends UseCase<FetchWallet.RequestValues,
        FetchWallet.ResponseValue> {

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        Repository.getServiceClass().getAllPost().enqueue(new Callback<List<Wallet>>() {
            @Override
            public void onResponse(Call<List<Wallet>> call, Response<List<Wallet>> response) {
                if (response.isSuccessful()) {
                    List<Wallet> postList = response.body();
//                    NewAdapter adapter = new NewAdapter(getApplicationContext(), postList);
//                    recyclerView.setAdapter(adapter);
                    getUseCaseCallback().onSuccess(new ResponseValue(postList));
                }
            }

            @Override
            public void onFailure(Call<List<Wallet>> call, Throwable t) {
                //showErrorMessage();
                getUseCaseCallback().onFailure(Constants.ERROR_FETCHING_WALLET);
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

        private final List<Wallet> wallets;

        public ResponseValue(List<Wallet> wallets) {
            this.wallets = wallets;
        }

        public List<Wallet> getWallets() {
            return wallets;
        }
    }
}
