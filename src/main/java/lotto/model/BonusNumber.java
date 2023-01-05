package lotto.model;

import lotto.constant.Constants;

/**
 * 보너스넘버를 감싸는 일급컬렉션입니다.
 */
public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        checkRangeOfBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < Constants.LOTTO_MIN_NUM || bonusNumber > Constants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("보너스 볼의 범위는 1~45입니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
