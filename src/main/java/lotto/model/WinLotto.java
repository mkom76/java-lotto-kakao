package lotto.model;

import java.util.Collections;

/**
 * 사용자가 입력한 로또 당첨번호 정보를 담는 클래스입니다.
 * 당첨 로또번호를 담은 WinLotto 객체와 보너스숫자를 담은 BonusNumber 객체를 가집니다.
 */
public class WinLotto {

    private final Lotto winLotto;
    private final BonusNumber bonusNumber;

    public WinLotto(Lotto lotto, BonusNumber bonusNumber) {
        checkDuplicate(lotto, bonusNumber);
        this.winLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getLotto().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("보너스 숫자는 로또 숫자와 겹칠 수 없습니다.");
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
