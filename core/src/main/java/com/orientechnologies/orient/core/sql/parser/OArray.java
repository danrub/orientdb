/* Generated By:JJTree: Do not edit this line. OArray.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.List;

public class OArray extends SimpleNode {

  protected List<OExpression> expressions;

  public OArray(int id) {
    super(id);
  }

  public OArray(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public List<OExpression> getExpressions() {
    return expressions;
  }

  public void setExpressions(List<OExpression> expressions) {
    this.expressions = expressions;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("[");
    boolean first = true;
    for (OExpression expr : expressions) {
      if (!first) {
        result.append(", ");
      }
      result.append(expr.toString());
      first = false;
    }
    result.append("]");
    return result.toString();
  }
}
/* JavaCC - OriginalChecksum=4ce0ac27df6d4ae4fbba00175e5dd3e2 (do not edit this line) */
