package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private int size;

    public CustomTree() {
        this.root = new Entry<>("0");
        size = 0;
    }

    public String getParent(String s) {
        String name = null;
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry curr = queue.poll();
            if (curr.elementName.equals(s)) {
                return curr.parent.elementName;
            } else {
                if (curr.rightChild != null)
                    queue.add(curr.rightChild);
                if (curr.leftChild != null)
                    queue.add(curr.leftChild);
            }
        }
        return name;
    }

    @Override
    public boolean remove(Object o) {
        String name;
        if (o instanceof String)
            name = (String) o;
        else
            throw new UnsupportedOperationException();
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry curr = queue.poll();
            if (curr.rightChild != null) {
                if (curr.rightChild.elementName.equals(name)) {
                    curr.rightChild = null;
                    recount();
                    return true;
                } else
                    queue.add(curr.rightChild);
            }
            if (curr.leftChild != null) {
                if (curr.leftChild.elementName.equals(name)) {
                    curr.leftChild = null;
                    recount();
                    return true;
                } else
                 queue.add(curr.leftChild);
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        Entry<String> elem = new Entry<>(s);
        boolean isAdded = false;
        while (!queue.isEmpty()) {
            Entry curr = queue.poll();
            if (!curr.isAvailableToAddChildren()) {
                if (curr.leftChild != null)
                    queue.add(curr.leftChild);
                if (curr.rightChild != null)
                    queue.add(curr.rightChild);
            } else {
                if (curr.availableToAddLeftChildren) {
                    curr.leftChild = elem;
                    curr.availableToAddLeftChildren = false;
                    isAdded = true;
                } else {
                    curr.rightChild = elem;
                    curr.availableToAddRightChildren = false;
                    isAdded = true;
                }
                elem.parent = curr;
                queue.clear();
            }
        }
        if (isAdded)
            size++;
        else {
            //tree is dead
            queue.add(root);
            while (!queue.isEmpty()) {
                Entry curr = queue.poll();
                if (curr.leftChild != null)
                    queue.add(curr.leftChild);
                else
                    curr.availableToAddLeftChildren = true;
                if (curr.rightChild != null)
                    queue.add(curr.rightChild);
                else
                    curr.availableToAddRightChildren = true;
            }
            return add(s);

        }
        return isAdded;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    private void recount(){
        Queue<Entry> queue = new ArrayDeque<>();
        queue.add(root);
        size = -1;
        while (!queue.isEmpty()) {
            size++;
            Entry curr = queue.poll();
            if (curr.rightChild != null) {
                queue.add(curr.rightChild);
            }
            if (curr.leftChild != null) {
                queue.add(curr.leftChild);
            }
        }
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren || availableToAddLeftChildren;
        }
    }
}
