class Node{
    String book_name;
    String id;
    String author;
    String student_name;
    String roll_num;
    Node next;
    Node prev;
    Node(){
        book_name = "";
        id = "";
        author = "";
        student_name = "-";
        roll_num ="-";
        next = null;
        prev = null;
    }
    Node(String book_name, String id, String author, String student_name,String roll_num){
        this.book_name = book_name;
        this.id = id;
        this.author =author;
        this.student_name = student_name;
        this.roll_num = roll_num;
        next = null;
        prev = null;
    }
}




