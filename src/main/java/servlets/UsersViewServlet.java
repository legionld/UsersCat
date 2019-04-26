package servlets;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UsersViewServlet extends HttpServlet {
    private final DBService dbService;

    public UsersViewServlet(DBService dbService) {
        this.dbService = dbService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        StringBuilder str;
        StringBuilder answer = new StringBuilder(" ");
        Map<String, Object> pageVariables = new HashMap<>();
        try {
            List<UsersDataSet> list = dbService.getUserAll();
            for (Iterator<UsersDataSet> it = list.iterator(); it.hasNext();) {
                UsersDataSet dataSet = it.next();
                if (dataSet != null) {
                    str = new StringBuilder("<tr>" +
                            "<details>" +
                            "<summary>" +
                            "<table width=\"100%\"" +
                            "<tr>\n" +
                            "    <td width=\"25%\">&nbsp;</td>\n" +
                            "    <td width=\"25%\">" + dataSet.getLogin() + "</td>\n" +
                            "    <td width=\"25%\">" + dataSet.getSname() + "</td>\n" +
                            "    <td width=\"25%\">" + dataSet.getFname() + "</td>\n" +
                            "</tr>" +
                            "</table>" +
                            "</summary>" +
                            "<div>" +
                            "<ul>" +
                            "    <li>" + "Дата рождения: " + dataSet.getBdata() + "</li>\n" +
                            "    <li>" + "Адрес проживания: " + dataSet.getAdress() + "</li>\n" +
                            "    <li>" + "Дополнительная информация: " + dataSet.getInfo() + "</li>\n" +
                            "    <li>" + "Роль: " + dataSet.getPermission() + "</li>\n" +
                            "</ul>" +
                            "</div>" +
                            "<div>" +
                            "<img src=\"images/" + dataSet.getPhoto() + "\" width = \"150px\" alt=\"\" />" +
                            "</div>" +
                            "</details>" +
                            "</tr>");
                    answer = new StringBuilder(answer.toString() + str);
                }
            }
            pageVariables.put("users", answer.toString());
            response.getWriter().println(PageGenerator.instance().getPage("users.html", pageVariables));
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
