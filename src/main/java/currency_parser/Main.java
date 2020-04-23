package currency_parser;

import currency_parser.mail.MailSender;
import currency_parser.parsers.DollarParser;
import currency_parser.parsers.EuroParser;
import currency_parser.parsers.Parser;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, MessagingException {
//        Parser euroParser = new EuroParser();
//        Parser dollarParser = new DollarParser();
        while (true) {
            MailSender.sendMail("timur.isanbirdin@gmail.com");
        }

//        while (true) {
//
//            System.out.println("Dollar currency: " + dollarParser.getCurrency() + "     +" + dollarParser.getDifference());
//
//            System.out.println("Euro currency: " + euroParser.getCurrency() + "     +" + euroParser.getDifference());
//
//            Thread.sleep(5000);
//        }
    }
}
