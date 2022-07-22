package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Chipset;
import com.courseproj.CourseProject.Entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChipsetMapper implements RowMapper<Chipset> {
    @Override
    public Chipset mapRow(ResultSet resultSet, int i) throws SQLException {
        Chipset chipset = new Chipset();
        chipset.setId(resultSet.getInt("idChipset"));
        chipset.setName(resultSet.getString("name"));
        return chipset;
    }
}
