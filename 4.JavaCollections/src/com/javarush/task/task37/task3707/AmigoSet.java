package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Cloneable, Serializable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;
    private static final long serialVersionUID = 362498820763181265L;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<>(Math.max(16, (int)(collection.size()/.75f)+1));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return  map.keySet().iterator();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() throws InternalError{
        try {
            AmigoSet<E> cloned = (AmigoSet<E>) super.clone();
            cloned.map = (HashMap<E, Object>) map.clone();
            return cloned;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    @Override
    public int size() {
        return map.size();
    }


    private void writeObject(java.io.ObjectOutputStream s)
            throws IOException {
        int buckets = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        // Write out the threshold, loadfactor, and any hidden stuff
        s.defaultWriteObject();
        s.writeInt(buckets);
        s.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
        s.writeInt(size());
        for (E e : map.keySet()) {
            s.writeObject(e);
        }
    }

    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int capacity = s.readInt();
        float loadFactor = s.readFloat();
        int size = s.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) {
            map.put((E)s.readObject(), PRESENT);
        }

    }
}
