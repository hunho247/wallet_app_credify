package one.credify.wallet_app_credify.core.usecase;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import one.credify.wallet_app_credify.core.usecase.base.UseCase;
import one.credify.wallet_app_credify.core.utils.Constants;

public class GenerateQr extends UseCase<GenerateQr.RequestValues, GenerateQr.ResponseValue> {
    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    private static final int WIDTH = 500;

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        try {
            Bitmap bitmap = encodeAsBitmap(requestValues.data);

            if (bitmap != null) {
                getUseCaseCallback().onSuccess(new ResponseValue(bitmap));
            } else {
                getUseCaseCallback().onFailure(Constants.ERROR_OCCURRED);
            }
        } catch (WriterException e) {
            getUseCaseCallback().onFailure(Constants.FAILED_TO_WRITE_DATA_TO_QR);
        }
    }

    private Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, WIDTH, null);
        } catch (IllegalArgumentException iae) {
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, WIDTH, 0, 0, w, h);
        return bitmap;
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final String data;

        public RequestValues(String data) {
            this.data = data;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final Bitmap bitmap;

        public ResponseValue(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public Bitmap getBitmap() {
            return bitmap;
        }
    }
}
