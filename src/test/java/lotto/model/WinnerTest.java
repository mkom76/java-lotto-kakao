package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    @Test
    void checkRankingCount() {
        Winner winner = new Winner();
        Ranking Rank1 = Ranking.FIRST;
        Ranking Rank2 = Ranking.THIRD;
        Ranking Rank3 = Ranking.DEFAULT;
        List<Ranking> input = Arrays.asList(Rank1, Rank2, Rank3);

        Map<String, Integer> rankingResult  = new HashMap<>() {{
            put("FIRST", 1);
            put("SECOND", 0);
            put("THIRD", 1);
            put("FOURTH", 0);
            put("FIFTH", 0);
            put("DEFAULT", 1);
        }};

        Assertions.assertEquals(winner.rankingCount(input), rankingResult);
    }
}