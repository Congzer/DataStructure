package com.congzer.array;

/*数组索引可以有语义，也可以没有语义*/
/*数组最大的优点：快速查询，故数组最好应用于“索引有语义”的情况*/
/*但并非所有有语义的索引都适用于数组， 比如身份证号*/

//自定义数组类
public class Array<E> {

    private E[] data;

    //数组元素个数
    private int size;

    // 传入所需要的数组的容量来构造数据
    public Array(int capacity) {

        data = (E[]) new Object[capacity];
        size = 0;
    }

    //默认容量为10
   public Array() {

        this(10);
   }

    public Array(E[] arr) {

        data = (E[])new Object[arr.length];
        for (int i = 0, len = arr.length; i < len; i++) {

            data[i] = arr[i];
        }
        size = arr.length;
    }

   //传入静态数组，生成Array对象
   public Array(int...ints) {

        size = ints.length;
        data = (E[]) new Object[size];
        System.arraycopy(ints, 0, data, 0, size);
   }

   //获取元素个数
    public int getSize() {

        return size;
    }

    //获取数组的容量
    public int getCapacity() {

        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {

        return size == 0;
    }

    /*===================================================往数组中添加元素   时间复杂度 O(n)================================================*/
    //向数组末尾添加元素
    public void addLast(E e) {

        /*if (size == data.length) {

            throw new IllegalArgumentException("addLast fail. Array is full.");
        }
        data[size] = e;
        size++;*/
        add(size, e);
    }

    //向数组开头添加元素
    public void addFirst(E e) {

        add(0, e);
    }

    //向数组中指定位置添加元素
    public void add(int index, E e) {

        if (size == data.length) {

            //throw new IllegalArgumentException("add fail. Array is full.");
            resize(2*data.length);
        }
        if (index < 0 || index > size) {

            throw new IllegalArgumentException("add fail. Require index >=0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--) {

            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //时间复杂度O(n), 考虑到不是每次addLast都会出触发该方法，均摊计算后，均摊复杂度为O(1)
    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {

            newData[i] = data[i];
        }
        data = newData;
    }

    /*===================================================在数组中查询元素       时间复杂度 O(n)================================================*/

    //取出索引对应的元素  O(1)
    public E get(int index) {

        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("get fail. Index is illegal");
        }
        return data[index];
    }

    public E getLast() {

        return get(size - 1);
    }

    public E getFirst() {

        return get(0);
    }

    //判断数组中是否存在某值  O(n)
    public boolean contains(E e) {

        for (E datum : data) {

            if (datum.equals(e)) {

                return true;
            }
        }
        return false;
    }

    //找元素索引  O(n)
    public int find(E e) {

        for (int i = 0; i < size; i++) {

            if (data[i].equals(e)) {

                return i;
            }
        }
        return -1;
    }

    public int[] findAll(E e) {

        int[] indexes = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {

            if (data[i].equals(e)) {

                indexes[j] = i;
                j++;
            }
        }
        if (j > 0) {

            int[] newIndexes = new int[j];
            for (int i = 0; i < j; i++) {

                newIndexes[i] = indexes[i];
            }
            return newIndexes;
        }
        return new int[0];
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {

            res.append(data[i]);
            if (i != size -1){

                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /*===================================================在数组中修改元素       时间复杂度 O(1)================================================*/

    //往指定索引添加值
    public void set(int index, E e) {

        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("set fail. Index is illegal");
        }
        data[index] = e;
    }
    /*===================================================删除数组中元素      时间复杂度 O(n)================================================*/
    public E remove(int index) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("remove fail. index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {

            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //loitering object != memory leak   jvm中会清除没有被引用的对象
        if (size == data.length / 4 && data.length / 2 != 0) {  //size == data.length / 4 Lazy 避免复杂度震荡

            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {

        return remove(0);
    }

    public E removeLast() {

        return remove(size-1);
    }

    public boolean removeElement(E e) {

        int index = find(e);
        if (index != -1) {

            remove(index);
            return true;
        }
        return false;
    }

    public boolean removeAllElement(E e) {

        int[] all = findAll(e);
        for (int i : all) {

            remove(i);
        }
        return all.length > 0;
    }

    public void swap(int index, int parent) {

        E tem = data[parent];
        data[parent] = data[index];
        data[index] = tem;
    }
}