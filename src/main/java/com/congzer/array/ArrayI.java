package com.congzer.array;

public interface ArrayI<E> {

   // 考虑到扩容，平均O(1)
   void addLast(E e);

   // O(n)
   void addFirst(E e);

   // O(n)
   void add(int index, E e);

   // O(1)
   E get(int index);

   // O(1)
   E getLast(int index);

   // O(1)
   E getFirst(int index);

   // O(n)
   boolean contains(E e);

   // O(n)
   int find(E e);

   // O(n)
   int[] findAll(E e);

   // O(1)
   void set(int index, E e);

   // O(n)
   E remove(int index);
}