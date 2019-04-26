package servlets;

import dbService.DBException;
import dbService.DBService;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllRequestsServlet extends HttpServlet {

    DBService dbService;

    public AllRequestsServlet(DBService dbService){
        this.dbService = dbService;
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        try {
            dbService.addUser("tully2", "Pavel", "Ivanov",
                    "12.12.1989", "Ленина 11", "-", "admin", "i1.jpg");
            dbService.addUser("user2", "Василий", "Петров",
                    "02.03.1982", "Новая 5", "-", "user", "i2.jpeg");
            dbService.addUser("man", "Василий", "Иванов",
                    "24.08.2007", "Почтовая 24", "-", "user", "i1.jpg");

        } catch (DBException e) {
            e.printStackTrace();
        }

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("message", "");

        response.getWriter().println(PageGenerator.instance().getPage("set_users.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }
}
