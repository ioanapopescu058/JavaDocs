package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Ioana.Popescu on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {

    }

    public static String getTableName(Class entity) {
        Annotation annotation = entity.getAnnotation(Table.class);
        if (annotation != null)
            return ((Table)annotation).name();
        return entity.getName();

//        Annotation [] an = entity.getAnnotations();
//        for (Annotation a : an) {
//            if (a.annotationType().equals(Table.class))
//                return ((Table)a).name();
//        }
//        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) {
        ArrayList<ColumnInfo> columns = new ArrayList<>();

        Field[] fields = entity.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(Column.class) ||
                    f.isAnnotationPresent(Id.class)) {
                ColumnInfo newCol = new ColumnInfo();
                newCol.setColumnName("");
                columns.add(newCol);
            }
        }
        return columns;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Integer"))
            return (Integer)value;
        else if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Long"))
            return (Long)value;
        else if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Float"))
            return (Float)value;
        else if (value instanceof BigDecimal && wantedType.getClass().getName().equals("Double"))
            return (Double)value;
        return value;
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        ArrayList<Field> fieldsList = new ArrayList<>();
        Field [] fields = clazz.getFields();
        for (Field f : fields) {
            if (f.getAnnotations().getClass().getName().equals(annotation.getName()))
                fieldsList.add(f);
        }
        return fieldsList;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException{
        if (object.getClass().isAnnotationPresent(Table.class)) {
            Field [] fields = object.getClass().getFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Id.class)) {
                    f.setAccessible(true);
                    return f.get(object);
                }
            }
        }
        return object;
    }
}
