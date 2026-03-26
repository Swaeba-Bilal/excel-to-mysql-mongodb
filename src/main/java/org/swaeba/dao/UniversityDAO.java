package org.swaeba.dao;

import org.swaeba.config.DBConnection;
import org.swaeba.model.University;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UniversityDAO {
    public static void insertData(List<University> list){
        try {
            Connection con= DBConnection.getConnection();
            String query = "INSERT INTO universities " +
                    "(id, university_name, program, city, country, ranking, fee, duration_years) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            for(University u :list){
                ps.setInt(1, u.getId());
                ps.setString(2,u.getName());
                ps.setString(3,u.getProgram());
                ps.setString(4,u.getCity());
                ps.setString(5,u.getCountry());
                ps.setInt(6,u.getRanking());
                ps.setInt(7,u.getFee());
                ps.setInt(8,u.getDuration());
                ps.executeUpdate();

            }
            ps.close();
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
