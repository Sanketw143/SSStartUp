//package com.datametica.swift.algebrabuilder.operators.snowflake
//
//import com.datametica.swift.algebrabuilder.operators.AbstractFunctionConverter
//import com.datametica.swift.algebrabuilder.operators.ClassicFunctionConverterResult
//import com.datametica.swift.algebrabuilder.operators.FunctionConverterResult
//import com.datametica.swift.algebrabuilder.operators.RexNodeConversionResult
//import com.datametica.swift.algebrabuilder.operators.SourceFunctionDefinition
//import com.datametica.swift.algebrabuilder.operators.SrcOperatorContext
//import groovy.transform.CompileStatic
//import org.apache.calcite.rel.type.RelDataType
//import org.apache.calcite.rex.RexNode
//import org.apache.calcite.sql.fun.SqlStdOperatorTable
//import org.apache.calcite.sql.type.SqlTypeFamily
//import org.apache.calcite.sql.type.SqlTypeName
//import org.apache.calcite.tools.RelBuilder
//
//import java.util.List;
//
///**
// * SnowflakeCoalesceFunctionConverter is used to handle COALESCE function in snowflake
// */
//@CompileStatic
//class SnowflakeCoalesceFunctionConverter extends AbstractFunctionConverter {
//
//    SnowflakeCoalesceFunctionConverter(SourceFunctionDefinition sourceFunctionDefinition) {
//        super(sourceFunctionDefinition)
//    }
//
//    @Override
//    FunctionConverterResult convert(
//            List<RexNode> sourceOperands, RelBuilder builder, SrcOperatorContext srcOperatorContext) {
//
//        if (sourceOperands.any(it -> it.type.family == SqlTypeFamily.DATE)) {
//            if (isCastingRequired(sourceOperands[0].type, sourceOperands[1].type)) {
//                sourceOperands = applyCasting(sourceOperands, builder)
//            }
//            if (hasTimestamp(sourceOperands)) {
//                sourceOperands = normalizeToTimestamp(sourceOperands, builder)
//            }
//            if(hasTime(sourceOperands)) {
//                sourceOperands = normalizeToTime(sourceOperands, builder)
//            }
//            return new ClassicFunctionConverterResult(SqlStdOperatorTable.COALESCE, sourceOperands)
//        } else if (sourceOperands.get(0).type.sqlTypeName == SqlTypeName.VARIANT) {
//            RexNode castedVariantRex = builder.cast(sourceOperands[0], sourceOperands[1].type.sqlTypeName)
//            return new RexNodeConversionResult(
//                    builder.call(SqlStdOperatorTable.COALESCE, [castedVariantRex, sourceOperands[1]]))
//        } else if (sourceOperands.any(it -> it.type.family == SqlTypeFamily.NUMERIC)) {
//            if (hasNonNumeric(sourceOperands)) {
//                sourceOperands = normalizeToNumeric(sourceOperands, builder)
//            }
//            return new ClassicFunctionConverterResult(SqlStdOperatorTable.COALESCE, sourceOperands)
//        } else if (hasTimestamp(sourceOperands)) {
//            List<RexNode> normalizedOperands = normalizeToTimestamp(sourceOperands, builder)
//            return new ClassicFunctionConverterResult(SqlStdOperatorTable.COALESCE, normalizedOperands)
//        } else if(hasTime(sourceOperands)) {
//            List<RexNode> normalizedOperands = normalizeToTime(sourceOperands, builder)
//            return new ClassicFunctionConverterResult(SqlStdOperatorTable.COALESCE, normalizedOperands)
//        }
//        return new RexNodeConversionResult(builder.call(SqlStdOperatorTable.COALESCE, sourceOperands))
//    }
//
//    static boolean isCastingRequired(RelDataType relDataType1, RelDataType relDataType2) {
//        return relDataType1.getSqlTypeName().getFamily() != relDataType2.sqlTypeName.getFamily()
//    }
//
//    static boolean hasNonNumeric(List<RexNode> sourceOperands) {
//        return sourceOperands.any(operand -> operand.type.family != SqlTypeFamily.NUMERIC)
//    }
//
//    static boolean hasTimestamp(List<RexNode> sourceOperands) {
//        return sourceOperands.any(operand -> operand.type.family == SqlTypeFamily.TIMESTAMP)
//    }
//
//    static boolean hasTime(List<RexNode> sourceOperands) {
//        return sourceOperands.any(operand -> operand.type.family == SqlTypeFamily.TIME)
//    }
//
//    private static List<RexNode> normalizeToTimestamp(List<RexNode> sourceOperands, RelBuilder builder) {
//        return sourceOperands.collect(it -> it.type.family == SqlTypeFamily.TIMESTAMP
//                ? it : builder.cast(it, SqlTypeName.TIMESTAMP))
//    }
//
//    private static List<RexNode> normalizeToTime(List<RexNode> sourceOperands, RelBuilder builder) {
//        return sourceOperands.collect(it -> it.type.family == SqlTypeFamily.TIME
//                ? it : builder.cast(it, SqlTypeName.TIME))
//    }
//
//    private static List<RexNode> normalizeToNumeric(List<RexNode> sourceOperands, RelBuilder builder) {
//        return sourceOperands.collect(it -> it.type.family == SqlTypeFamily.NUMERIC
//                ? it : builder.cast(it, SqlTypeName.DECIMAL, 38, 10))
//    }
//
//    private static List<RexNode> applyCasting(List<RexNode> sourceOperands, RelBuilder builder) {
//        return (sourceOperands[1].type.sqlTypeName == SqlTypeName.CHAR)
//                ? castCharTypeOperand(builder, sourceOperands)
//                : sourceOperands
//    }
//
//    private static List<RexNode> castCharTypeOperand(RelBuilder builder, List<RexNode> sourceOperands) {
//        SqlTypeName expressionType = sourceOperands[0].type.sqlTypeName
//    [sourceOperands[0], builder.cast(sourceOperands[1], expressionType)]
//    }
//}
