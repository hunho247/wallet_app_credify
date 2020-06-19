package one.credify.wallet_app_credify.app.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
