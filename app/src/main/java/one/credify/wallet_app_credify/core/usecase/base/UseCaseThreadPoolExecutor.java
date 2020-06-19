package one.credify.wallet_app_credify.core.usecase.base;

import android.os.Handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseCaseThreadPoolExecutor implements UseCaseScheduler {
    public static final int POOL_SIZE = 2;
    public static final int MAX_POOL_SIZE = 40;
    public static final int TIMEOUT = 60;
    private final Handler mHandler = new Handler();
    ThreadPoolExecutor mThreadPoolExecutor;

    public UseCaseThreadPoolExecutor() {
        mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT,
                TimeUnit.SECONDS, new ArrayBlockingQueue(MAX_POOL_SIZE));
    }

    @Override
    public void execute(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    @Override
    public <V extends UseCase.ResponseValue> void notifyResponse(final V response,
            final UseCase.UseCaseCallback<V>
                    useCaseCallback) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onSuccess(response);
            }
        });
    }

    @Override
    public <V extends UseCase.ResponseValue> void onError(final String message,
            final UseCase.UseCaseCallback<V> useCaseCallback) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                useCaseCallback.onFailure(message);
            }
        });
    }
}
