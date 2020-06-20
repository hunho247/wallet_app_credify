package one.credify.wallet_app_credify.core.services;

import java.util.List;

import one.credify.wallet_app_credify.core.model.Coin;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WalletService {
    @GET("afcc67e5-e740-4036-828b-1919185f1ffd")
    public Call<List<Coin>> getCoins(/* long clientId, long token */);
}
