package one.credify.wallet_app_credify.app.base;

public interface BaseActivityCallback {
    void showAlertDialog(String title, String message);

    void showBackButton();

    void hideBackButton();

    void showCloseButton();

    void hideCloseButton();

    void setToolbarTitle(String title);
}