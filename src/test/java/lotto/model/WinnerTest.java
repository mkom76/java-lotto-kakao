package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {
    @Test
    void checkRankingCount() {
        Winner winner = new Winner();
        Ranking Rank1 = Ranking.FIRST;
        Ranking Rank2 = Ranking.THIRD;
        Ranking Rank3 = Ranking.DEFAULT;
        List<Ranking> input = Arrays.asList(Rank1, Rank2, Rank3);

        Map<Ranking, Integer> rankingResult  = new EnumMap<>(Ranking.class) {{
            put(Ranking.FIRST, 1);
            put(Ranking.SECOND, 0);
            put(Ranking.THIRD, 1);
            put(Ranking.FOURTH, 0);
            put(Ranking.FIFTH, 0);
            put(Ranking.DEFAULT, 1);
        }};

        Assertions.assertEquals(winner.rankingCount(input), rankingResult);
    }

    @Test
    void calRevenue(){
        Winner winner = new Winner();

        int money = 3000;
        Map<Ranking, Integer> rankingResult  = new EnumMap<>(Ranking.class) {{
            put(Ranking.FIRST, 1);
            put(Ranking.SECOND, 0);
            put(Ranking.THIRD, 1);
            put(Ranking.FOURTH, 0);
            put(Ranking.FIFTH, 0);
            put(Ranking.DEFAULT, 1);
        }};


        Assertions.assertEquals(winner.revenue(rankingResult, money), 667166.67);
    }
}