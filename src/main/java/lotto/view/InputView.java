package lotto.view;

import lotto.constant.Constants;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User Input을 받는 클래스입니다.
 * 각 사용자 입력에 대한 validation check도 진행합니다.
 */
public class InputView {
    Scanner scanner;

    public int receiveMoneyUserInput() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = stringToInteger(getNotNullOrEmptyUserInput());
        checkUnderPriceOfLotto(money);
        return money;
    }

    private String getNotNullOrEmptyUserInput() {
        String input = scanner.nextLine();
        checkNullOrEmpty(input);
        return input;
    }

    private void checkNullOrEmpty(String input) {
        if(Objects.isNull(input) || input.isEmpty()){
            throw new IllegalArgumentException("null값을 입력하지 마세요.");
        }
    }

    private int stringToInteger(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        return number;
    }

    private void checkUnderPriceOfLotto(int money) {
        if (money < Constants.PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("1장에 1000원이므로 1000원 이상을 입력해주세요.");
        }
    }

    public List<Integer> receiveWinLottoNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lottoNumbers = stringToIntgerList(getNotNullOrEmptyUserInput());
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
        checkLottoNumbersInRange(lottoNumbers);

        return lottoNumbers;
    }

    private List<Integer> stringToIntgerList(String input) {
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(removeSpaceAndSplit(input))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }
        return numbers;
    }

    private String[] removeSpaceAndSplit(String input) {
        return input.replaceAll(Constants.SPACES, Constants.EMPTY_STRING).split(Constants.COMMA);

    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개를 입력해야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> splitedInputSet = new HashSet<>(lottoNumbers);
        if (splitedInputSet.size() < lottoNumbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복 입력 해서는 안됩니다.");
        }
    }

    private void checkInRange(int number) {
        if (number < Constants.LOTTO_MIN_NUM || number > Constants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이입니다.");
        }
    }

    private void checkLottoNumbersInRange(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            checkInRange(lottoNumber);
        }
    }

    public int receiveWinBonusNumber(List<Integer> lottoNumbers) {
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = stringToInteger(getNotNullOrEmptyUserInput());
        System.out.println();
        checkInRange(bonusNumber);
        checkDuplicateLottoNumberWithBonusNumber(lottoNumbers, bonusNumber);
        return bonusNumber;
    }

    private void checkDuplicateLottoNumberWithBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호와 중복되면 안됩니다.");
        }
    }
}
