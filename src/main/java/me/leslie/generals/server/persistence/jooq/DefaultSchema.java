/*
 * This file is generated by jOOQ.
 */
package me.leslie.generals.server.persistence.jooq;


import me.leslie.generals.server.persistence.jooq.tables.Army;
import me.leslie.generals.server.persistence.jooq.tables.Troop;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.2"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = -1981960862;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>ARMY</code>.
     */
    public final Army ARMY = me.leslie.generals.server.persistence.jooq.tables.Army.ARMY;

    /**
     * The table <code>TROOP</code>.
     */
    public final Troop TROOP = me.leslie.generals.server.persistence.jooq.tables.Troop.TROOP;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
                Army.ARMY,
                Troop.TROOP);
    }
}
