package beansTests.projectBeansTests.reviewBeanTests;

import model.beans.project.Review;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ReviewBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();
        final Field id = review.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(review, 1);

        assertEquals("field wasn't retrieved properly", review.getId(), 1);
    }

    @Test
    public void testGetRating() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();
        final Field rating  = review.getClass().getDeclaredField("rating");
        rating.setAccessible(true);
        rating.set(review, 100);

        assertEquals("field wasn't retrieved properly", review.getRating(), 100);
    }

    @Test
    public void testGetDescription() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();
        final Field description  = review.getClass().getDeclaredField("description");
        description.setAccessible(true);
        description.set(review, "description");

        assertEquals("field wasn't retrieved properly", review.getDescription(), "description");
    }

    @Test
    public void testGetBookID() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();
        final Field bookID  = review.getClass().getDeclaredField("bookID");
        bookID.setAccessible(true);
        bookID.set(review, 10);

        assertEquals("field wasn't retrieved properly", review.getBookID(), 10);
    }
}
