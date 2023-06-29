package io.github.hadoop835.dao.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class ConditionAttrEntityTableDef extends TableDef {

    public static final ConditionAttrEntityTableDef CONDITION_ATTR_ENTITY = new ConditionAttrEntityTableDef("", "dr_condition_attr");

    public QueryColumn NAME = new QueryColumn(this, "name");
    public QueryColumn ATTR_NAME = new QueryColumn(this, "attr_name");
    public QueryColumn ATTR_VALUE = new QueryColumn(this, "attr_value");
    public QueryColumn CONDITION_ID = new QueryColumn(this, "condition_id");
    public QueryColumn ID = new QueryColumn(this, "id");
    public QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");
    public QueryColumn CREATE_BY = new QueryColumn(this, "create_by");
    public QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");
    public QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");
    public QueryColumn VERSION = new QueryColumn(this, "version");

    public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{NAME, ATTR_NAME, ATTR_VALUE, CONDITION_ID, ID, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, VERSION};
    public QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    public ConditionAttrEntityTableDef(String schema, String tableName) {
        super(schema, tableName);
    }
}
