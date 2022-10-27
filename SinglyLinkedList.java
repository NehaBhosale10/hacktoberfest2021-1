
import java.util.*;
public class Linked_list {
    Node head;
    Node next;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ch,cont;
        Linked_list list = new Linked_list();
        do{
            System.out.println("-------------------MENU--------------------");
            System.out.println("1)DISPLAY\n2)CREATE A NEW NODE\n3)INSERT AT THE BEGINNING\n" +
                    "4)INSERT IN BETWEEN(BY POSITION)\n5)DELETE IN BETWEEN\n6)DELETE FIRST\n7)DELETE LAST" +
                    "\n8)DISPLAY FIRST\n9)DISPLAY LAST");
            System.out.println("Enter your choice");
            ch = sc.nextInt();
            switch(ch){
                case 2:
                    System.out.println("Enter data");
                    int data = sc.nextInt();
                    //Linked_list obj = new Linked_list();
                    //obj.create_list(data, list);
                    Linked_list.create_list(data, list);
                    Linked_list.display(list);
                    break;
                case 1:
                    System.out.println("-------------DISPLAYING---------");
                    Linked_list.display(list);
                    break;
                case 3:
                    System.out.println("Enter data");
                    int data1 = sc.nextInt();
                    Linked_list.insert_beg(data1, list);
                    Linked_list.display(list);
                    break;
                case 4:
                    System.out.println("Enter data");
                    int data2= sc.nextInt();
                    System.out.println("Enter the position where you want to add a new node");
                    int pos=sc.nextInt();
                    Linked_list.insert_bet(data2, list, pos);
                    Linked_list.display(list);
                    break;
                case 5:
                    System.out.println("Enter the position where you want to delete");
                    int pos1=sc.nextInt();
                    Linked_list.delete_between(list, pos1);
                    Linked_list.display(list);
                    break;
                case 6:
                    System.out.println("-------------DELETING FIRST--------------");
                    Linked_list.delete_first(list);
                    Linked_list.display(list);
                    break;
                case 7:
                    System.out.println("-------------DELETING LAST--------------");
                    Linked_list.delete_last(list);
                    Linked_list.display(list);
                    break;
                case 8:
                    System.out.println("------------DISPLAYING FIRST-------------");
                    Linked_list.display_first(list);
                    break;
                // Linked_list.display(list);
                case 9:
                    System.out.println("-----------DISPLAYING LAST--------------");
                    Linked_list.display_last(list);
                    break;
            }
            System.out.println();
            System.out.println("Do you want to continue?");
            System.out.println("Enter 1 to continue");
            cont = sc.nextInt();
        }while(cont == 1);


    }

    public static Linked_list create_list(int data,Linked_list list){
        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }
        else{
            Node last;
            last = list.head;
            while(last.next!=null){
                last = last.next;
            }
            last.next = new_node;
            //return list;
        }
        return list;
    }

    public static void display(Linked_list list){
        if(list.head == null){
            System.out.println("THE LIST IS EMPTY");
        }
        else{
            Node last;
            last = list.head;
            while(last!=null){
                System.out.print(last.data);
                System.out.print("  ->  ");
                last = last.next;

            }
            System.out.println();

        }

    }

    public static Linked_list insert_beg(int data,Linked_list list){
        Node new_node  = new Node(data);
        Node last;
        last=list.head;
        if(last==null){
            list.head=new_node;

        }
        else{
            new_node.next=last;
            list.head=new_node;

        }
        return list;
    }

    public static Linked_list insert_bet(int data,Linked_list list,int pos){
        Node new_node = new Node(data);
        Node last=list.head;
        int count=Linked_list.count(list);
        if(list.head==null){
            list.head=new_node;
        }
        else if(pos==1){
            new_node.next=last;
            list.head=new_node;
        }
        else if(count<pos){
            System.out.println("INVALID POSITION\nTHE POSITION DOES NOT EXIST");
            System.out.println("There exists"+count+"nodes");
        }
        else{
            //Node last=list.head;
            int i=1;
            while(last.next!=null && i<pos-1){
                last=last.next;
                i++;
            }
            new_node.next=last.next;
            last.next=new_node;

        }
        return list;
    }

    public static Linked_list delete_between(Linked_list list,int pos){
        int count=Linked_list.count(list);
        if(list.head==null){
            System.out.println("List is empty");
        }

        else if(pos>count){
            System.out.println("INVALID POSITION : POSITION DOES NOT EXIST");
            System.out.println("There exists" +count+ "nodes");
        }

        else{
            Node last;
            Node del;
            last = list.head;
            int i=1;
            while(last.next!=null && i<pos-1){
                i++;
                last=last.next;
            }
            del=last.next;
            last.next=del.next;
            del.next=null;
        }

        return list;
    }

    public static Linked_list delete_first(Linked_list list){
        if(list.head==null){
            System.out.println("List is empty");
        }
        else{
            Node last=list.head;
            list.head=last.next;
            last.next=null;
        }
        return list;
    }

    public static Linked_list delete_last(Linked_list list){
        if(list.head==null){
            System.out.println("LIST IS EMPTY");
        }
        else{
            Node last=list.head;
            while(last.next.next!=null){
                last=last.next;
            }
            last.next=null;




        }
        return list;
    }

    public static Linked_list display_first(Linked_list list){
        if(list.head==null){
            System.out.println("List is empty");
        }
        else{
            Node last=list.head;
            System.out.println(last.data);
        }
        return list;
    }

    public static Linked_list display_last(Linked_list list){
        if(list.head==null){
            System.out.println("List is empty");
        }
        else{
            Node last=list.head;
            while(last.next!=null){
                last=last.next;
            }
            System.out.println(last.data);
        }
        return list;
    }

    public static int count(Linked_list list){
        int count=0;
        if(list.head==null){
            count=0;
        }
        else{
            Node last=list.head;
            while(last!=null){
                last=last.next;
                count=count+1;
            }
        }


        return count;
    }
}
