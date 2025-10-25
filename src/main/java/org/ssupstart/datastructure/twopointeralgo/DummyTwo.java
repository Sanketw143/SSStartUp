package org.ssupstart.datastructure.twopointeralgo;

public class DummyTwo {
    //  private List<RexNode> resolveOperandsOfTypeListInTuples(TExpression tExpression1, TExpression tExpression2) {
//    List<RexNode> leftOperands = new ArrayList<>();
//    for (int i = 0; i < tExpression1.getExprList().size(); i++) {
//      TExpression expr = tExpression1.getExprList().getExpression(i);
//      leftOperands.add(resolver.resolve(expr));
//    }
//
//    List<RexNode> rightOperands = new ArrayList<>();
//    for (int i = 0; i < tExpression2.getExprList().size(); i++) {
//      TExpression expr = tExpression2.getExprList().getExpression(i);
//      rightOperands.add(resolver.resolve(expr));
//    }
//
//    if (leftOperands.size() != rightOperands.size()) {
//      throw new IllegalArgumentException("Tuple size mismatch in comparison");
//    }
//
//    // return [left tuple, right tuple]
//    List<RexNode> tuples = new ArrayList<>();
//    tuples.add(builder.call(SqlStdOperatorTable.ROW, leftOperands));
//    tuples.add(builder.call(SqlStdOperatorTable.ROW, rightOperands));
//
//    return tuples;
//  }

//  private RexNode buildTupleComparison(RexNode leftTuple, RexNode rightTuple, SqlBinaryOperator sqlBinaryOperator, Identifier identifier) {
//    return builder.call(sqlBinaryOperator, leftTuple, rightTuple);
//  }



//    Disadvantages / Gotchas
//    NULL handling
//    Standard SQL says row comparisons return UNKNOWN if any element is NULL.
//    Example: (NULL, 10) != (2, 10) → result is UNKNOWN (so row excluded).
//    But with explicit OR expansion:
//    employee_id <> 2 OR department_id <> 10
//            → this could return TRUE if department_id <> 10, even if employee_id is NULL.
//    So behavior differs subtly with NULLs.

//    Readability vs Explicitness
//            (a, b) != (x, y) is shorter and cleaner.
//    a <> x OR b <> y makes the null-handling rules clearer, since each comparison is explicit.
//            Portability

//    While BigQuery supports row constructors now, not all SQL engines (especially older ones, or ANSI-strict modes) do.
//
//    If your SQL needs to run on multiple platforms (e.g., Teradata, SparkSQL, Presto),
//    tuple comparison might break.
}
