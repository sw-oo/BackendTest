package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardRepository {
    public void create(BoardDto boardDto) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://10.10.10.100:3306/test", "root", "qwer1234");
            try (Statement stmt = conn.createStatement()) {
                Integer affectedRows = stmt.executeUpdate(
                        "INSERT INTO board (title, contents) VALUES ('"+ boardDto.getTitle() +"', '"+ boardDto.getContents() +"')",
                        Statement.RETURN_GENERATED_KEYS
                );

                if(affectedRows > 0) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    if(rs.next()) {
                        rs.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
