package ch12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LectureTest {

    private Lecture lecture;

    @BeforeEach
    void setUp() {
        lecture = new Lecture(60, "멀티미디어공학", List.of(100, 80, 65, 40, 10));
    }

    @Test
    @DisplayName("Lecture 객체 생성")
    void t1() throws Exception {
        //then
        assertThat(lecture).isNotNull();
    }

    @Test
    @DisplayName("Lecture format print")
    void t2() throws Exception {
        //when
        final String formatStr = lecture.getFormatString();
        //then
        assertThat(formatStr).isEqualTo("Pass:3 Fail:2\n");
    }
}