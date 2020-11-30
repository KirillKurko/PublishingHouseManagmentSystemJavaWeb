package model.dao.projectDAOs.interfaces;

import model.beans.project.Review;

import java.util.List;

public interface ReviewDAO {

    int insertReview(Review review);

    boolean updateReview(Review review);

    boolean updateReviewsBookNameByBookId(String bookName, int bookId);

    Review selectReview(int id);

    List<Review> selectReviewsByBookId(int bookId);

    List<Review> selectReviews();

    boolean deleteReview(int id);

    boolean deleteReviewByBookId(int bookId);
}
