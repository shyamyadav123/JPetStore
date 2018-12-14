package com.nevercome.jpetstore.web.servlets.account;

import com.nevercome.jpetstore.utils.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet("/account/verify")
public class VerifyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, Object> vcMap = VerifyCode.generateCodeAndPic();
        session.setAttribute("code", vcMap.get("code"));
        session.setAttribute("codePic", vcMap.get("codePic"));
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write((BufferedImage) vcMap.get("codePic"), "png", out);
    }
}
