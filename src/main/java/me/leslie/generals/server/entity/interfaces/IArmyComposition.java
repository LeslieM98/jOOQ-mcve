package me.leslie.generals.server.entity.interfaces;

import java.util.Set;

public interface IArmyComposition {
    ITroop getHQ();

    Set<? extends ITroop> getTroops();
}
