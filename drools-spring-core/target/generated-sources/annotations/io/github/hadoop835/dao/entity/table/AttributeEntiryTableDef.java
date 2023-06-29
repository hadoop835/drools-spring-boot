package io.github.hadoop835.dao.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class AttributeEntiryTableDef extends TableDef {

    public static final AttributeEntiryTableDef ATTRIBUTE_ENTIRY = new AttributeEntiryTableDef("", "dr_attribute");

    public QueryColumn NAME = new QueryColumn(this, "name");
    public QueryColumn TYPE = new QueryColumn(this, "type");
    public QueryColumn REMARK = new QueryColumn(this, "remark");
    public QueryColumn ID = new QueryColumn(this, "id");
    public QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");
    public QueryColumn CREATE_BY = new QueryColumn(this, "create_by");
    public QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");
    public QueryColumn UPDATE_BY = new QueryColumn(this, "update_by");
    public QueryColumn VERSION = new QueryColumn(this, "version");

    public QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{NAME, TYPE, REMARK, ID, CREATE_TIME, CREATE_BY, UPDATE_TIME, UPDATE_BY, VERSION};
    public QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    public AttributeEntiryTableDef(String schema, String tableName) {
        super(schema, tableName);
    }
}
