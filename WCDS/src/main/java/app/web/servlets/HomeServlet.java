package app.web.servlets;

import app.util.FileUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private final static String FILE_PATH =
            "D:\\SoftUni\\JavaWebBasics\\Projects\\05-IntroToJavaEE\\west-compas-dealer-shop\\WCDS\\src\\main\\webapp\\views\\home.html";

    private final FileUtil fileUtil;

    @Inject
    public HomeServlet(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        String html = this.fileUtil.readFile(FILE_PATH);
        out.println(html);
    }
}
