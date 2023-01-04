package lotto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankingResult {

    private final Map<Ranking, Integer> rankingResult;

    public RankingResult(){
        rankingResult = new EnumMap<>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            rankingResult.put(rank, 0);
        }
    }

    public RankingResult(List<Ranking> rankingResultList) {
        this();
        for(Ranking rank : rankingResultList){
            rankingResult.put(rank, rankingResult.get(rank) + 1);
        }
    }

    public Map<Ranking, Integer> getRankingResult() {
        Map<Ranking, Integer> rankingResultReadOnly = new EnumMap<>(rankingResult);
        return Collections.unmodifiableMap(rankingResultReadOnly);
    }
}
