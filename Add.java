package chapter18;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie; // Cookieクラスのインポート
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.net.URLEncoder;

@WebServlet(urlPatterns={"/chapter18/add"})
public class Add extends HttpServlet {

    public void doGet (
      HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {


      String name = URLEncoder.encode("名前", "utf-8");
      String value = URLEncoder.encode("値", "utf-8");

      // コンストラクタでクッキーを作成
      // 名前はname、値はvalue
      Cookie cookie = new Cookie(name, value);

      // クッキーの生存期間を設定
      cookie.setMaxAge(60*60*24);

      // クッキーを追加する
      response.addCookie(cookie);

    }
}
