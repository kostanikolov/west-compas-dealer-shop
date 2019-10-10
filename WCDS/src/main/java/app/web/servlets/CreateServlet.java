package app.web.servlets;

import app.domain.models.binding.CarCreateBindingModel;
import app.domain.models.service.CarServiceModel;
import app.service.CarService;
import app.util.FileUtil;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    private static final String FILE_PATH =
            "D:\\SoftUni\\JavaWebBasics\\Projects\\05-IntroToJavaEE\\west-compas-dealer-shop\\WCDS\\src\\main\\webapp\\views\\create.html";

    private final FileUtil fileUtil;
    private final CarService carService;
    private final ModelMapper modelMapper;

    @Inject
    public CreateServlet(FileUtil fileUtil, CarService carService, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String html = this.fileUtil.readFile(FILE_PATH);
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarCreateBindingModel bindingModel = new CarCreateBindingModel();

        bindingModel.setBrand(req.getParameter("brand"));
        bindingModel.setModel(req.getParameter("model"));
        bindingModel.setYear(Integer.parseInt(req.getParameter("year")));
        bindingModel.setEngine(req.getParameter("engine"));

        this.carService.createCar(this.modelMapper.map(bindingModel, CarServiceModel.class));
        resp.sendRedirect("/all");
    }
}
