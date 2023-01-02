package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Winner {
    public Map<String, Integer> rankingCount(List<Ranking> rankings) {
        Map<String, Integer> rankingResult = new HashMap<>();
        for( Ranking rank : Ranking.values()){
            rankingResult.put(rank.name(), 0);
        }
        for (Ranking ranking : rankings){
            rankingResult.put(ranking.name(), rankingResult.get(ranking.name()) + 1);
        }
        return Collections.unmodifiableMap(rankingResult);
    }
}
