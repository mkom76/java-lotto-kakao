package lotto.model;

import java.util.Arrays;

/**
 * 각 로또 등수에 따른 정보들을 모아두었습니다.
 */
public enum Ranking {
    FIRST(2000000000, 6, false, "6개 일치 (2000000000원)"),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(1500000, 5, false, "5개 일치 (1500000원)"),
    FOURTH(50000, 4, false, "4개 일치 (50000원)"),
    FIFTH(5000, 3, false, "3개 일치 (5000원)"),
    DEFAULT(0, 0, false, "");

    private final int prize;
    private final int count;
    private final boolean hasBonusNumber;

    private final String resultLog;

    Ranking(int prize, int count, boolean hasBonusNumber, String resultLog) {
        this.prize = prize;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
        this.resultLog = resultLog;
    }

    public static Ranking findRanking(int cnt, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == cnt && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(DEFAULT);
    }

    public int getPrize() {
        return prize;
    }

    public String getResultLog(){
        return resultLog;
    }
}
