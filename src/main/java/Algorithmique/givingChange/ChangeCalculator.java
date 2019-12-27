package Algorithmique.givingChange;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ChangeCalculator	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/12/2019 12:59
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class ChangeCalculator {
    private static final int[] coinTypes = new int[]{1, 2, 5, 10, 20, 50};

    private CoupleValue[] coinsToGive = new CoupleValue[coinTypes.length];

    public CoupleValue[] giveChange(int changeToGive) {
        calculateChange(changeToGive);

        return coinsToGive;
    }

    private void calculateChange(int changeToGive) {
        if (changeToGive <= 0) return;

        int length = coinTypes.length;

        for (int i = length - 1; i >= 0; i--) {
            int tmpChange = changeToGive / coinTypes[i];

            if (tmpChange >= 1) {
                coinsToGive[i] = new CoupleValue(coinTypes[i], tmpChange);
                changeToGive -= coinTypes[i] * tmpChange;
            }
        }

        calculateChange(changeToGive);
    }

    public static class CoupleValue {
        int value;
        int amount;

        CoupleValue(int value, int amount) {
            this.value = value;
            this.amount = amount;
        }
    }
}
