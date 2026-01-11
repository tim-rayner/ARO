package com.argus.domain.deed;

import java.util.Objects;

public record SourceRef(SourceDataset dataset, String fileId) {

    public SourceRef {
        Objects.requireNonNull(dataset, "dataset must not be null");
        Objects.requireNonNull(fileId, "fileId must not be null");
    }

    public String deduplicationKey() {
        return dataset.name() + ":" + fileId;
    }
}
