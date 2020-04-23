package currency_parser.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {
    protected ArrayList<Float> getUpdateData(String url, Float currency, Float difference) throws IOException {

        Document doc = Jsoup.connect(url).get();

        Elements CurrEls = doc.getElementsByAttributeValue("class", "DFlfde SwHCTb");

        Element currEl = CurrEls.first();

        ArrayList<Float> outputDataList = new ArrayList<Float>(2);

        Float newCurrency = Float.parseFloat(findDollarMatches(currEl.toString()));
        if (currency == 0.0) {
            difference = 0.0f;
        } else {
            difference = newCurrency - currency;
        }
        outputDataList.add(newCurrency);
        outputDataList.add(difference);
        return outputDataList;
    }

    private String findDollarMatches(String match) {
        String dataValue = "";

        Pattern pattern = Pattern.compile("data-value=\".+\"");
        Matcher matcher = pattern.matcher(match);
        if (matcher.find()) {
            dataValue = matcher.group();

            pattern = Pattern.compile("\\d+.\\d+");
            matcher = pattern.matcher(dataValue);

            if (matcher.find()) {
                return matcher.group();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public abstract void updateData() throws IOException;

    public abstract Float getDifference();
    public abstract Float getCurrency() throws IOException;
}
