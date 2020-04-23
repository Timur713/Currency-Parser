package currency_parser.parsers;

import java.io.IOException;
import java.util.ArrayList;

public class EuroParser extends Parser {
    private Float euroCurrency = 0.0f;
    private String url = "https://www.google.com/search?ei=e8V5XqmaDOqErwTl9oPQCw&q=%D0%BA%D1%83%D1%80%D1%81+evro&oq=%D0%BA%D1%83%D1%80%D1%81+evro&gs_l=psy-ab.3..0i10i42j0i10l9.14597.17251..17688...0.2..0.123.1269.0j11......0....1..gws-wiz.......0i71j0i131i67j0i131j0j0i22i30j0i22i10i30.wPP06NlWlDE&ved=0ahUKEwjpw8ys2bLoAhVqwosKHWX7ALoQ4dUDCAs&uact=5";

    private Float difference = 0.0f;

    @Override
    protected ArrayList<Float> getUpdateData(String url, Float euroCurrency, Float difference) throws IOException {
        return super.getUpdateData(url, euroCurrency, difference);
    }

    @Override
    public void updateData() throws IOException {
        ArrayList<Float> outputDataList = getUpdateData(url, euroCurrency, difference);

        euroCurrency = outputDataList.get(0);
        difference = outputDataList.get(1);
    }

    @Override
    public Float getDifference() {
        return difference;
    }
    @Override
    public Float getCurrency() throws IOException {
        updateData();
        return euroCurrency;
    }
}
