package org.fir3.avm.environment.resource;

import lombok.Data;

import java.util.Set;

@Data
public class Table {
    private final Set<TablePackage> packages;
}
