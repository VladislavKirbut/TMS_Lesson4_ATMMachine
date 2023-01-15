public class ATMMachine {
    private final int FIFTY = 50;
    private final int TWENTY = 20;
    private final int HUNDRED = 100;

    // количество купюр каждого из номиналов
    private int countFifty;
    private int countTwenty;
    private int countHundred;

    // Вся сумма в банкомате
    private int allSum;

    public ATMMachine(int countFifty, int countTwenty, int countHundred) {
        this.countFifty = countFifty;
        this.countTwenty = countTwenty;
        this.countHundred = countHundred;
        this.allSum = countFifty * FIFTY + countTwenty * TWENTY + countHundred * HUNDRED;
    }

    // можно реализовать с перегрузкой метода
    public void increaseCount(int countFifty, int countTwenty, int countHundred) {
        if(countFifty >= 0 && countTwenty >= 0 && countHundred >= 0) {
            this.countFifty += countFifty;
            this.countTwenty += countTwenty;
            this.countHundred += countHundred;
            this.allSum = this.countFifty * FIFTY + this.countTwenty * TWENTY + this.countHundred * HUNDRED;
            System.out.println("Increase is successful!");
        } else
            System.out.println("Enter correct count!!!");
    }

    public boolean withdrawAmount(int amount) {
        if(amount > 0) {
            if(amount < allSum) {
                int hundCount = amount / 100;
                int fifCount = (amount - hundCount * 100) / 50;
                int twentyCount = (amount - hundCount * 100 - fifCount * 50) / 20;

                if((amount - hundCount * 100 - fifCount * 50) % 20 == 0) {
                    System.out.println("Count 100: " + hundCount + "\nCount 50: " + fifCount + "\nCount 20: " + twentyCount);
                    return true;
                } else {
                    System.out.println("ATM doesn't have this monetary denomination. Enter amount more or less.");
                    return false;
                }
            } else {
                System.out.println("ATM doesn't have enough money!! Enter amount less.");
                return false;
            }
        } else {
            System.out.println("Enter correct amount.");
            return false;
        }
    }
}

class TestATMMachine {
    public static void main(String[] args) {
        ATMMachine atm = new ATMMachine(20,20,20);
        boolean bool = atm.withdrawAmount(280);
        System.out.println(bool);
    }
}
