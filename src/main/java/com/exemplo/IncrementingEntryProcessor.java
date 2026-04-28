package com.exemplo;

import com.hazelcast.map.EntryProcessor;
import java.util.Map;

public class IncrementingEntryProcessor implements EntryProcessor<String, String, String> {
    public String process( Map.Entry<String, String> entry ) {
        String value = entry.getValue();
        entry.setValue( value + 1 );
        return value + "f";
    }

    @Override
    public EntryProcessor<String, String, String> getBackupProcessor() {
        return IncrementingEntryProcessor.this;
    }
}