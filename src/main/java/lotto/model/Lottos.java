package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<Lotto> lottos = new ArrayList<>();

    public Lottos(int input) {
        addRandom(input);
    }

    private void addRandom(int input) {
        for (int i = 0; i < input; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
