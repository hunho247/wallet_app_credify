package one.credify.wallet_app_credify.core.usecase;

import one.credify.wallet_app_credify.core.model.Coin;
import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.utils.AESEncryption;
import one.credify.wallet_app_credify.core.utils.Constants;

public class ConnectCoinNetwork extends UseCase<ConnectCoinNetwork.RequestValues,
        ConnectCoinNetwork.ResponseValue> {
    @Override
    protected void executeUseCase(ConnectCoinNetwork.RequestValues requestValues) {
        Coin coin = requestValues.coin;
        String toAddress = requestValues.toAddress;
        String amount = requestValues.amount;

        String publicKey = coin.getPublicKey();
        String privateKey = AESEncryption.decrypt(publicKey, coin.getKeyAES());

        /**
         * The feature is not yet complete, the idea is to decrypt the private key that
         * is stored in the local device memory using AES, then use this key to make
         * transactions with the coin.
         */

        getUseCaseCallback().onFailure("The service is unavailable");
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final Coin coin;
        private final String toAddress;
        private final String amount;

        public RequestValues(Coin coin, String toAddress, String amount) {
            this.coin = coin;
            this.toAddress = toAddress;
            this.amount = amount;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        public ResponseValue() {
        }
    }
}