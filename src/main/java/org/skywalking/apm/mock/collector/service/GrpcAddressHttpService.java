package org.skywalking.apm.mock.collector.service;

import com.google.gson.JsonArray;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GrpcAddressHttpService extends HttpServlet {

    public static String SERVLET_PATH = "/grpc/addresses";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("127.0.0.1:19876");
        resp.setContentType("text/json");
        resp.setCharacterEncoding("utf-8");
        resp.setStatus(200);

        PrintWriter out = resp.getWriter();
        out.print(jsonArray.toString());
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
