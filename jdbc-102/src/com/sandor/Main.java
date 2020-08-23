package com.sandor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        if (!DataSource.openConnection()) {
            System.out.println("Could not connect to DataSource");
            return;
        }
        System.out.println("Could Connect to DataSource");
        List<SQLColumn> cols = new ArrayList<>();
        cols.add(new SQLColumn("id", "VARCHAR"));
        cols.add(new SQLColumn("albumName", "VARCHAR"));
        cols.add(new SQLColumn("artistName", "VARCHAR"));
        cols.add(new SQLColumn("year", "INTEGER"));
        DataSource.createTable("albums", cols);
        DataSource.insert("adfg", "Zhe BSA", "The Best Album", 1999);
        List<AlbumModel> albums = DataSource.getAlbums();
        for (AlbumModel album : albums) {
            System.out.println(album.getAlbumName());
        }
    }
}
