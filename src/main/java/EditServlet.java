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

@WebServlet("/update")
@MultipartConfig
public class EditServlet extends HttpServlet {

    private static final String UPLOAD_LOCATION = "C:/Users/Bharath/Documents/uploads/";

    public static String getUploadLocation() {
        return UPLOAD_LOCATION;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            File uploadDir = new File(UPLOAD_LOCATION);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            Loan obj = new Loan();
            obj.setOfferId(Integer.parseInt(req.getParameter("offer_id")));
            obj.setOfferName(req.getParameter("offer_name"));
            obj.setRateOfInterest(Integer.parseInt(req.getParameter("rate_of_interest")));

            Part filePart = req.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            if(!fileName.isEmpty()) {
                String filePath = UPLOAD_LOCATION + File.separator + fileName;
                filePart.write(filePath);
                obj.setTerms(filePath);

            }
            new OffersDAO().update(obj);
            resp.sendRedirect(req.getContextPath() + "/admit.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}
