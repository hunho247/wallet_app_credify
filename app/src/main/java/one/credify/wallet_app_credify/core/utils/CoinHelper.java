package one.credify.wallet_app_credify.core.utils;

public class CoinHelper {
    public static String getCoinName(String coinUnit) {
        switch (coinUnit) {
            case "BTC":
                return "Bitcoin";
            case "ETH":
                return "Ethereum";
            default:
                return "Unknown";
        }
    }

    public static String getCoinSign(String coinUnit) {
        switch (coinUnit) {
            case "BTC":
                return "B";
            case "ETH":
                return "E";
            default:
                return "";
        }
    }

    public static Double getCoinPrice(String coinUnit, Double amount) {
        switch (coinUnit) {
            case "BTC":
                return amount * 9000;
            case "ETH":
                return amount * 200;
            default:
                return 0.0;
        }
    }
}
