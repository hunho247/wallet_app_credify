package one.credify.wallet_app_credify.core.services;

import java.util.List;

import one.credify.wallet_app_credify.core.model.Coin;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WalletService {
    @GET("da42f783-8086-4d6c-8e85-177f508aab98")
    public Call<List<Coin>> getCoins(/* long clientId, long token */);
}
