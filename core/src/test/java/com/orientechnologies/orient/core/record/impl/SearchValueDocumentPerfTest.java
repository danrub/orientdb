package com.orientechnologies.orient.core.record.impl;
import com.orientechnologies.orient.core.record.ORecordInternal;
import com.orientechnologies.orient.core.record.impl.ODocument;

public class SearchValueDocumentPerfTest {

  public static void main(String[] args) {
    ODocument doc = new ODocument();
    for (int j = 0; j < 100; j++)
      doc.field("test" + j, "test" + j);
    int rawRecords = 10000;
    byte[][] records = new byte[rawRecords][];
    for (int i = 0; i < records.length; i++) {
      ORecordInternal.clearSource(doc);
      records[i] = doc.toStream();
    }
    long time = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      ODocument doc1 = new ODocument();
      doc1.fromStream(records[i % rawRecords]);
      String test1 = doc1.field("test99");
      if (!test1.equals("test99"))
        System.exit(10);
    }
    System.out.println("time " + (System.currentTimeMillis() - time));
  }
}
