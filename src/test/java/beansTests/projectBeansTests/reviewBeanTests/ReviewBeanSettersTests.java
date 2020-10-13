package beansTests.projectBeansTests.reviewBeanTests;

import beans.project.Review;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ReviewBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();

        review.setId(1);

        final Field id = review.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(review), 1);
    }

    @Test
    public void testSetRating() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();

        review.setRating(100);

        final Field rating = review.getClass().getDeclaredField("rating");
        rating.setAccessible(true);
        assertEquals("Fields doesn't match", rating.get(review), 100);
    }

    @Test
    public void testSetDescription() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();

        review.setDescription("description");

        final Field description = review.getClass().getDeclaredField("description");
        description.setAccessible(true);
        assertEquals("Fields doesn't match", description.get(review), "description");
    }

    @Test
    public void testSetBookID() throws NoSuchFieldException, IllegalAccessException {

        final Review review = new Review();

        review.setBookID(10);

        final Field bookID = review.getClass().getDeclaredField("bookID");
        bookID.setAccessible(true);
        assertEquals("Fields doesn't match", bookID.get(review), 10);
    }
}
