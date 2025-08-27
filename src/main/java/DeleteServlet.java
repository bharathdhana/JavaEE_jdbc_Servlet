import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int offerId = Integer.parseInt(req.getParameter("key"));
            OffersDAO dao = new OffersDAO();

            dao.delete(offerId);

            resp.sendRedirect(req.getContextPath() + "/admit.jsp");
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
