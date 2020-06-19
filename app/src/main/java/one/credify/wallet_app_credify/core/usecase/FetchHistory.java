package one.credify.wallet_app_credify.core.usecase;

import java.util.List;

import one.credify.wallet_app_credify.core.model.History;
import one.credify.wallet_app_credify.core.repository.Repository;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchHistory extends UseCase<FetchHistory.RequestValues,
        FetchHistory.ResponseValue> {
    @Override
    protected void executeUseCase(FetchHistory.RequestValues requestValues) {

        Repository.getHistoryService().getHistories().enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                if (response.isSuccessful()) {
                    List<History> postList = response.body();
                    getUseCaseCallback().onSuccess(new FetchHistory.ResponseValue(postList));
                }
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                getUseCaseCallback().onFailure(Constants.ERROR_FETCHING);
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final long clientId;
        private final long token;

        public RequestValues(long clientId, long token) {
            this.clientId = clientId;
            this.token = token;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final List<History> histories;

        public ResponseValue(List<History> histories) {
            this.histories = histories;
        }

        public List<History> getHistorys() {
            return histories;
        }
    }
}
