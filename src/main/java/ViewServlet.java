import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Loan> received = new OffersDAO().getOffers();
            HttpSession session = request.getSession(true);
            session.setAttribute("received", received);
            RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
            rd.forward(request, response);
        }catch (Exception e){
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);

        }
    }
}
