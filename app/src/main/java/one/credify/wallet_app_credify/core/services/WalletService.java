package one.credify.wallet_app_credify.core.services;

import java.util.List;

import one.credify.wallet_app_credify.core.model.Wallet;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WalletService {
    @GET("v3/f4b2ac77-9845-4c30-b0b6-e977d72e1728")
    public Call<List<Wallet>> getAllPost();
}
