import java.util.regex.Pattern;

public class RemoveGroupBy {

    public static StringBuilder optimizeGroupBy(StringBuilder query, StringBuilder result) {
        // Check if there's a UNION clause
        String aux = query.toString().toUpperCase();

        String[] queries = aux.split("UNION");

        for (int i = 0; queries.length > 1 && i < queries.length; i++) {
            // Optimize each subquery before UNION

            int groupByStartIndex = queries[i].indexOf("GROUP BY");
            int fromLastIndex = queries[i].lastIndexOf("FROM");
            boolean hasAggregate = containsAggregateFunction(queries[i].substring(0, fromLastIndex));

            if(!hasAggregate)
                result.append(queries[i].substring(0, groupByStartIndex));
            else
                result.append(queries[i]);

            if (i > 1 || i < queries.length - 1)
                result.append(" UNION ");
        }

        return result;
    }

    private static boolean containsAggregateFunction(String query) {
        String aggregateRegex = "(?i)\\b(SUM|MIN|MAX|AVG|COUNT)\\("; // Case-insensitive matching
        return Pattern.compile(aggregateRegex).matcher(query).find();
    }

    private static boolean containsAggregateFunction2(String query) {
        String[] aggregates = {"SUM", "MIN", "MAX", "AVG", "COUNT"};
        for (String aggregate : aggregates) {
            if (query.indexOf(aggregate + "(") >= 0)
                return true;

        }
        return false;
    }


    public static void main(String[] args) {

        String query = "SELECT a.FIELD_A1 as FIELD_A1, a.FIELD_A2 as FIELD_A2, b.FIELD_B1 as FIELD_B1\n" + " FROM TABLE_A a, TABLE_B b, (SOME AUXILIARY SELECT INSIDE THE PARENTHESIS)\n" + " WHERE (CONDITIONS)\n" + " GROUP BY (FIELDS IN SELECT)\n" + "union\n" + "SELECT distinct a.FIELD_A1 as FIELD_A1, a.FIELD_A2 as FIELD_A2, b.FIELD_B1 as FIELD_B1, sum(b.FIELD_B2)\n" + " FROM TABLE_A a, TABLE_B b, (SOME AUXILIARY SELECT INSIDE THE PARENTHESIS)\n" + " WHERE (CONDITIONS)\n" + " GROUP BY (FIELDS IN SELECT)";

        StringBuilder qb = new StringBuilder(query);
        StringBuilder result = new StringBuilder();

        System.out.println(optimizeGroupBy(qb, result));

    }
}
