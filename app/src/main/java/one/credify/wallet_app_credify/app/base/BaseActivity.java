package one.credify.wallet_app_credify.app.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import one.credify.wallet_app_credify.R;

public class BaseActivity extends AppCompatActivity implements BaseActivityCallback {
    public ProgressDialog progressDialog;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);
        getSupportActionBar().setElevation(0);
    }

    @Override
    public void showProgressDialog(String message) {
        if (progressDialog != null) {
            progressDialog.setMessage(message);
            progressDialog.show();
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setMessage(message);
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

    @Override
    public void cancelProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void setToolbarTitle(String title) {
        TextView textView = getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title);
        if (textView != null) {
            textView.setText(title);
        }
    }
}
