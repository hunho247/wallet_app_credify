package one.credify.wallet_app_credify.app.base;

public interface BaseActivityCallback {
    void showProgressDialog(String message);

    void hideProgressDialog();

    void cancelProgressDialog();

    void setToolbarTitle(String title);
}