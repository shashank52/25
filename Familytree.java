/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Person {
    String Name;
    String Gender;
    String Type;
    Person(String name, String gender, String type)
    {
        this.Name = name;
        this.Gender = gender;
        this.Type = type;
    }
}
class Node {
    Person member;
    Person partner;
    ArrayList<Node> child;
    Node(Person p1, Person p2)
    {
        this.member = p1;
        this.partner = p2;
        child = new ArrayList<Node>();
    }
}
class Graph {
    Node src;
    public void initialize()
    {
        src = new Node(new Person("King Shan","Male","member"),new Person("Queen Anga","Female","member"));
        src.child.add(new Node(new Person("Chit","Male","member"),new Person("Amba","Female","partner")));
        src.child.add(new Node(new Person("Ish","Male","member"),null));
        src.child.add(new Node(new Person("Vich","Male","member"),new Person("Lika","Female","partner")));
        src.child.add(new Node(new Person("Aras","Male","member"),new Person("Chitra","Female","partner")));
        src.child.add(new Node(new Person("Satya","Female","member"),new Person("Vyan","Male","partner")));
        src.child.get(0).child.add(new Node(new Person("Dritha","Female","member"),new Person("Jaya","Male","partner")));
        src.child.get(0).child.add(new Node(new Person("Tritha","Female","member"),null));
        src.child.get(0).child.add(new Node(new Person("Vritha","Male","member"),null));
        src.child.get(0).child.get(0).child.add(new Node(new Person("Yodhan","Male","member"),null));
        src.child.get(2).child.add(new Node(new Person("Vila","Female","member"),null));
        src.child.get(2).child.add(new Node(new Person("Chika","Female","member"),null));
        src.child.get(3).child.add(new Node(new Person("Jnki","Female","member"),new Person("Arit","Male","partner")));
        src.child.get(3).child.add(new Node(new Person("Ahit","Male","member"),null));
        src.child.get(3).child.get(0).child.add(new Node(new Person("Laki","Male","member"),null));
        src.child.get(3).child.get(0).child.add(new Node(new Person("Lavnya","Female","member"),null));
        src.child.get(4).child.add(new Node(new Person("Asva","Male","member"),new Person("Satvy","Female","partner")));
        src.child.get(4).child.add(new Node(new Person("Vyas","Male","member"),new Person("Krpi","Female","partner")));
        src.child.get(4).child.add(new Node(new Person("Atya","Female","member"),null));
        src.child.get(4).child.get(0).child.add(new Node(new Person("Vasa","Male","member"),null));
        src.child.get(4).child.get(1).child.add(new Node(new Person("Kriya","Male","member"),null));
        src.child.get(4).child.get(1).child.add(new Node(new Person("Krithi","Female","member"),null));
    }
    public void BFS()
    {
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(src);
        while(!qu.isEmpty())
        {
            Node t = qu.remove();
            System.out.print(t.member.Name+", "+t.member.Gender);
            if(t.partner!=null)
                System.out.println(" "+t.partner.Name+", "+t.partner.Gender);
            else
                System.out.println();
            for(int i=0;i<t.child.size();i++)
            {
                qu.add(t.child.get(i));
            }
        }
    }
	public static void main (String[] args) {
		System.out.println("GfG!");
		Graph g = new Graph();
		g.initialize();
		g.BFS();
	}
}