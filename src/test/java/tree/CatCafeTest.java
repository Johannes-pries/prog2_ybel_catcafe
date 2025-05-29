package tree;

import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class CatCafeTest {

    @Test
    public void testAddSingleCat() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Mimi", 4));
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    public void testAddMultipleCats() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Mimi", 4));
        cafe.addCat(new FelineOverLord("Luna", 3));
        cafe.addCat(new FelineOverLord("Tiger", 5));
        assertEquals(3, cafe.getCatCount());
    }

    @Test
    public void testGetCatByNameExists() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Luna", 3));
        Optional<FelineOverLord> cat = cafe.getCatByName("Luna");
        assertTrue(cat.isPresent());
        assertEquals("Luna", cat.get().name());
    }

    @Test
    public void testGetCatByNameNotExists() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Luna", 3));
        Optional<FelineOverLord> cat = cafe.getCatByName("Tiger");
        assertFalse(cat.isPresent());
    }

    @Test
    public void testGetCatByNameNull() {
        CatCafe cafe = new CatCafe();
        Optional<FelineOverLord> cat = cafe.getCatByName(null);
        assertNull(cat);
    }

    @Test
    public void testGetCatByWeightExists() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Luna", 3));
        cafe.addCat(new FelineOverLord("Tiger", 5));
        Optional<FelineOverLord> cat = cafe.getCatByWeight(3, 4);
        assertTrue(cat.isPresent());
        assertEquals(3, cat.get().weight());
    }

    @Test
    public void testGetCatByWeightNotExists() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Luna", 3));
        Optional<FelineOverLord> cat = cafe.getCatByWeight(5, 6);
        assertFalse(cat.isPresent());
    }

    @Test
    public void testGetCatByWeightInvalidRange() {
        CatCafe cafe = new CatCafe();
        Optional<FelineOverLord> cat = cafe.getCatByWeight(5, 3);
        assertNull(cat);
    }

    @Test
    public void testGetCatByWeightNegativeMin() {
        CatCafe cafe = new CatCafe();
        Optional<FelineOverLord> cat = cafe.getCatByWeight(-1, 3);
        assertNull(cat);
    }

    @Test
    public void testAddDuplicateCat() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Luna", 3));
        cafe.addCat(new FelineOverLord("Luna", 3));
        assertEquals(1, cafe.getCatCount());
    }
}