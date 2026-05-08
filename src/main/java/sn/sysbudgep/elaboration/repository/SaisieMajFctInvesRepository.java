package sn.sysbudgep.elaboration.repository;

import org.springframework.stereotype.Repository;
import sn.sysbudgep.elaboration.dto.ProjetDeBudgetDto;
import sn.sysbudgep.elaboration.util.GetConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaisieMajFctInvesRepository {

    public List<ProjetDeBudgetDto> getProjetDeBudget(int expbExe) {
        List<ProjetDeBudgetDto> list = new ArrayList<>();
        String sql = "SELECT EXPB_CODE, EXPB_LIB, EXPB_DEBUT " +
                     "FROM vb3_exercice_projet_bud " +
                     "WHERE EXPB_EXE = ? AND EXPB_DEBUT IS NOT NULL";
        try (Connection con = GetConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, expbExe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProjetDeBudgetDto(
                        rs.getString("EXPB_CODE"),
                        rs.getString("EXPB_LIB"),
                        rs.getTimestamp("EXPB_DEBUT")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
