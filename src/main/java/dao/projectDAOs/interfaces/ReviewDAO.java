package dao.projectDAOs.interfaces;

import beans.project.Review;

public interface ReviewDAO {

    int insertReview(Review review);

    boolean updateReview(Review review);

    Review selectReview(int id);

    boolean deleteReview(int id);
}
