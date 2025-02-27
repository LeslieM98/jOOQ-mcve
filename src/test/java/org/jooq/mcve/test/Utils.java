package org.jooq.mcve.test;

import me.leslie.generals.server.entity.interfaces.ITroop;
import me.leslie.generals.server.entity.pojos.Troop;
import org.jooq.lambda.Seq;

import java.util.List;
import java.util.stream.Collectors;
import me.leslie.generals.server.repository.*;

public class Utils {

    private Utils() {
    }

    static List<ITroop> initializeTroops(TroopRepository repository) {
        return Seq.of(new Troop(0, 100, 120, 120.2, 11.2, 12.0, 13.0, 6245.0, 1534.0, 1364.0, 121235.3, 125.3, 51.3),
                new Troop(0, 1, 1240, 15320.2, 13441.2, 1762.0, 13.0, 6245.0, 1538634.0, 1364.0, 12125635.3, 125.3,
                        5451.3),
                new Troop(0, 16700, 15620, 12820.2, 1561.2, 15672.0, 13.0, 686245.0, 1534.0, 1364.0, 12121735.3,
                        12705.3, 5184.3),
                new Troop(0, 1030, 12840, 122450.2, 1164.2, 12.0, 163.0, 624575.0, 15364.0, 13674.0, 1211235.3, 125.3,
                        515.3),
                new Troop(0, 1010, 12560, 12620.2, 1751.2, 12.0, 13.0, 6245.0, 1751534.0, 1364.0, 12168235.3, 12557.3,
                        5186.3))
                .map(repository::create).collect(Collectors.toUnmodifiableList());
    }

}
