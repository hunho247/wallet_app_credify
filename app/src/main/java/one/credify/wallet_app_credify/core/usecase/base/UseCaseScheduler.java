package one.credify.wallet_app_credify.core.usecase.base;

public interface UseCaseScheduler {
    void execute(Runnable runnable);

    <V extends UseCase.ResponseValue> void notifyResponse(final V response,
                                                          final UseCase.UseCaseCallback<V>
                                                                  useCaseCallback);

    <V extends UseCase.ResponseValue> void onError(final String message,
                                                   final UseCase.UseCaseCallback<V>
                                                           useCaseCallback);
}
