package shop.mtcoding.web1;

import shop.mtcoding.web1.controller.BoardController;
import shop.mtcoding.web1.controller.UserController;
import shop.mtcoding.web1.model.Board;
import shop.mtcoding.web1.model.BoardRepository;
import shop.mtcoding.web1.model.User;
import shop.mtcoding.web1.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// http://localhost:8080/board/list.do
// http://localhost:8080/board/detail.do
// http://localhost:8080/board/write.do
// http://localhost:8080/user/join.do
// http://localhost:8080/user/login.do
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().println(req.getRequestURI() + " : 요청됨");

        String path = getPath(req);
        String action = getAction(req);

        UserController userCon = UserController.getInstance();
        BoardController boardCon = BoardController.getInstance();

        if (path.equals("user")) {
            UserRepository userRepository = UserRepository.getInstance();
            switch (action) {
                case "join":
                    String joinView = userCon.join();
                    req.getRequestDispatcher(joinView).forward(req, resp);
                    break;
                case "userInfo":
                    // sendRedirect는 request가 두번 만들어지기 때문에 값 보관이 안됨.
                    String userInfoView = userCon.userInfo();
                    User userValue = userRepository.findById(1);
                    req.setAttribute("userKey", userValue);
                    resp.sendRedirect(userInfoView);
                    break;
                default:
                    resp.sendRedirect("/");
            }
        } else if (path.equals("board")) {
            BoardRepository boardRepository = BoardRepository.getInstance();
            switch (action) {
                case "write":
                    String writeView = boardCon.write();
                    // WEB-INF 폴더는 새로운 요청으로는 못찾음. (내부적으로만 찾을 수 있음)
                    resp.sendRedirect(writeView);
                    break;
                case "list":
                    String listView = boardCon.list();
                    List<Board> boardListValue = boardRepository.findAll();
                    req.setAttribute("boardListKey", boardListValue);
                    req.getRequestDispatcher(listView).forward(req, resp);
                    break;
                case "detail":
                    String detailView = boardCon.detail();
                    Board boardValue = boardRepository.findById(1);
                    req.setAttribute("boardKey", boardValue);
                    req.getRequestDispatcher(detailView).forward(req, resp);
                    break;
                default:
                    resp.sendRedirect("/");
            }
        }
    }

    private String getPath(HttpServletRequest req) {
        String path = getUri(req).split("/")[0];
        //System.out.println(path);
        return path;
    }

    private String getAction(HttpServletRequest req) {
        String action = getUri(req).split("/")[1];
        action = action.replace(".do", "");
        //System.out.println(action);
        return action;
    }

    private String getUri(HttpServletRequest req) {
        String uri = req.getRequestURI();
        uri = uri.substring(1);
        return uri;
    }
}
