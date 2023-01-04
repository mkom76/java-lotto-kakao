package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RankingResultTest {
    @Test
    void checkRankingResultMaker() {
        Ranking Rank1 = Ranking.FIRST;
        Ranking Rank2 = Ranking.THIRD;
        Ranking Rank3 = Ranking.DEFAULT;
        List<Ranking> rankingResultList = Arrays.asList(Rank1, Rank2, Rank3);
        RankingResult rankingResult = new RankingResult(rankingResultList);

        Map<Ranking, Integer> rankingResultMap = new EnumMap<>(Ranking.class) {{
            put(Ranking.FIRST, 1);
            put(Ranking.SECOND, 0);
            put(Ranking.THIRD, 1);
            put(Ranking.FOURTH, 0);
            put(Ranking.FIFTH, 0);
            put(Ranking.DEFAULT, 1);
        }};

        Assertions.assertEquals(rankingResult.getRankingResult(), rankingResultMap);
    }
}
