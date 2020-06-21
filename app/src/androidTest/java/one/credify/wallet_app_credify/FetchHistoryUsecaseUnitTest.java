package one.credify.wallet_app_credify;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import one.credify.wallet_app_credify.core.model.History;
import one.credify.wallet_app_credify.core.usecase.FetchHistory;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class FetchHistoryUsecaseUnitTest {
    @Test
    public void test_fetchHistory_isSuccess() throws ExecutionException, InterruptedException {
        CompletableFuture<List<History>> future = new CompletableFuture<>();
        UseCase ucFetchHistory = new FetchHistory();

        ucFetchHistory.setRequestValues(new FetchHistory.RequestValues(12345, 99999));
        ucFetchHistory.setUseCaseCallback(new UseCase.UseCaseCallback<FetchHistory.ResponseValue>() {
            @Override
            public void onSuccess(FetchHistory.ResponseValue response) {
                List<History> histories = response.getHistories();
                future.complete(histories);
            }

            @Override
            public void onFailure(String message) {
                future.complete(null);
            }
        });

        ucFetchHistory.run();

        assertNotNull(future.get());
    }
}
