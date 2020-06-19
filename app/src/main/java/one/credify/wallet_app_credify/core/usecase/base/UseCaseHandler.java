package one.credify.wallet_app_credify.core.usecase.base;

public class UseCaseHandler {
    private static UseCaseHandler instance;

    private final UseCaseScheduler mUseCaseScheduler;

    public UseCaseHandler(UseCaseScheduler useCaseScheduler) {
        mUseCaseScheduler = useCaseScheduler;
    }

    public static UseCaseHandler getInstance() {
        if (instance == null) {
            instance = new UseCaseHandler(new UseCaseThreadPoolExecutor());
        }
        return instance;
    }

    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
            final UseCase<T, R> useCase, T values, UseCase.UseCaseCallback<R> callback) {
        useCase.setRequestValues(values);
        useCase.setUseCaseCallback(new UiCallbackWrapper(callback, mUseCaseScheduler));

        mUseCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    private static final class UiCallbackWrapper<V extends UseCase.ResponseValue> implements
            UseCase.UseCaseCallback<V> {
        private final UseCase.UseCaseCallback<V> mCallback;
        private final UseCaseScheduler mUseCaseScheduler;

        public UiCallbackWrapper(UseCase.UseCaseCallback<V> callback,
                                 UseCaseScheduler useCaseScheduler) {
            mCallback = callback;
            mUseCaseScheduler = useCaseScheduler;
        }

        @Override
        public void onSuccess(V response) {
            mUseCaseScheduler.notifyResponse(response, mCallback);
        }

        @Override
        public void onFailure(String message) {
            mUseCaseScheduler.onError(message, mCallback);
        }
    }
}
