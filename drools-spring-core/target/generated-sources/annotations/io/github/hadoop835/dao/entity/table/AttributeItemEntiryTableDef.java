package io.github.hadoop835.dao.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class AttributeItemEntiryTableDef extends TableDef {

    public static final AttributeItemEntiryTableDef ATTRIBUTE_ITEM_ENTIRY = new AttributeItemEntiryTableDef("", "dr_attribute_item");

    public QueryColumn REMARK = new QueryColumn(this, "remark");
    public QueryColumn VALUE = new QueryColumn(this, "value");
    public QueryColumn ATTRIBUTE_ID = new QueryColumn(this, "attribute_id");
    public QueryColumn ID = new QueryColumn(this, "id");
    public QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");
    public QueryColumn CREATE_BY = new QueryColumn(this, "create_by");
    public QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");
    public QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");
    public QueryColumn VERSION = new QueryColumn(this, "version");

    public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{REMARK, VALUE, ATTRIBUTE_ID, ID, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, VERSION};
    public QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    public AttributeItemEntiryTableDef(String schema, String tableName) {
        super(schema, tableName);
    }
}
