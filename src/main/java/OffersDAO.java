import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffersDAO {

    // CRUD Operations
    public void createOffer(Loan loan) throws Exception {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtil.getConnection();
            String sql = "insert into offers(offer_id, offer_name, rate_of_interest, terms) values (?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, loan.getOfferId());
            pst.setString(2, loan.getOfferName());
            pst.setDouble(3, loan.getRateOfInterest());
            pst.setString(4, loan.getTerms());

            int output = pst.executeUpdate();
            if (output > 0) {
                System.out.println("Successfully inserted offers into DB");
            } else {
                System.out.println("Failed to insert offers into DB");
            }
        } finally {
            if (con != null) try { con.close(); } catch (SQLException ex) {}
            if (pst != null) try { pst.close(); } catch (SQLException ex) {}
        }
    }

    public List<Loan> getOffers() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            String sql = "select * from offers";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Loan> list = new ArrayList<>();
            while (rs.next()) {
                Loan loan = new Loan();
                loan.setOfferId(rs.getInt("offer_id"));
                loan.setOfferName(rs.getString("offer_name"));
                loan.setRateOfInterest(rs.getDouble("rate_of_interest"));
                loan.setTerms(rs.getString("terms"));
                list.add(loan);
            }
            return list;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ex) {}
            if (ps != null) try { ps.close(); } catch (SQLException ex) {}
            if (con != null) try { con.close(); } catch (SQLException ex) {}
        }
    }

    public void update(Loan loan) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getConnection();
            String qry = "UPDATE offers SET offer_name=?, rate_of_interest=?, terms=? WHERE offer_id=?";
            ps = con.prepareStatement(qry);
            ps.setString(1, loan.getOfferName());
            ps.setDouble(2, loan.getRateOfInterest());
            ps.setString(3, loan.getTerms());
            ps.setInt(4, loan.getOfferId());

            int output = ps.executeUpdate();
            if (output > 0) {
                System.out.println("Successfully updated offers into DB");
            } else {
                System.out.println("Failed to update offers into DB");
            }
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException ex) {}
            if (con != null) try { con.close(); } catch (SQLException ex) {}
        }
    }

    public void delete(int offerId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtil.getConnection();
            String qry = "delete from offers where offer_id=?";
            ps = con.prepareStatement(qry);
            ps.setInt(1, offerId);

            int output = ps.executeUpdate();
            if (output > 0) {
                System.out.println("Successfully deleted offers from DB");
            } else {
                System.out.println("Failed to delete offers from DB");
            }
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException ex) {}
            if (con != null) try { con.close(); } catch (SQLException ex) {}
        }
    }

    // Additional method for DeleteServlet
    public void deleteOffer(Loan loan) throws Exception {
        delete(loan.getOfferId());
    }
}