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
import java.io.IOException;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;



    //This controller method is called when new comment is posted by user
    // to the POST request URL ‘/image/{imageId}/{imageTitle}/comments’ for creating a new comment.
    // After persisting the comment in the database
    // the controller redirect to the same page displaying all the details of that particular image.
    // Redirect to ‘showImage()’ method in ‘ImageController’ class
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String newComment(@PathVariable("imageId") Integer imageId, @RequestParam("comment") String commentText, HttpSession session) throws IOException {
        Comment comment = new Comment();
        comment.setText(commentText);
        User user = (User) session.getAttribute("loggeduser");
        comment.setUser(user);
        Image image = imageService.getImage(imageId);
        comment.setImage(image);
        comment.setCratedDate(new Date());
        commentService.saveComment(comment);
        return "redirect:/images/" +imageId ;
    }
}
