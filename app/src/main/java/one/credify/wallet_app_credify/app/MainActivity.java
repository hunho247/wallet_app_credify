package one.credify.wallet_app_credify.app;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.wallet.ui.WalletActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = new Intent(MainActivity.this, WalletActivity.class);
        startActivity(intent);
    }
}