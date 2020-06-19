package one.credify.wallet_app_credify.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import one.credify.wallet_app_credify.R;
import one.credify.wallet_app_credify.app.base.BaseActivity;
import one.credify.wallet_app_credify.app.history.ui.HistoryActivity;
import one.credify.wallet_app_credify.app.wallet.ui.WalletActivity;


public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.buttonid)
    Button buttonid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}