/**
 * Created by arogoz on 7/4/2014.
 */


public class MyHashMap implements My_Iterator {


    public static int arrMapSize = 2;

    public MyList[] myHashMap = new MyList[arrMapSize];

    public static int usedIndex = 0;

    public MyEntity current = null;


    public void add(String key, Object obj) {


        current = new MyEntity(key, obj);

        int index = Math.abs(key.hashCode() % arrMapSize);

        if (myHashMap[index] == null) {

            MyList myList = new MyList();

            myHashMap[index] = myList;

            myHashMap[index].addFirst(current);

            MyHashMap.usedIndex++;

        } else {

            myHashMap[index].addAfterLast(current);

        }


        if ((double) (usedIndex / arrMapSize) > 0.7) {

            arrMapSize = arrMapSize * 2;

            myHashMap = reLocate(arrMapSize);


        }


    }


    public Object getObjectByKey(String key) {

        int i = Math.abs(key.hashCode() % arrMapSize);

        return myHashMap[i].getObjectByKey(key);

    }


    public void print() {

        for (int i = 0; i <= myHashMap.length - 1; i++) {

            if (myHashMap[i] != null) {

                System.out.println("List" + " " + i);

                myHashMap[i].printList();

            } else {

                System.out.println("List " + i + " is empty");

            }

        }

    }


    private MyList[] reLocate(int arrMapSize) {

        MyList[] newMyHashMap = new MyList[arrMapSize];

        Integer newIndex = 0;

        for (int i = 0; i < myHashMap.length; i++) {

            myHashMap[i].current = myHashMap[i].head;

            while (myHashMap[i].current != null) {

                newIndex = Math.abs(myHashMap[i].getCurrentEntity().getKey().hashCode() % MyHashMap.arrMapSize);

                if (newMyHashMap[newIndex] == null) {

                    MyList myNewList = new MyList();

                    newMyHashMap[newIndex] = myNewList;

                    newMyHashMap[newIndex].addFirst(myHashMap[i].getCurrentEntity());

                } else {

                    newMyHashMap[newIndex].addAfterLast(myHashMap[i].getCurrentEntity());

                }

                myHashMap[i].getNext();


            }


        }

        return newMyHashMap;


    }


    public Object getNext() {
        int currentListId = Math.abs(current.getKey().hashCode() % MyHashMap.arrMapSize);
        Object next = null;
        if (myHashMap[currentListId] != null) {
            if (myHashMap[currentListId].getNext() != null) {
                next = myHashMap[currentListId].getNext();
            } else {
                currentListId++;
                if (currentListId<myHashMap.length) {
                    if (myHashMap[currentListId] != null) {
                        next = myHashMap[currentListId].getFirst();
                    }
                }
            }

        }
        return next;
    }

    public MyEntity getPrevious() {
        MyEntity prev = null;
        return prev;

    }

    public void printMap() {
        for (int i = 0; i < arrMapSize; i++) {
            if (myHashMap[i] == null) {
            } else {
                current = new MyEntity(myHashMap[i].getFirstKey(), myHashMap[i].getFirst());
                do {
                    System.out.print(current.getObject());
                    myHashMap[i].getNext();
                } while (current == null);

            }
            System.out.println();
            getNext();
        }
    }
}
