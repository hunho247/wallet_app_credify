package one.credify.wallet_app_credify;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.FetchWallet;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FetchWalletUsecaseUnitTest {
    @Test
    public void test_fetchWallet_isSuccess() throws Exception {
        CompletableFuture<List<Coin>> future = new CompletableFuture<>();
        UseCase ucFetchWallet = new FetchWallet();

        ucFetchWallet.setRequestValues(new FetchWallet.RequestValues(12345, 99999));
        ucFetchWallet.setUseCaseCallback(new UseCase.UseCaseCallback<FetchWallet.ResponseValue>() {
            @Override
            public void onSuccess(FetchWallet.ResponseValue response) {
                List<Coin> coins = response.getCoins();
                future.complete(coins);
            }

            @Override
            public void onFailure(String message) {
                future.complete(null);
            }
        });

        ucFetchWallet.run();

        assertNotNull(future.get());
    }
}
