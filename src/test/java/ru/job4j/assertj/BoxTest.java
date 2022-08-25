package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }
    @Test
    void isThisNotSphere() {
        Box box = new Box(-1, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }
    @Test
    void whenGetNumberOfVert() {
        Box box = new Box(4, 10);
        int vert = box.getNumberOfVertices();
        assertThat(vert).isEqualTo(4);
    }
    @Test
    void whenBoxIsExist() {
        Box box = new Box(4, 10);
        assertThat(box.isExist()).isTrue();
    }
    @Test
    void whenBoxIsNotExist() {
        Box box = new Box(3, 10);
        assertThat(box.isExist()).isFalse();
    }
    @Test
    void whenGetAreaTetrahedron() {
        Box box = new Box(4, 2);
        assertThat(box.getArea()).isEqualTo(6.928203230275509);
    }
    @Test
    void whenGetAreaCube() {
        Box box = new Box(8, 1);
        assertThat(box.getArea()).isEqualTo(6.0);
    }
}