package dao;

import javafx.collections.ObservableList;
import model.FirstLevelDivision;

import java.sql.SQLException;

public abstract class FirstLevelDivisionDao {

    public FirstLevelDivision get(int id) throws SQLException {
        return null;
    }


    public ObservableList<FirstLevelDivision> getAll() throws SQLException {
        return null;
    }



    public int insert(FirstLevelDivision f) throws SQLException {
        return 0;
    }


    public int update(FirstLevelDivision f) throws SQLException {
        return 0;
    }


    public int delete(FirstLevelDivision f) throws SQLException {
        return 0;
    }
}
