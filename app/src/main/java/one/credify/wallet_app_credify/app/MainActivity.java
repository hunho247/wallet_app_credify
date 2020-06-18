package one.credify.wallet_app_credify.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.core.base.UseCase;
import one.credify.wallet_app_credify.core.base.UseCaseHandler;
import one.credify.wallet_app_credify.core.model.Wallet;
import one.credify.wallet_app_credify.core.usecase.FetchWallet;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mUseCaseHandler = UseCaseHandler.getInstance();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_id);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        UseCaseHandler.getInstance().execute(new FetchWallet(),
                new FetchWallet.RequestValues(12345),
                new UseCase.UseCaseCallback<FetchWallet.ResponseValue>() {
                    @Override
                    public void onSuccess(FetchWallet.ResponseValue response) {
                        List<Wallet> wallets = response.getWallets();
                        NewAdapter adapter = new NewAdapter(getApplicationContext(), wallets);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onError(String message) {
                        Log.d(TAG, "error loading from API");
                    }
                });
    }
}