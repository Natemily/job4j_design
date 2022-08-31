package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void getNumberOfVerticesForTetrahedron() {
        Box box = new Box(4, 6);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesForSphere() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(0);
    }

    @Test
    void getNumberOfVerticesForUnknown() {
        Box box = new Box(2, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(-1);
    }

    @Test
    void isExist() {
        Box box = new Box(8, 12);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void isNoExist() {
        Box box = new Box(1, 5);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();
    }

    @Test
    void getAreaOfCube() {
        Box box = new Box(8, 12);
        double area = box.getArea();
        assertThat(area).isEqualTo(864);
    }

    @Test
    void getAreaOfUnknown() {
        Box box = new Box(2, 5);
        double area = box.getArea();
        assertThat(area).isEqualTo(0);
    }
}