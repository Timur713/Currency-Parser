package currency_parser.parsers;

import java.io.IOException;
import java.util.ArrayList;

public class DollarParser extends Parser {
    private Float dollarCurrency = 0.0f;
    private String url = "https://www.google.com/search?ei=ubp5XreXJaWorgTjk4n4Bg&q=%D0%BA%D1%83%D1%80%D1%81+%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%B0&oq=kurs+&gs_l=psy-ab.3.1.0i10i67i42j0i10j0i131j0i10j0i131i67j0i131j0i10l4.39887.39887..41027...0.2..0.129.129.0j1......0....1..gws-wiz.......0i71.0x8EQIm8JD8";

    private Float difference = 0.0f;

    @Override
    protected ArrayList<Float> getUpdateData(String url, Float dollarCurrency, Float difference) throws IOException {
        return super.getUpdateData(url, dollarCurrency, difference);
    }

    public void updateData() throws IOException {
        ArrayList<Float> outputDataList = getUpdateData(url, dollarCurrency, difference);

        dollarCurrency = outputDataList.get(0);
        difference = outputDataList.get(1);
    }

    @Override
    public Float getDifference() {
        return difference;
    }
    @Override
    public Float getCurrency() throws IOException {

        updateData();
        return dollarCurrency;
    }
}
