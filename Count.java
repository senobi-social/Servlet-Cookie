package chapter18;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie; // Cookieクラスのインポート
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter18/count"})
public class Count extends HttpServlet {

  public void doGet (
    HttpServletRequest request, HttpServletResponse response
  ) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    Page.header(out);

    // cookieの取得
    Cookie[] cookies = request.getCookies();

    // countの初期値にnullを代入
    Integer count = null;

    if (cookies != null) {

        for (Cookie cookie : cookies) {

          // クッキーの名前がcountかどうか調べる
          if (cookie.getName().equals("count")) {

            count = Integer.valueOf(cookie.getValue());

            break;
          }
        }
    }

    if (count == null) count=0;
    count ++;

    // カウンタの値をcountという名前のクッキーに保存
    Cookie cookie = new Cookie("count", count.toString());
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);

    out.println(count);
    Page.footer(out);
  }
}
