package fr.esgi.aquarium.infra.service;

import fr.esgi.aquarium.domain.service.StringSearchMatching;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StringSearchMatchingTest {


    @Test
    public void is_fuzzy_matching_with_exact_value_with_100_threshold_should_return_true() {
        assertTrue(StringSearchMatching.isFuzzyMatching("test", "test",100));
    }

    @Test
    public void is_fuzzy_matching_with_not_exact_value_with_100_threshold_should_return_false() {
        assertFalse(StringSearchMatching.isFuzzyMatching("test", "tes",99));
    }

    @Test
    public void is_fuzzy_matching_test_with_different_value_with_80_threshold_should_return_false() {
        assertFalse(StringSearchMatching.isFuzzyMatching("test", "tarte",80));
    }
    @Test
    public void is_fuzzy_matching_test_with_different_value_with_60_threshold_should_return_true() {
        assertTrue(StringSearchMatching.isFuzzyMatching("test", "tarte",60));
    }

    @Test
    public void is_fuzzy_matching_test_with_different_value_with_40_threshold_should_return_true() {
        assertTrue(StringSearchMatching.isFuzzyMatching("test", "tarteeeee",40));
    }
    @Test
    public void is_fuzzy_matching_test_with_very_different_value_with_40_threshold_should_return_false() {
        assertTrue(StringSearchMatching.isFuzzyMatching("test", "deadCells",40));
    }

    @Test
    public void is_fuzzy_matching_test_with_very_different_value_with_20_threshold_should_return_false() {
        assertTrue(StringSearchMatching.isFuzzyMatching("test", "deadCells",20));
    }
    @Test
    public void levenshteinDistance_with_same_value_should_return_0() {
        assertEquals(0, StringSearchMatching.levenshteinDistance("test", "test"));
    }
    @Test
    public void levenshteinDistance_with_same_value_with_space_at_start_should_return_1() {
        assertEquals(1, StringSearchMatching.levenshteinDistance("test", " test"));
    }
    @Test
    public void levenshteinDistance_with_different_value_with_char_at_end_should_return_1() {
        assertEquals(1, StringSearchMatching.levenshteinDistance("test", "testo"));
    }

    @Test
    public void similarity_with_same_value_should_return_0() {
        assertEquals(0, StringSearchMatching.similarity("test", "test"), 0.1);
    }
    @Test
    public void similarity_with_different_value_should_return_1() {
        assertEquals(0.19, StringSearchMatching.similarity("test", " popo"), 0.1);
    }
}
