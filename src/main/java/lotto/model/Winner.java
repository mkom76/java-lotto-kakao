package lotto.model;

import java.util.*;

public class Winner {
    public Map<Ranking, Integer> rankingCount(List<Ranking> rankings) {
        Map<Ranking, Integer> rankingResult = new EnumMap<>(Ranking.class);
        for( Ranking rank : Ranking.values()){
            rankingResult.put(rank, 0);
        }
        for (Ranking ranking : rankings){
            rankingResult.put(ranking, rankingResult.get(ranking) + 1);
        }
        return Collections.unmodifiableMap(rankingResult);
    }

    public double revenue(Map<Ranking, Integer> rankingResult, int money) {
        double prizeSum = 0;
        for (Ranking rank : rankingResult.keySet()){
            prizeSum += rank.getPrize() * rankingResult.get(rank);
        }
        return Math.round((prizeSum / money)*100) / 100.0;
    }
}
