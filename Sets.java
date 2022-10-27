import java.util.Scanner;
public class Set_Operation {
    //int cardA,cardB;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set_Working obj = new Set_Working();
        int cardA=0;
        int cardB=0;
        int cont;
        
        System.out.println("Enter the cardinality of set A");
        cardA=sc.nextInt();

        int a[] = new int[cardA];
        obj.accept(cardA,a);

        System.out.println("Enter the cardinality of set B");
        cardB=sc.nextInt();

        int b[] = new int[cardB];
        obj.accept(cardB,b);

        //display
        System.out.println("SET A ELEMENTS: ");
        obj.display(cardA,a);
        System.out.println("SET B ELEMENTS: ");
        obj.display(cardB,b);
        do{
            System.out.println("-------------------MENU--------------------");
            System.out.println("Enter your choice");
            System.out.println("0)EXIT\n1)UNION\n2)INTERSECTION\n3)SET A - SET B\n4)SETB - SETA\n5)SYMMETRIC DIFFERENCE");
            System.out.println("-------------------------------------------");
            int ch = sc.nextInt();
            switch(ch){
                case 0:
                    System.out.println("EXITING");
                    break;
                case 1:
                    //union
                    int us[]=new int[cardA+cardB];
                    int cardus=obj.union(a, cardA, b, cardB, us);
                    System.out.println("UNION SET");
                    obj.display(cardus, us);
                    break;
                case 2:
                    //intersection
                    int is[]=new int[cardA+cardB];
                    int cardis = obj.intersection(a, cardA, b, cardB, is);
                    System.out.println("INTERSECTION SET");
                    obj.display(cardis, is);
                    break;
                case 3:
                    //difference of a-b
                    int diff[] = new int[cardA+cardB];
                    int carddiffab = obj.difference(a, cardA, b, cardB, diff);
                    System.out.println("DIFFERENCE OF A-B");
                    obj.display(carddiffab, diff);
                    break;
                case 4:
                    //DIFFERENCE OF B-A
                    int diff1[] = new int[cardA+cardB];
                    System.out.println("DIFFERENCE OF B-A");
                    int carddiffba = obj.difference(b, cardB, a, cardA, diff1);
                    obj.display(carddiffba,diff1);
                    break;
                case 5:
                    //symmetric difference
                    System.out.println("SYMMETRIC DIFFERENCE");
                    int symmdiff[] = new int[cardA+cardB];
                    int diff2[] = new int[cardA+cardB];
                    int carddiffab2= obj.difference(a, cardA, b, cardB, diff2);
                    int diff3[] = new int[cardA+cardB];
                    int carddiffba3 = obj.difference(b, cardB, a, cardA, diff3);
                    int cardsymmdiff = obj.union(diff2, carddiffab2, diff3, carddiffba3, symmdiff);
                    obj.display(cardsymmdiff, symmdiff);
                    break;
                default:
                    System.out.println("INVALID CHOICE ENTERED");
                    System.out.println("EXITING");
                    break;
            }
            System.out.println("--------------------------------------");
            System.out.println("DO YOU WANT TO CONTINUE?");
            System.out.println("ENTER 1 TO CONTINUE\n0 TO EXIT");
            cont=sc.nextInt();

        }while(cont==1);
    }
}

class Set_Working extends Set_Operation{
    Scanner sc = new Scanner(System.in);
    void accept(int card,int n[]){
        System.out.println("Enter the elements");
        n[0]= sc.nextInt();
        for(int i=1;i<(card);i++){
            n[i] = sc.nextInt();
            for(int j=0;j<i;j++){
                if(n[i]==n[j]){
                    System.out.println("Element already exists");
                    System.out.println("Enter the elements");
                    int e = sc.nextInt();
                    n[i]=e;
                }
            }
        }
    }

    void display(int card,int n[]){
        //System.out.println("The elements are: ");
        System.out.print("{");
        for(int i=0;i<card;i++){
            System.out.print(n[i]);
            System.out.print(" ");
        }
        System.out.print("}");
        System.out.println();

    }

    int union(int a[],int cardA,int b[],int cardB,int us[]){
        int i,j,k=0;
        int cardK=0;
        for(i=0;i<cardA;i++){
            us[k]=a[i];
            k++;
        }
        for(j=0;j<cardB;j++){
            int flag=0;
            for(i=0;i<cardA;i++){
                if(b[j]==a[i]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                us[k]=b[j];
                k++;
            }
        }
        cardK=k;
        return k;
    }

    int intersection(int a[],int cardA,int b[],int cardB,int is[]){
        int i,j,k=0;
        int cardK=0;
        for(j=0;j<cardB;j++){
            int flag=0;
            for(i=0;i<cardA;i++){
                if(b[j]==a[i]){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                is[k]=b[j];
                k++;
            }
        }
        cardK=k;
        return k;
    }

    int difference(int a[],int cardA,int b[],int cardB,int diff[]){
        int i,j,k=0;
        int cardK=0;
        for(i=0;i<cardA;i++){
            int flag=0;
            for(j=0;j<cardB;j++){
                if(a[i]==b[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                diff[k]=a[i];
                k++;
            }
        }
        cardK=k;
        return k;
    }
}
