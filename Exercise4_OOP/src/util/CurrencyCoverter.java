package util;

public class CurrencyCoverter {

    public static double iof = 1.06;
    public static double reaisPrice(double dollarPrice, double dollarsBought) {
        return dollarPrice * dollarsBought * iof;
    }

}
