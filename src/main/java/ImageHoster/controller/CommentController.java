package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    //This controller method is called when new comment is posted by user
    // to the POST request URL ‘/image/{imageId}/{imageTitle}/comments’ for creating a new comment.
    // NOTE :: the imageTitle part in this url isnt really required, but maintained as its a requirement
    // After persisting the comment in the database
    // the controller redirect to the same page displaying all the details of that particular image.
    // Redirect to ‘showImage()’ method in ‘ImageController’ class
    @RequestMapping(value = "/image/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String newComment(@PathVariable("imageId") Integer imageId, @PathVariable("title") String title, @RequestParam("comment") String commentText, HttpSession session) {
        Comment comment = new Comment();
        comment.setText(commentText);
        User user = (User) session.getAttribute("loggeduser");
        comment.setUser(user);
        Image image = imageService.getImage(imageId);
        comment.setImage(image);
        comment.setCreatedDate(new Date());
        commentService.saveComment(comment);
        // redirect to the image and its details page.
        return "redirect:/images/" +imageId + "/" + title ;
    }
}
