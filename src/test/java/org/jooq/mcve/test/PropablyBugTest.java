package org.jooq.mcve.test;

import me.leslie.generals.server.entity.interfaces.IArmyComposition;
import me.leslie.generals.server.entity.interfaces.ITroop;
import me.leslie.generals.server.entity.pojos.ArmyComposition;
import me.leslie.generals.server.persistence.Database;
import me.leslie.generals.server.persistence.jooq.tables.daos.ArmyDao;
import me.leslie.generals.server.persistence.jooq.tables.daos.TroopDao;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import me.leslie.generals.server.repository.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * PropablyBugTest
 */
public class PropablyBugTest {

    private Database database;
    private TroopRepository troopRepository;
    private ArmyRepository armyRepository;

    @BeforeEach
    void setup() {
        try {
            database = Database.get();
            troopRepository = new TroopRepository(database);
            armyRepository = new ArmyRepository(database);
        } catch (Exception e) {
            fail(e);
        }
    }

    @AfterEach
    void cleanUp() {
        try {
            ArmyDao armyJooq = new ArmyDao(
                    new DefaultConfiguration().set(database.getConnection()).set(SQLDialect.SQLITE));
            armyJooq.delete(armyJooq.findAll());
            TroopDao troopJooq = new TroopDao(
                    new DefaultConfiguration().set(database.getConnection()).set(SQLDialect.SQLITE));
            troopJooq.delete(troopJooq.findAll());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void createArmyAndGetArmy() {
        List<? extends ITroop> initializedTroops = Utils.initializeTroops(troopRepository);
        IArmyComposition localCreated = new ArmyComposition(initializedTroops.get(0),
                initializedTroops.subList(2, initializedTroops.size()));
        IArmyComposition repoCreated = armyRepository.updateRelation(localCreated);
        IArmyComposition fetched = armyRepository.get(localCreated.getHQ().getId()).get();

        assertEquals(localCreated, repoCreated);
        assertEquals(localCreated, fetched);
    }
}