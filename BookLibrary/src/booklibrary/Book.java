/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booklibrary;

/**
 *
 * @author D E L L
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int pageno;

    public Book(int id, String title, String author, int pageno) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageno = pageno;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageno() {
        return pageno;
    }
    
    
}
