package lotto.model;

public class WinLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinLotto(Lotto lotto, BonusNumber bonusNumber) {
        checkDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicate(Lotto lotto, BonusNumber bonusNumber) {
        if(lotto.getLotto().contains(bonusNumber.getBonusNumber())){
            throw new IllegalArgumentException("보너스 숫자는 로또 숫자와 겹칠 수 없습니다.");
        }
    }

    public Lotto getLotto(){

    }
}
