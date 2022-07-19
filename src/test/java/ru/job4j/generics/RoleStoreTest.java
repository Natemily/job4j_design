package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fighter"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Fighter"));
    }

    @Test
    public void whenAddAndFindThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mage"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Slayer"));
        store.add(new Role("1", "Tank"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Slayer"));
    }

    @Test
    public void whenReplaceThenUsernameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mage"));
        store.replace("1", new Role("1", "Fighter"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Fighter"));
    }

    @Test
    public void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Tank"));
        store.replace("10", new Role("10", "Fighter"));
        Role result = store.findById("1");
        assertThat(result.getUsername(), is("Tank"));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Mage"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Slayer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getUsername(),is("Slayer"));
    }
}