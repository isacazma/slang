package nl.hu.bep.battlesnake.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testDatabase {
    private Connection connection;

    // JDBC Driver Name & Database URL
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://ec2-63-34-180-86.eu-west-1.compute.amazonaws.com:5432/dahnfsqh05n6k0";

    // JDBC Database Credentials
    static final String JDBC_USER = "impertjycgewfu";
    static final String JDBC_PASS = "e9ce2f8cad4fe54a26f7213826ec8af4f701c50103223d70996d76d8c232f447";

    public testDatabase(){
        String url = DB_URL;
        String user_name = JDBC_USER;
        String password = JDBC_PASS;

        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(url, user_name, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getId()
    {
        String sql = "SELECT Id FROM Game";
        List<Integer> testList = new ArrayList<>();

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                test t = new test();
                t.setKey(rs.getInt(1));
                testList.add(t.getKey());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return testList;
    }

    public void setId(String gameID, String turns, String snakeSize) throws SQLException {
        PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO Game (GameID, Turns, SnakeSize) VALUES (?, ?, ?)");
        pstmt.setString(1, gameID);
        pstmt.setString(2, turns);
        pstmt.setString(3, snakeSize);
        pstmt.executeUpdate();
    }

    public void deleteID(int gameID) throws SQLException {

        PreparedStatement pstmt = this.connection.prepareStatement("DELETE FROM Game WHERE Id = (?)");
        pstmt.setInt(1, gameID);
        pstmt.executeUpdate();

    }

    public Map<String, Object> getSingleData(int id) {
        Map<String, Object> SingleDataMap = new HashMap<>();

        try {
            PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM Game WHERE Id = (?)");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                SingleDataMap.put("id", rs.getString(1));
                SingleDataMap.put("gameID", rs.getString(2));
                SingleDataMap.put("aantalBeurten", rs.getString(3));
                SingleDataMap.put("lengteSlang", rs.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return SingleDataMap;
    }
}
