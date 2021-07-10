package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImgMapper implements RowMapper<Img> {

    @Override
    public Img mapRow(ResultSet resultSet, int i) throws SQLException {
        Img img = new Img();
        img.setIdImg(resultSet.getInt("idImg"));
        return img;
    }
}
