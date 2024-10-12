package org.asif.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}
