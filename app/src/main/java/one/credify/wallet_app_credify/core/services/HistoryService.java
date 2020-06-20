package one.credify.wallet_app_credify.core.services;

import java.util.List;

import one.credify.wallet_app_credify.core.model.History;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HistoryService {
    @GET("8b979ea2-b2d5-487e-91ef-7a88e00a18a8")
    public Call<List<History>> getHistories(/* long clientId, long token, long coinId */);
}
