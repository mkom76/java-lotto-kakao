package lotto.view;

public class InputView {
    public int receiveMoneyUserInput(String input) {
        int money = isNumeric(input);
        isThousandUnit(money);
        return money;
    }

    private int isNumeric(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException("구매 금액은 숫자로 입력해야 합니다.");
        }
        return money;
    }

    private void isThousandUnit(int money) {
        if (money % 1000 != 0){
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
