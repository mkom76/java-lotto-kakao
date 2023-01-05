package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 결과 해시맵을 감싸는 일급컬렉입니다.
 * Ranking(enum)이 key로, 각 랭크에 해당하는 로또의 개수가 value로 구성됩니다.
 */
public class RankingResult {

    private final Map<Ranking, Integer> rankingResult;

    public RankingResult() {
        rankingResult = new EnumMap<>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            rankingResult.put(rank, 0);
        }
    }

    public RankingResult(List<Ranking> rankingResultList) {
        this();
        for (Ranking rank : rankingResultList) {
            rankingResult.put(rank, rankingResult.get(rank) + 1);
        }
    }

    public Map<Ranking, Integer> getRankingResult() {
        Map<Ranking, Integer> rankingResultReadOnly = new EnumMap<>(rankingResult);
        return Collections.unmodifiableMap(rankingResultReadOnly);
    }

    public double calculateRevenue(int money) {
        double prizeSum = 0;
        for (Ranking rank : rankingResult.keySet()) {
            prizeSum += rank.getPrize() * rankingResult.get(rank);
        }
        return Math.round((prizeSum / money) * 100) / 100.0;
    }
}
