package one.credify.wallet_app_credify.core.repository;

import one.credify.wallet_app_credify.core.services.HistoryService;
import one.credify.wallet_app_credify.core.services.WalletService;

public class Repository {
    private static final String BASE_URL = "https://run.mocky.io/v3/";

    public static WalletService getWalletService(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(WalletService.class);
    }

    public static HistoryService getHistoryService(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(HistoryService.class);
    }
}
