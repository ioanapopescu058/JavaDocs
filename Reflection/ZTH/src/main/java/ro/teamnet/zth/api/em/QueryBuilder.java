package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ioana.Popescu on 7/12/2017.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value) {
        if (value instanceof String)
            return "'" + value + "'";
        else if (value instanceof Date) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
        }
        return value.toString();
    }

    public QueryBuilder addCondition(Condition condition) {
        this.conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    private StringBuilder createSelectQuery() {
        StringBuilder query = new StringBuilder();
        query.append("select ");
        for (ColumnInfo col : queryColumns) {
            query.append(col.getColumnName() + ", ");
        }
        int index = query.lastIndexOf(",");
        query.deleteCharAt(index);
        query.append("from " + tableName + " where ");
        for (Condition cond : conditions) {
            query.append(cond.getValue());
        }
        return query;
    }

    private StringBuilder createDeleteQuery() {
        StringBuilder delete = new StringBuilder();
        delete.append("delete ");
        delete.append("from " + tableName + " where ");
        for (Condition cond : conditions) {
            delete.append(cond.getValue());
        }
        return delete;
    }

    private StringBuilder createUpdateQuery() {
        StringBuilder update = new StringBuilder();
        update.append("update " + tableName + " set ");
        for (ColumnInfo col : queryColumns) {
            update.append(col.getColumnName() + " = " + 1);
        }
        update.append(" where ");
        for (Condition cond : conditions) {
            update.append(cond.getValue());
        }
        return update;
    }

    private StringBuilder createInsertQuery() {
        StringBuilder insert = new StringBuilder();
        insert.append("insert into " + tableName + " values ()");
        return insert;
    }

    public String createQuery() {
        if (queryType.equals(QueryType.SELECT))
            createSelectQuery();
        else if (queryType.equals(QueryType.DELETE))
            createDeleteQuery();
        else if (queryType.equals(QueryType.UPDATE))
            createUpdateQuery();
        else if (queryType.equals(QueryType.INSERT))
            createInsertQuery();
        return null;
    }

}
