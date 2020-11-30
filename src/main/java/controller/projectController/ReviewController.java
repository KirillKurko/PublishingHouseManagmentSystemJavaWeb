package controller.projectController;

import model.beans.project.Book;
import model.beans.project.Review;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.implementations.ReviewDAOImplementation;
import model.dao.projectDAOs.interfaces.BookDAO;
import model.dao.projectDAOs.interfaces.ReviewDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reviews")
public class ReviewController extends HttpServlet {

    private ReviewDAO reviewDAO;
    private BookDAO bookDAO;

    @Override
    public void init() {
        reviewDAO = new ReviewDAOImplementation();
        bookDAO = new BookDAOImplementation();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getBookReviews":
                getBookReviews(request, response);
                break;
            case "addReview":
                addReview(request, response);
                break;
            case "deleteReview":
                deleteReview(request, response);
                break;
            case "getAllReviews":
                getAllReviews(request, response);
                break;
        }
    }

    private void getBookReviews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdString = request.getParameter("bookId");
        int bookId = bookIdString == null ? (int) request.getAttribute("bookId") : Integer.parseInt(bookIdString);
        List<Review> reviews = reviewDAO.selectReviewsByBookId(bookId);
        request.setAttribute("reviews", reviews);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/reviews/bookReviewsPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rating = Integer.parseInt(request.getParameter("rating"));
        String description = request.getParameter("description");
        String bookName = request.getParameter("bookName");
        Book book = bookDAO.selectBookByName(bookName);
        if (book != null) {
            int bookId = book.getId();
            reviewDAO.insertReview(new Review(rating, description, bookName, bookId));
            request.setAttribute("bookId", bookId);
            getBookReviews(request, response);
        }
        else {
            getAllReviews(request, response);
        }
    }

    private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        reviewDAO.deleteReview(reviewId);
        request.setAttribute("bookId", bookId);
        getBookReviews(request, response);
    }

    private void getAllReviews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Review> reviews = reviewDAO.selectReviews();
        request.setAttribute("reviews", reviews);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/projects/books/reviews/bookReviewsPage.jsp");
        requestDispatcher.forward(request, response);
    }
}
