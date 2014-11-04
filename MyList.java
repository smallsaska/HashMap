/**
 * Created by arogoz on 7/4/2014.
 */

public class MyList implements My_Iterator {


    MyRecord head;

    MyRecord last;

    MyRecord current;


    public void MyList() {


    }


    public void addFirst(MyEntity entity) {

        MyRecord myReco = new MyRecord(entity.getKey(), entity.getObject());

        this.head = myReco;

        this.last = head;

        myReco.next = null;

        myReco.previous = null;




    }


    public void addBeforeFirst(MyEntity entity) {

        MyRecord myReco = new MyRecord(entity.getKey(), entity.getObject());

        MyRecord oldReco = this.head;

        this.head = myReco;

        myReco.next = oldReco;

        myReco.previous = null;




    }


    public void addAfterLast(MyEntity entity) {

        MyRecord myReco = new MyRecord(entity.getKey(), entity.getObject());

        this.last.next = myReco;

        myReco.previous = this.last;

        myReco.next = null;

        this.last = myReco;



    }


    public Object getFirst() {

        current = head;

        if (this != null) {

            return this.head;

        } else return null;


    }

    public String getFirstKey() {

        String key = new String();
        current = head;
        key = current.key;

        return key;
    }

    public MyRecord getLast() {

        do {

            this.current = (MyRecord) this.getNext();

        } while (this.current.next == null);

        return this.current;

    }


    public Object getNext() {

        if (current != null) {
            current = current.next;
        }

        return current;


    }

    public Object getPrevious() {


        current = current.previous;

        return current;


    }


    public void printList() {

        int i = 0;

        this.current = this.head;

        do {

            System.out.println("Element" + " " + i);

            this.current.printReco();

            i++;

        } while (this.getNext() != null);

    }


    public MyEntity getCurrentEntity() {

        return new MyEntity(current.key, current.object);

    }


    public Object getObjectByKey(String key) {

        boolean isFound = false;

        Object found = null;

        while (this.current == this.last) {

            if (this.current.key.equals(key)) {

                this.getNext();

            } else {

                found = current.object;

                isFound = true;

            }

            if (!isFound) {

                System.out.println("There is no such key");

            }

        }

        return found;

    }


    private class MyRecord {

        public MyRecord previous;

        public String key;

        public Object object;

        public MyRecord next;


        public MyRecord(String key, Object object) {

            this.key = key;

            this.object = object;

        }


        @Override

        public String toString() {

            return key + " " + object.toString();

        }


        public void printReco() {

            System.out.println(this.key + this.object);

        }


    }


}

 

 

 

 