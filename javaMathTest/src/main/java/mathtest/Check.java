package mathtest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnection store = new DatabaseConnection();
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        String user_answer = request.getParameter("answer");
        Question q = store.getQuestion(questionId);
        PrintWriter writer = response.getWriter();
        store.saveResult(q, user_answer);
        
        writer.println("<h1>Ответ пользователя: " + user_answer + "; Ответ программы: " + q.getAnswer() + "</h1>");
        writer.close();
    }
}

