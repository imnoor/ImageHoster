package ImageHoster.model;

import javax.persistence.*;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity

//@Table annotation provides more options to customize the mapping.
//Set the table name to be comments
@Table(name = "comments")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "crated_date")
    private String cratedDate;

    //The 'comments' table is mapped to 'users' table with Many:One mapping
    //One comment can have only one user (owner) but one user can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //The 'comments' table is mapped to 'image' table with Many:One mapping
    //One comment can have only one image but one image can have multiple comments
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image img;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(String cratedDate) {
        this.cratedDate = cratedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Comment() {
    }


}
