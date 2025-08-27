import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/admit")
@MultipartConfig


public class AdmitServlet extends HttpServlet {
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Loan obj = new Loan();
        obj.setOfferId(Integer.parseInt(request.getParameter("offer_id")));
        obj.setOfferName(request.getParameter("offer_name"));
        obj.setRateOfInterest(Double.parseDouble(request.getParameter("rate_of_interest")));


        Part filepart = request.getPart("terms");
        String filename = Paths.get(filepart.getSubmittedFileName()).getFileName().toString();
        String uploadLocation = "C:/Users/Bharath/Documents/uploads/";
        File uploadDir = new File(uploadLocation);

        if(!uploadDir.exists())
            uploadDir.mkdir();
        String filepath =  uploadLocation + File.separator + filename;

        filepart.write(filepath);
        obj.setTerms(filepath);

        try{
            new OffersDAO().createOffer(obj);
            RequestDispatcher rd = request.getRequestDispatcher("/admit.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
