package one.credify.wallet_app_credify.app.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.OnClick;
import one.credify.wallet_app_credify.R;

public class BaseActivity extends AppCompatActivity implements BaseActivityCallback {
    public ProgressDialog progressDialog;

    @BindView(R.id.ib_back)
    ImageButton ibBack;
    @BindView(R.id.ib_close)
    ImageButton ibCLose;

    @OnClick(R.id.ib_back)
    public void ibBackOnClick() {
        super.onBackPressed();
    }

    @OnClick(R.id.ib_close)
    public void ibCloseOnClick() {
        super.onBackPressed();
    }

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
    public void showBackButton() {
        ibBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBackButton() {
        ibBack.setVisibility(View.GONE);
    }

    @Override
    public void showCloseButton() {

    }

    @Override
    public void hideCloseButton() {

    }

    @Override
    public void setToolbarTitle(String title) {
        TextView textView = getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title);
        if (textView != null) {
            textView.setText(title);
        }
    }
}
