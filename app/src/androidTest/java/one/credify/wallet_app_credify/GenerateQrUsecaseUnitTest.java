package one.credify.wallet_app_credify;

import android.graphics.Bitmap;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import one.credify.wallet_app_credify.core.usecase.GenerateQr;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GenerateQrUsecaseUnitTest {
    @Test
    public void test_generateQr_isSuccess() throws ExecutionException, InterruptedException {
        CompletableFuture<Bitmap> future = new CompletableFuture<>();
        UseCase ucGenerateQr = new GenerateQr();

        ucGenerateQr.setRequestValues(new GenerateQr.RequestValues("7117251d12dd28c5e02f5bd90ef813fd2e4e7c7b42563790ea459d5e6a62761c"));
        ucGenerateQr.setUseCaseCallback(new UseCase.UseCaseCallback<GenerateQr.ResponseValue>() {
            @Override
            public void onSuccess(GenerateQr.ResponseValue response) {
                Bitmap bitmap = response.getBitmap();
                future.complete(bitmap);
            }

            @Override
            public void onFailure(String message) {
                future.complete(null);
            }
        });

        ucGenerateQr.run();

        assertNotNull(future.get());
    }
}