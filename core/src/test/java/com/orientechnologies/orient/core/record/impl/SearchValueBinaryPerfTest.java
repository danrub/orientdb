package com.orientechnologies.orient.core.record.impl;
import java.io.UnsupportedEncodingException;

import com.orientechnologies.orient.core.record.ORecordInternal;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.serialization.serializer.record.binary.BytesContainer;
import com.orientechnologies.orient.core.serialization.serializer.record.binary.ORecordSerializerBinaryV0;

public class SearchValueBinaryPerfTest {

  public static void main(String[] args) throws UnsupportedEncodingException {
    ODocument doc = new ODocument();
    for (int j = 0; j < 100; j++)
      doc.field("test" + j, "test" + j);
    int rawRecords = 10000;
    byte[][] records = new byte[rawRecords][];
    for (int i = 0; i < records.length; i++) {
      ORecordInternal.clearSource(doc);
      records[i] = doc.toStream();
    }
    ORecordSerializerBinaryV0 binary = new ORecordSerializerBinaryV0();
    byte[] toSearch = "test99".getBytes("UTF-8");
    long time = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      BytesContainer bytes = new BytesContainer(records[i % rawRecords]);
      bytes.offset = 1;
      String test1 = (String) binary.serachAndReturn(bytes, toSearch);
      if (!test1.equals("test99"))
        System.exit(10);
    }
    System.out.println("time " + (System.currentTimeMillis() - time));
  }
}
