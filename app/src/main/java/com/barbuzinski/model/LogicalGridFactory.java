package com.barbuzinski.model;

public class LogicalGridFactory {

    public LogicalGrid createDefault() {
        LogicalGrid grid = new LogicalGrid(
                2,
                3,
                new int[][]{
                        {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY, LogicalGrid.EMPTY},
                        {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY, LogicalGrid.EMPTY},
                        {LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.FIXED, LogicalGrid.EMPTY},
                        {LogicalGrid.EMPTY, LogicalGrid.EMPTY, LogicalGrid.FIXED, LogicalGrid.EMPTY}
                });
        return grid;
    }
}
