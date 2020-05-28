package chapter18;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie; // Cookieクラスのインポート
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.net.URLDecoder;

@WebServlet(urlPatterns={"/chapter18/get"})
public class Get extends HttpServlet {

  public void doGet (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    Page.header(out);

    // クッキーの取得（配列）
    Cookie[] cookies = request.getCookies();

    // クッキーが存在しないときはnullが返ってくる
    if (cookies != null) {

      for (Cookie cookie : cookies) {

        String name = URLDecoder.decode(cookie.getName(), "utf-8");
        String value = URLDecoder.decode(cookie.getValue(), "utf-8");
        out.println("<p>" + name + ":" + value + "</p>");

      }
    } else {

        out.println("クッキーは存在しません");
    }


    Page.footer(out);
  }
}
