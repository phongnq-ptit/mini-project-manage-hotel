/*
 * This file is generated by jOOQ.
 */
package org.luffy.jooq;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.luffy.jooq.tables.FlywaySchemaHistory;
import org.luffy.jooq.tables.Users;
import org.luffy.jooq.tables.records.FlywaySchemaHistoryRecord;
import org.luffy.jooq.tables.records.UsersRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * manage_hotel_v2.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("KEY_flyway_schema_history_PRIMARY"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, DSL.name("KEY_users_PRIMARY"), new TableField[] { Users.USERS.ID }, true);
}
